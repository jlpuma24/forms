package com.ergomotions.viewModels

import com.ergomotions.di.helpers.IResourceProvider
import javax.inject.Inject

class ForeArmViewModel @Inject constructor(
        resourceProvider: IResourceProvider
) : GeneralViewModel(resourceProvider)