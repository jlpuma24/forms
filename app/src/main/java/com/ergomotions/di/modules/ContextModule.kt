package com.ergomotions.di.modules

import android.content.Context
import com.ergomotions.ErgomotionsApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object ContextModule {

    @Provides
    @Singleton
    @JvmStatic
    fun providesContext(app: ErgomotionsApplication): Context = app.applicationContext
}