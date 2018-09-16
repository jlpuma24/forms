package com.ergomotions.viewModels

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import android.graphics.drawable.Drawable
import com.ergomotions.R
import com.ergomotions.di.helpers.IResourceProvider
import com.ergomotions.util.Constants.PAIN_AGO_LIST
import com.ergomotions.util.Constants.PAIN_DURATION_LIST
import com.ergomotions.util.Constants.PAIN_INTENSITY_LIST
import com.ergomotions.util.Constants.PAIN_LEVEL_LIST
import com.ergomotions.util.Constants.PAIN_LEVEL_WORK_LIST
import com.ergomotions.util.Constants.PAIN_PRESENTED_HOW_LIST
import com.ergomotions.util.Constants.PAIN_WHEN_LIST
import com.ergomotions.util.EnglishConstants
import com.ergomotions.util.toObservable
import com.google.gson.annotations.SerializedName
import io.reactivex.disposables.CompositeDisposable
import java.util.*

abstract class GeneralViewModel(resourceProvider: IResourceProvider) : LifecycleObserver {

    // This is in case the want to change the question for a muscular group, otherwise we just need to add them to teh xml
    val headerBanner = ObservableField<Drawable>()
    val headerDescription = ObservableField<String>()
    val firstQuestion = ObservableField<String>()
    val secondQuestion = ObservableField<String>()
    val thirdQuestion = ObservableField<String>()
    val forthQuestion = ObservableField<String>()
    val fifthQuestion = ObservableField<String>()
    val sixQuestion = ObservableField<String>()
    val sevenQuestion = ObservableField<String>()
    val eightQuestion = ObservableField<String>()

    // Im putting some generic data
    val secondQuestionEntries = ObservableField<List<String>>(if (Locale.getDefault().language == "en") EnglishConstants.PAIN_PRESENTED_HOW_LIST else PAIN_PRESENTED_HOW_LIST)
    val thirdQuestionEntries = ObservableField<List<String>>(if (Locale.getDefault().language == "en") EnglishConstants.PAIN_WHEN_LIST else PAIN_WHEN_LIST)
    val forthQuestionEntries = ObservableField<List<String>>(if (Locale.getDefault().language == "en") EnglishConstants.PAIN_AGO_LIST else PAIN_AGO_LIST)
    val fifthQuestionEntries = ObservableField<List<String>>(if (Locale.getDefault().language == "en") EnglishConstants.PAIN_DURATION_LIST else PAIN_DURATION_LIST)
    val sixQuestionEntries = ObservableField<List<String>>(PAIN_INTENSITY_LIST.map { it.toString() })
    val sevenQuestionEntries = ObservableField<List<String>>(if (Locale.getDefault().language == "en") EnglishConstants.PAIN_LEVEL_LIST else PAIN_LEVEL_LIST)
    val eightQuestionEntries = ObservableField<List<String>>(if (Locale.getDefault().language == "en") EnglishConstants.PAIN_LEVEL_WORK_LIST else PAIN_LEVEL_WORK_LIST)

    // Answers
    val secondAnswer = ObservableField<String>(if (Locale.getDefault().language == "en") EnglishConstants.PAIN_PRESENTED_HOW_LIST.first() else PAIN_PRESENTED_HOW_LIST.first())
    val thirdAnswer = ObservableField<String>(if (Locale.getDefault().language == "en") EnglishConstants.PAIN_WHEN_LIST.first() else PAIN_WHEN_LIST.first())
    val forthAnswer = ObservableField<String>(if (Locale.getDefault().language == "en") EnglishConstants.PAIN_AGO_LIST.first() else PAIN_AGO_LIST.first())
    val fifthAnswer = ObservableField<String>(if (Locale.getDefault().language == "en") EnglishConstants.PAIN_DURATION_LIST.first() else PAIN_DURATION_LIST.first())
    val sixAnswer = ObservableField<String>(PAIN_INTENSITY_LIST.map { it.toString() }.first())
    val sevenAnswer = ObservableField<String>(if (Locale.getDefault().language == "en") EnglishConstants.PAIN_LEVEL_LIST.first() else PAIN_LEVEL_LIST.first())
    val eightAnswer = ObservableField<String>(if (Locale.getDefault().language == "en") EnglishConstants.PAIN_LEVEL_WORK_LIST.first() else PAIN_LEVEL_WORK_LIST.first())

    // First Answer Observables
    val firstButton = ObservableBoolean(false)
    val secondButton = ObservableBoolean(false)
    val thirdButton = ObservableBoolean(false)

    private val buttonsDisposables = CompositeDisposable()

