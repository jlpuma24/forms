package com.ergomotions.di.helpers

import android.support.annotation.StringRes

interface IResourceProvider {

    fun getString(@StringRes id: Int): String

    fun getString(@StringRes id: Int, vararg args: Any?): String

}