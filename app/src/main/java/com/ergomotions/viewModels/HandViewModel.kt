package com.ergomotions.viewModels

import com.ergomotions.R
import com.ergomotions.di.helpers.IResourceProvider
import javax.inject.Inject

class HandViewModel @Inject constructor(
        resourceProvider: IResourceProvider
) : GeneralViewModel(resourceProvider) {

    init {
        headerBanner.set(resourceProvider.getDrawable(R.drawable.ic_hand_banner))
        firstQuestion.set(resourceProvider.getString(R.string.common_question_a, "la mano"))
    }

    override fun provideData(): GeneralFormData {
        return super.provideData().copy(id = 7)
    }

}