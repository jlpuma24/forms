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

    // Im putting some generic data
    val secondQuestionEntries = ObservableField<List<String>>(listOf("-"))
    val thirdQuestionEntries = ObservableField<List<String>>(listOf("-", "Al final del día"))
    val forthQuestionEntries = ObservableField<List<String>>(listOf("-", "1 mes"))
    val fifthQuestionEntries = ObservableField<List<String>>(listOf("-", "Menos de 24 horas"))
    val sixQuestionEntries = ObservableField<List<String>>(listOf("-", "4"))
    val sevenQuestionEntries = ObservableField<List<String>>(listOf("-", "Moderadamente incómodo"))
    val eightQuestionEntries = ObservableField<List<String>>(listOf("-", "No, en absoluto"))

    // Answers
    val secondAnswer = ObservableField<String>()
    val thirdAnswer = ObservableField<String>()
    val forthAnswer = ObservableField<String>()
    val fifthAnswer = ObservableField<String>()
    val sixAnswer = ObservableField<String>()
    val sevenAnswer = ObservableField<String>()
    val eightAnswer = ObservableField<String>()

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
    }

    fun provideData(): GeneralFormData {
        return GeneralFormData(firstResponse = "",
                secondResponse = secondAnswer.get().orEmpty(),
                thirdResponse = thirdAnswer.get().orEmpty(),
                forthResponse = forthAnswer.get().orEmpty(),
                fifthResponse = fifthAnswer.get().orEmpty(),
                sixResponse = sixAnswer.get().orEmpty(),
                sevenResponse = sevenAnswer.get().orEmpty(),
                eightResponse = eightAnswer.get().orEmpty())
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