package com.ergomotions.di.modules

import com.ergomotions.di.helpers.IResourceProvider
import com.ergomotions.di.helpers.ResourceProvider
import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module(includes = [
    ContextModule::class
])
abstract class AppModule {

    @Binds
    @Reusable
    abstract fun bindResourceProvider(provider: ResourceProvider): IResourceProvider

}