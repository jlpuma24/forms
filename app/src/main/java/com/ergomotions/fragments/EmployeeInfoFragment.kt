package com.ergomotions.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ToggleButton
import com.ergomotions.R
import com.ergomotions.util.getCheckedPositionOrThrowException
import com.ergomotions.util.getStringOrThrowException
import kotlinx.android.synthetic.main.employee_info_fragment.button_option_female
import kotlinx.android.synthetic.main.employee_info_fragment.button_option_male
import kotlinx.android.synthetic.main.employee_info_fragment.editTextAge
import kotlinx.android.synthetic.main.employee_info_fragment.editTextArea
import kotlinx.android.synthetic.main.employee_info_fragment.editTextHeight
import kotlinx.android.synthetic.main.employee_info_fragment.editTextId
import kotlinx.android.synthetic.main.employee_info_fragment.editTextLastName
import kotlinx.android.synthetic.main.employee_info_fragment.editTextMonths
import kotlinx.android.synthetic.main.employee_info_fragment.editTextName
import kotlinx.android.synthetic.main.employee_info_fragment.editTextWeight
import kotlinx.android.synthetic.main.employee_info_fragment.editTextYears

class EmployeeInfoFragment : Fragment() {

    private var info: FirstInformation? = null

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

    override fun onDestroyView() {
        info = try {
            getInfo()
        } catch (e: Throwable) {
            e.printStackTrace()
            null
        }
        super.onDestroyView()
    }

    @Throws(Throwable::class)
    fun getInfo(): FirstInformation {
        return when {
            view != null ->
                FirstInformation(editTextName.getStringOrThrowException("Nombre es obligatorio"), // TODO Fix the message base on language tito
                    editTextLastName.getStringOrThrowException("Apellido es obligatorio"), // TODO Fix the message base on language tito
                    editTextId.getStringOrThrowException("ID es obligatorio"), // TODO Fix the message base on language tito
                    editTextWeight.getStringOrThrowException("Peso es obligatorio"), // TODO Fix the message base on language tito
                    editTextHeight.getStringOrThrowException("Altura es obligatorio"), // TODO Fix the message base on language tito
                    getButtonsPair().getCheckedPositionOrThrowException("Género es obligatorio"), // TODO Fix the message base on language tito
                    editTextAge.getStringOrThrowException("Edad es obligatorio"), // TODO Fix the message base on language tito
                    editTextMonths.getStringOrThrowException("Meses en la compañia son obligatorio"), // TODO Fix the message base on language tito
                    editTextYears.getStringOrThrowException("Años en la compañia son obligatorio"), // TODO Fix the message base on language tito
                    editTextArea.getStringOrThrowException("Área es obligatorio")) // TODO Fix the message base on language tito
            info != null -> info!!
            else -> throw Throwable(message = "Por favor llenar todos los campos")
        }
    }

    private fun getButtonsPair(): Pair<ToggleButton, ToggleButton> {
        return (button_option_male to button_option_female)
    }

    data class FirstInformation(
            val name: String,
            val lastName: String,
            val identification: String,
            val weight: String,
            val height: String,
            val gender: Int,
            val age: String,
            val monthsCompany: String,
            val yearsCompany: String,
            val dependency: String)

}