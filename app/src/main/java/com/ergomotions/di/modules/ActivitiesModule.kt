package com.ergomotions.di.modules

import com.ergomotions.activity.AddEmployeeActivity
import com.ergomotions.di.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivitiesModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [FragmentModule::class])
    abstract fun bindAddEmployeeActivity(): AddEmployeeActivity
}