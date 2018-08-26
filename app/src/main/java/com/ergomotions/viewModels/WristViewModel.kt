package com.ergomotions.viewModels

import com.ergomotions.di.helpers.IResourceProvider
import javax.inject.Inject

class WristViewModel @Inject constructor(
        resourceProvider: IResourceProvider
) : GeneralViewModel(resourceProvider)