package com.ergomotions.viewModels

import com.ergomotions.R
import com.ergomotions.di.helpers.IResourceProvider
import javax.inject.Inject

class FingerViewModel @Inject constructor(
        resourceProvider: IResourceProvider
) : GeneralViewModel(resourceProvider) {

    init {
        headerBanner.set(resourceProvider.getDrawable(R.drawable.ic_finger_banner))
        firstQuestion.set(resourceProvider.getString(R.string.common_question_a, resourceProvider.getString(R.string.twelve)))
    }

    override fun provideData(): GeneralFormData {
        return super.provideData().copy(id = 8)
    }

}