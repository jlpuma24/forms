package com.ergomotions.viewModels

import com.ergomotions.R
import com.ergomotions.di.helpers.IResourceProvider
import javax.inject.Inject

class ShoulderViewModel @Inject constructor(
        resourceProvider: IResourceProvider
) : GeneralViewModel(resourceProvider) {

    init {
        headerBanner.set(resourceProvider.getDrawable(R.drawable.ic_shoulder_banner))
        firstQuestion.set(resourceProvider.getString(R.string.common_question_a, "el hombro"))
    }

    override fun provideData(): GeneralFormData {
        return super.provideData().copy(id = 2)
    }


}