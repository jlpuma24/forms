package com.ergomotions.viewModels

import com.ergomotions.di.helpers.IResourceProvider
import javax.inject.Inject

class LowBagViewModel @Inject constructor(
        resourceProvider: IResourceProvider
) : GeneralViewModel(resourceProvider) {

    override fun provideData(): GeneralFormData {
        return super.provideData().copy(id = 8)
    }
}