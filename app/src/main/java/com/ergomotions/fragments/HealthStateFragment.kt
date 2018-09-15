package com.ergomotions.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ToggleButton
import com.ergomotions.R
import com.ergomotions.util.getCheckedPositionOrThrowException
import kotlinx.android.synthetic.main.fragment_health_state.button_option_no
import kotlinx.android.synthetic.main.fragment_health_state.button_option_no_sicness
import kotlinx.android.synthetic.main.fragment_health_state.button_option_yes
import kotlinx.android.synthetic.main.fragment_health_state.button_option_yes_sicness
import kotlinx.android.synthetic.main.fragment_health_state.editTextObservations
import kotlinx.android.synthetic.main.fragment_health_state.editTextSickName

class HealthStateFragment : Fragment() {

    private var info: ForthInformation? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_health_state, container, false)
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
    fun getInfo(): ForthInformation {
        return when {
            view != null ->
            ForthInformation(getPainViewPair().getCheckedPositionOrThrowException("Especificar inconveniencias"),
                    getSicViewPair().getCheckedPositionOrThrowException("Especificar si ha tenido enfermedad"),
                    editTextSickName.text.toString(),
                    editTextObservations.text.toString())
            info != null -> info!!
            else -> throw Throwable(message = "Por favor llenar todos los campos")
        }
    }

    private fun getPainViewPair(): Pair<ToggleButton, ToggleButton> {
        return (button_option_yes to button_option_no)
    }

    private fun getSicViewPair(): Pair<ToggleButton, ToggleButton> {
        return (button_option_yes_sicness to button_option_no_sicness)
    }

    data class ForthInformation(
            val inconveniences: Int,
            val sickness: Int,
            val sickName: String,
            val observations: String)
}