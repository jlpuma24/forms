package com.ergomotions.viewModels

import com.ergomotions.R
import com.ergomotions.di.helpers.IResourceProvider
import javax.inject.Inject

class FootViewModel @Inject constructor(
        resourceProvider: IResourceProvider
) : GeneralViewModel(resourceProvider) {

    init {
        headerBanner.set(resourceProvider.getDrawable(R.drawable.ic_foot_banner))
        firstQuestion.set(resourceProvider.getString(R.string.common_question_a, resourceProvider.getString(R.string.nineteen)))
    }

    override fun provideData(): GeneralFormData {
        return super.provideData().copy(id = 15)
    }

}