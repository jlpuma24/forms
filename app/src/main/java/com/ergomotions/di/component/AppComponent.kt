package com.ergomotions.di.component

import com.ergomotions.ErgomotionsApplication
import com.ergomotions.di.modules.ActivitiesModule
import com.ergomotions.di.modules.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [
    ActivitiesModule::class,
    AppModule::class
])
interface AppComponent : AndroidInjector<ErgomotionsApplication> {

    @Component.Builder
    interface Builder {
        fun build(): AppComponent

        @BindsInstance
        fun application(application: ErgomotionsApplication): Builder
    }

}