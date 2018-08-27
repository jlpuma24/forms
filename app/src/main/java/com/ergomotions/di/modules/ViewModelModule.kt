package com.ergomotions.di.modules

import com.ergomotions.di.ActivityScope
import com.ergomotions.fragments.GeneralFragment
import com.ergomotions.viewModels.CervixViewModel
import com.ergomotions.viewModels.ElbowViewModel
import com.ergomotions.viewModels.FingerViewModel
import com.ergomotions.viewModels.ForeArmViewModel
import com.ergomotions.viewModels.GeneralViewModel
import com.ergomotions.viewModels.HandViewModel
import com.ergomotions.viewModels.HighBagViewModel
import com.ergomotions.viewModels.HipViewModel
import com.ergomotions.viewModels.LowBagViewModel
import com.ergomotions.viewModels.ShoulderViewModel
import com.ergomotions.viewModels.WristViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ActivityScope
    @StringKey(GeneralFragment.CERVIX)
    abstract fun bindCervixViewModel(cervixViewModel: CervixViewModel): GeneralViewModel

    @Binds
    @IntoMap
    @ActivityScope
    @StringKey(GeneralFragment.SHOULDER)
    abstract fun bindShoulderViewModel(cervixViewModel: ShoulderViewModel): GeneralViewModel

    @Binds
    @IntoMap
    @ActivityScope
    @StringKey(GeneralFragment.ELBOW)
    abstract fun bindElbowViewModel(cervixViewModel: ElbowViewModel): GeneralViewModel

    @Binds
    @IntoMap
    @ActivityScope
    @StringKey(GeneralFragment.FOREARM)
    abstract fun bindForeArmViewModel(cervixViewModel: ForeArmViewModel): GeneralViewModel

    @Binds
    @IntoMap
    @ActivityScope
    @StringKey(GeneralFragment.WRIST)
    abstract fun bindWristViewModel(cervixViewModel: WristViewModel): GeneralViewModel

    @Binds
    @IntoMap
    @ActivityScope
    @StringKey(GeneralFragment.HAND)
    abstract fun bindHandViewModel(cervixViewModel: HandViewModel): GeneralViewModel

    @Binds
    @IntoMap
    @ActivityScope
    @StringKey(GeneralFragment.FINGER)
    abstract fun bindFingerViewModel(cervixViewModel: FingerViewModel): GeneralViewModel

    @Binds
    @IntoMap
    @ActivityScope
    @StringKey(GeneralFragment.LOW_BAG)
    abstract fun bindLowBagViewModel(cervixViewModel: LowBagViewModel): GeneralViewModel

    @Binds
    @IntoMap
    @ActivityScope
    @StringKey(GeneralFragment.HIGH_BAG)
    abstract fun bindHighBagViewModel(cervixViewModel: HighBagViewModel): GeneralViewModel

    @Binds
    @IntoMap
    @ActivityScope
    @StringKey(GeneralFragment.HIP)
    abstract fun bindHipViewModel(cervixViewModel: HipViewModel): GeneralViewModel
}