package com.ergomotions.util

import android.databinding.BindingAdapter
import android.databinding.InverseBindingListener
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.ergomotions.R


/**
 * set spinner entries
 */
@BindingAdapter("entries")
fun Spinner.setSpinnerEntries(entries: List<Any>?) {
    if (entries != null) {
        val arrayAdapter = ArrayAdapter(context, R.layout.row_adapter, entries)
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adapter = arrayAdapter
    }
}

/**
 * set spinner onItemSelectedListener listener
 */
fun Spinner.setSpinnerInverseBindingListener(listener: InverseBindingListener?) {
    onItemSelectedListener = if (listener == null) {
        null
    } else {
        object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                if (tag != position) {
                    listener.onChange()
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }
    }
}

/**
 * set spinner value
 */
fun Spinner.setSpinnerValue(value: Any?) {
    if (adapter != null) {
        val position = (adapter as ArrayAdapter<Any>).getPosition(value)
        setSelection(position, false)
        tag = position
    }
}

/**
 * get spinner value
 */
fun Spinner.getSpinnerValue(): Any? {
    return selectedItem
}
