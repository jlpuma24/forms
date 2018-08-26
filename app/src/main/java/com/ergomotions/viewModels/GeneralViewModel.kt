package com.ergomotions.viewModels

import android.databinding.ObservableField
import com.ergomotions.R
import com.ergomotions.di.helpers.IResourceProvider

abstract class GeneralViewModel(resourceProvider: IResourceProvider) {

    // This is in case the want to change the question for a muscular group, otherwise we just need to add them to teh xml
    val headerDescription = ObservableField<String>()
    val firstQuestion = ObservableField<String>()
    val secondQuestion = ObservableField<String>()
    val thirdQuestion = ObservableField<String>()
    val forthQuestion = ObservableField<String>()
    val fifthQuestion = ObservableField<String>()
    val sixQuestion = ObservableField<String>()
    val sevenQuestion = ObservableField<String>()
    val eightQuestion = ObservableField<String>()

    val leftButtonOption = ObservableField<String>()
    val rightButtonOption = ObservableField<String>()
    val centerButtonOption = ObservableField<String>()

    init {
        headerDescription.set(resourceProvider.getString(R.string.common_first))
        firstQuestion.set(resourceProvider.getString(R.string.common_question_a))
        secondQuestion.set(resourceProvider.getString(R.string.common_question_b))
        thirdQuestion.set(resourceProvider.getString(R.string.common_question_c))
        forthQuestion.set(resourceProvider.getString(R.string.common_question_d))
        fifthQuestion.set(resourceProvider.getString(R.string.common_question_e))
        sixQuestion.set(resourceProvider.getString(R.string.common_question_f))
        sevenQuestion.set(resourceProvider.getString(R.string.common_question_g))
        eightQuestion.set(resourceProvider.getString(R.string.common_question_h))

        leftButtonOption.set(resourceProvider.getString(R.string.common_left_side))
        rightButtonOption.set(resourceProvider.getString(R.string.common_right_side))
        centerButtonOption.set(resourceProvider.getString(R.string.common_both))
    }

    // TODO Just for now while I know how will be the store response
    fun provideData(): GeneralFormData {
        return GeneralFormData()
    }

    data class GeneralFormData(
            val firstResponse: String = "",
            val secondResponse: String = "",
            val thirdResponse: String = "",
            val forthResponse: String = "",
            val fifthResponse: String = "",
            val sixResponse: String = "",
            val sevenResponse: String = "",
            val eightResponse: String = "")
}