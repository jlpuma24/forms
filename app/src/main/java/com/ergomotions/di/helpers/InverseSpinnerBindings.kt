package com.ergomotions.di.helpers

import android.databinding.BindingAdapter
import android.databinding.InverseBindingAdapter
import android.databinding.InverseBindingListener
import android.widget.Spinner
import com.ergomotions.di.helpers.SpinnerExtensions.getSpinnerValue
import com.ergomotions.di.helpers.SpinnerExtensions.setSpinnerInverseBindingListener
import com.ergomotions.di.helpers.SpinnerExtensions.setSpinnerValue

object InverseSpinnerBindings {

    @BindingAdapter("selectedValue")
    @JvmStatic
    fun Spinner.setSelectedValue(selectedValue: Any?) {
        setSpinnerValue(selectedValue)
    }

    @BindingAdapter("selectedValueAttrChanged")
    @JvmStatic
    fun Spinner.setInverseBindingListener(inverseBindingListener: InverseBindingListener?) {
        setSpinnerInverseBindingListener(inverseBindingListener)
    }

    @JvmStatic
    @InverseBindingAdapter(attribute = "selectedValue", event = "selectedValueAttrChanged")
    fun Spinner.getSelectedValue(): Any? {
        return getSpinnerValue()
    }

}