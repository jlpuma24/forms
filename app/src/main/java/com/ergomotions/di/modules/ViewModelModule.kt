package com.ergomotions.di.modules

import com.ergomotions.di.ActivityScope
import com.ergomotions.fragments.GeneralFragment
import com.ergomotions.viewModels.CervixViewModel
import com.ergomotions.viewModels.ElbowViewModel
import com.ergomotions.viewModels.FingerViewModel
import com.ergomotions.viewModels.ForeArmViewModel
import com.ergomotions.viewModels.GeneralViewModel
import com.ergomotions.viewModels.HandViewModel
import com.ergomotions.viewModels.HipViewModel
import com.ergomotions.viewModels.LowBagViewModel
import com.ergomotions.viewModels.ShoulderViewModel
import com.ergomotions.viewModels.WristViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey

@Module
@ActivityScope
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @StringKey(GeneralFragment.CERVIX)
    abstract fun bindCervixViewModel(cervixViewModel: CervixViewModel): GeneralViewModel

    @Binds
    @IntoMap
    @StringKey(GeneralFragment.SHOULDER)
    abstract fun bindShoulderViewModel(cervixViewModel: ShoulderViewModel): GeneralViewModel

    @Binds
    @IntoMap
    @StringKey(GeneralFragment.ELBOW)
    abstract fun bindElbowViewModel(cervixViewModel: ElbowViewModel): GeneralViewModel

    @Binds
    @IntoMap
    @StringKey(GeneralFragment.FOREARM)
    abstract fun bindForeArmViewModel(cervixViewModel: ForeArmViewModel): GeneralViewModel

    @Binds
    @IntoMap
    @StringKey(GeneralFragment.WRIST)
    abstract fun bindWristViewModel(cervixViewModel: WristViewModel): GeneralViewModel

    @Binds
    @IntoMap
    @StringKey(GeneralFragment.HAND)
    abstract fun bindHandViewModel(cervixViewModel: HandViewModel): GeneralViewModel

    @Binds
    @IntoMap
    @StringKey(GeneralFragment.FINGER)
    abstract fun bindFingerViewModel(cervixViewModel: FingerViewModel): GeneralViewModel

    @Binds
    @IntoMap
    @StringKey(GeneralFragment.LOW_BAG)
    abstract fun bindLowBagViewModel(cervixViewModel: LowBagViewModel): GeneralViewModel

    @Binds
    @IntoMap
    @StringKey(GeneralFragment.HIGH_BAG)
    abstract fun bindHighBagViewModel(cervixViewModel: CervixViewModel): GeneralViewModel

    @Binds
    @IntoMap
    @StringKey(GeneralFragment.HIP)
    abstract fun bindHipViewModel(cervixViewModel: HipViewModel): GeneralViewModel
}