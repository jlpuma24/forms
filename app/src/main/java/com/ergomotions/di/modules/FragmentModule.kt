package com.ergomotions.di.modules

import com.ergomotions.fragments.GeneralFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector(modules = [ViewModelModule::class])
    abstract fun bindGeneralFragment(): GeneralFragment
}