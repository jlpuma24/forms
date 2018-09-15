package com.ergomotions.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.ergomotions.R

class EmployeeInfoFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.employee_info_fragment, container, false)

        val editTextWeight = view?.findViewById<EditText>(R.id.editTextWeight)
        val editTextHeight = view?.findViewById<EditText>(R.id.editTextHeight)
        val editTextImc = view?.findViewById<EditText>(R.id.editTextImc)

        editTextWeight?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (!s.toString().isEmpty()) {
                    if (!editTextHeight?.text.toString().isEmpty()) {
                        val heightInMts = editTextHeight?.text.toString().toDouble() / 100
                        val imc = s.toString().toDouble() / Math.pow(heightInMts, 2.0)
                        editTextImc?.setText("%.2f".format(imc))
                    }
                }
            }
        })
        editTextHeight?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (!s.toString().isEmpty()) {
                    if (!editTextWeight?.text.toString().isEmpty()) {
                        val heightInMts = s.toString().toDouble() / 100
                        val imc = (editTextWeight?.text.toString().toDouble()) / Math.pow(heightInMts, 2.0)
                        editTextImc?.setText("%.2f".format(imc))
                    }
                }
            }

        })
        return view
    }

}