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
import com.ergomotions.util.toObservable
import io.reactivex.disposables.CompositeDisposable

abstract class GeneralViewModel(
        private val resourceProvider: IResourceProvider
) : LifecycleObserver {

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
    val secondQuestionEntries = ObservableField<List<String>>(PAIN_PRESENTED_HOW_LIST)
    val thirdQuestionEntries = ObservableField<List<String>>(PAIN_WHEN_LIST)
    val forthQuestionEntries = ObservableField<List<String>>(PAIN_AGO_LIST)
    val fifthQuestionEntries = ObservableField<List<String>>(PAIN_DURATION_LIST)
    val sixQuestionEntries = ObservableField<List<String>>(PAIN_INTENSITY_LIST.map { it.toString() })
    val sevenQuestionEntries = ObservableField<List<String>>(PAIN_LEVEL_LIST)
    val eightQuestionEntries = ObservableField<List<String>>(PAIN_LEVEL_WORK_LIST)

    // Answers
    val secondAnswer = ObservableField<String>(PAIN_PRESENTED_HOW_LIST.first())
    val thirdAnswer = ObservableField<String>(PAIN_WHEN_LIST.first())
    val forthAnswer = ObservableField<String>(PAIN_AGO_LIST.first())
    val fifthAnswer = ObservableField<String>(PAIN_DURATION_LIST.first())
    val sixAnswer = ObservableField<String>(PAIN_INTENSITY_LIST.map { it.toString() }.first())
    val sevenAnswer = ObservableField<String>(PAIN_LEVEL_LIST.first())
    val eightAnswer = ObservableField<String>(PAIN_LEVEL_WORK_LIST.first())

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
                secondResponse = secondAnswer.get().orEmpty(),
                thirdResponse = thirdAnswer.get().orEmpty(),
                forthResponse = forthAnswer.get().orEmpty(),
                fifthResponse = fifthAnswer.get().orEmpty(),
                sixResponse = sixAnswer.get().orEmpty(),
                sevenResponse = sevenAnswer.get().orEmpty(),
                eightResponse = eightAnswer.get().orEmpty())
    }

    private fun getFirstResponseBaseOnButtons(): String {
        return when {
            firstButton.get() -> resourceProvider.getString(R.string.common_left_side)
            secondButton.get() -> resourceProvider.getString(R.string.common_right_side)
            thirdButton.get() -> resourceProvider.getString(R.string.common_both)
            else -> ""
        }
    }

    data class GeneralFormData(
            val id: Int = -1,
            val firstResponse: String,
            val secondResponse: String,
            val thirdResponse: String,
            val forthResponse: String,
            val fifthResponse: String,
            val sixResponse: String,
            val sevenResponse: String,
            val eightResponse: String)
}