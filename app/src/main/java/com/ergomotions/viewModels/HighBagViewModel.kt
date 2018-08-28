package com.ergomotions.viewModels

import com.ergomotions.R
import com.ergomotions.di.helpers.IResourceProvider
import javax.inject.Inject

class HighBagViewModel @Inject constructor(
        resourceProvider: IResourceProvider
) : GeneralViewModel(resourceProvider) {

    init {
        headerBanner.set(resourceProvider.getDrawable(R.drawable.ic_high_bag_banner))
        firstQuestion.set(resourceProvider.getString(R.string.common_question_a, "la espalda alta"))
    }

    override fun provideData(): GeneralFormData {
        return super.provideData().copy(id = 9)
    }

}