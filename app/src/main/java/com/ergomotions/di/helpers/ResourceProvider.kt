package com.ergomotions.di.helpers

import android.content.Context
import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat
import javax.inject.Inject

class ResourceProvider @Inject constructor(private val context: Context) : IResourceProvider {

    override fun getString(id: Int, vararg args: Any?): String = context.getString(id, *args)

    override fun getString(id: Int): String = context.getString(id)

    override fun getDrawable(id: Int): Drawable = ContextCompat.getDrawable(context, id)

}