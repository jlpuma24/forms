package com.ergomotions.util

import android.databinding.BindingAdapter
import android.databinding.InverseBindingAdapter
import android.databinding.InverseBindingListener
import android.widget.Spinner

@BindingAdapter("selectedValue")
fun Spinner.setSelectedValue(selectedValue: Any?) {
    setSpinnerValue(selectedValue)
}

@BindingAdapter("selectedValueAttrChanged")
fun Spinner.setInverseBindingListener(inverseBindingListener: InverseBindingListener?) {
    setSpinnerInverseBindingListener(inverseBindingListener)
}

@InverseBindingAdapter(attribute = "selectedValue", event = "selectedValueAttrChanged")
fun Spinner.getSelectedValue(): Any? {
    return getSpinnerValue()
}