    init {
        headerDescription.set(resourceProvider.getString(R.string.common_first))
        secondQuestion.set(resourceProvider.getString(R.string.common_question_b))
        thirdQuestion.set(resourceProvider.getString(R.string.common_question_c))
        forthQuestion.set(resourceProvider.getString(R.string.common_question_d))
        fifthQuestion.set(resourceProvider.getString(R.string.common_question_e))
        sixQuestion.set(resourceProvider.getString(R.string.common_question_f))
        sevenQuestion.set(resourceProvider.getString(R.string.common_question_g))
        eightQuestion.set(resourceProvider.getString(R.string.common_question_h))
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        buttonsDisposables.add(firstButton.toObservable().doOnNext { first ->
            when {
                first && secondButton.get() -> secondButton.set(false)
                first && thirdButton.get() -> thirdButton.set(false)
            }
        }.subscribe())

        buttonsDisposables.add(secondButton.toObservable().doOnNext { second ->
            when {
                second && firstButton.get() -> firstButton.set(false)
                second && thirdButton.get() -> thirdButton.set(false)
            }
        }.subscribe())

        buttonsDisposables.add(thirdButton.toObservable().doOnNext { third ->
            when {
                third && firstButton.get() -> firstButton.set(false)
                third && secondButton.get() -> secondButton.set(false)
            }
        }.subscribe())
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        buttonsDisposables.clear()
    }

    open fun provideData(): GeneralFormData {
        return GeneralFormData(firstResponse = getFirstResponseBaseOnButtons(),
                secondResponse = getSecondAnswerIndex(),
                thirdResponse = getThirdAnswerIndex(),
                forthResponse = getForthAnswerIndex(),
                fifthResponse = getFifthAnswerIndex(),
                sixResponse = getSixAnswerIndex(),
                sevenResponse = getSevenAnswerIndex(),
                eightResponse = getEightAnswerIndex())
    }

    private fun getFirstResponseBaseOnButtons(): Int {
        return when {
            firstButton.get() -> 0
            secondButton.get() -> 1
            thirdButton.get() -> 2
            else -> -1
        }
    }

    private fun getSecondAnswerIndex(): Int {
        return EnglishConstants.PAIN_PRESENTED_HOW_LIST.indexOfFirst { secondAnswer.get() == it }
                .takeIf { it != -1 }
                ?: PAIN_PRESENTED_HOW_LIST.indexOfFirst { secondAnswer.get() == it }
    }

    private fun getThirdAnswerIndex(): Int {
        return EnglishConstants.PAIN_WHEN_LIST.indexOfFirst { thirdAnswer.get() == it }
                .takeIf { it != -1 } ?: PAIN_WHEN_LIST.indexOfFirst { thirdAnswer.get() == it }
    }

    private fun getForthAnswerIndex(): Int {
        return EnglishConstants.PAIN_AGO_LIST.indexOfFirst { forthAnswer.get() == it }
                .takeIf { it != -1 } ?: PAIN_AGO_LIST.indexOfFirst { forthAnswer.get() == it }
    }

    private fun getFifthAnswerIndex(): Int {
        return EnglishConstants.PAIN_DURATION_LIST.indexOfFirst { fifthAnswer.get() == it }
                .takeIf { it != -1 } ?: PAIN_DURATION_LIST.indexOfFirst { fifthAnswer.get() == it }
    }

    private fun getSixAnswerIndex(): Int {
        return PAIN_INTENSITY_LIST.indexOfFirst { sixAnswer.get()?.toInt() == it }
    }

    private fun getSevenAnswerIndex(): Int {
        return EnglishConstants.PAIN_LEVEL_LIST.indexOfFirst { sevenAnswer.get() == it }
                .takeIf { it != -1 } ?: PAIN_LEVEL_LIST.indexOfFirst { sevenAnswer.get() == it }
    }

    private fun getEightAnswerIndex(): Int {
        return EnglishConstants.PAIN_LEVEL_WORK_LIST.indexOfFirst { eightAnswer.get() == it }
                .takeIf { it != -1 }
                ?: PAIN_LEVEL_WORK_LIST.indexOfFirst { eightAnswer.get() == it }
    }

    data class GeneralFormData(
            @SerializedName("id") val id: Int = -1,
            @SerializedName("firstResponse") val firstResponse: Int,
            @SerializedName("secondResponse") val secondResponse: Int,
            @SerializedName("thirdResponse") val thirdResponse: Int,
            @SerializedName("forthResponse") val forthResponse: Int,
            @SerializedName("fifthResponse") val fifthResponse: Int,
            @SerializedName("sixResponse") val sixResponse: Int,
            @SerializedName("sevenResponse") val sevenResponse: Int,
            @SerializedName("eightResponse") val eightResponse: Int)
}