package com.ergomotions.di.helpers

import android.content.Context
import javax.inject.Inject

class ResourceProvider @Inject constructor(private val context: Context) : IResourceProvider {

    override fun getString(id: Int, vararg args: Any?): String = context.getString(id, *args)

    override fun getString(id: Int): String = context.getString(id)

}