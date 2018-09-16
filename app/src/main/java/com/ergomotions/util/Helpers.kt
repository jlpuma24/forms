package com.ergomotions.util

import android.widget.EditText
import android.widget.ToggleButton

@Throws(Throwable::class)
fun EditText.getStringOrThrowException(message: String = ""): String {
    if (text.isBlank()) throw Throwable(message = message)
    else return text.toString()
}

@Throws(Throwable::class)
fun Pair<ToggleButton, ToggleButton>.getCheckedPositionOrThrowException(message: String = "") : Int {
    return 0.takeIf { first.isChecked } ?: 1.takeIf { second.isChecked } ?: throw Throwable(message = message)
}

fun ToggleButton.isCheckedInt() = isChecked.toInt()

fun Boolean.toInt() = if (this) 1 else 0