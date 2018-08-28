package com.ergomotions.di.helpers

import android.graphics.drawable.Drawable
import android.support.annotation.DrawableRes
import android.support.annotation.StringRes

interface IResourceProvider {

    fun getString(@StringRes id: Int): String

    fun getString(@StringRes id: Int, vararg args: Any?): String

    fun getDrawable(@DrawableRes id: Int) : Drawable

}