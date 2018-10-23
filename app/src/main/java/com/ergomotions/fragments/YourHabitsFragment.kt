package com.ergomotions.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ToggleButton
import com.ergomotions.R
import com.ergomotions.util.Constants
import com.ergomotions.util.EnglishConstants
import com.ergomotions.util.getCheckedPositionOrThrowException
import com.ergomotions.util.getSelectedValue
import kotlinx.android.synthetic.main.fragment_your_habits.button_option_no
import kotlinx.android.synthetic.main.fragment_your_habits.button_option_no_physic_activity
import kotlinx.android.synthetic.main.fragment_your_habits.button_option_yes
import kotlinx.android.synthetic.main.fragment_your_habits.button_option_yes_physic_activity
import kotlinx.android.synthetic.main.fragment_your_habits.spinnerActivityName
import kotlinx.android.synthetic.main.fragment_your_habits.spinner_duration
import kotlinx.android.synthetic.main.fragment_your_habits.spinner_excercise_frequency
import kotlinx.android.synthetic.main.fragment_your_habits.spinner_how_many_cigarretes
import kotlinx.android.synthetic.main.fragment_your_habits.spinner_how_much_cigarretes
import java.util.*

class YourHabitsFragment : Fragment() {

    private var info: ThirdInformation? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_your_habits, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {

        spinner_how_many_cigarretes.adapter = ArrayAdapter<String>(context,
                R.layout.row_adapter, if (Locale.getDefault().language != "en")
            Constants.CIGARRETTES_LIST else EnglishConstants.CIGARRETTES_LIST)

        spinner_how_much_cigarretes.adapter = ArrayAdapter<String>(context,
                R.layout.row_adapter, if (Locale.getDefault().language != "en")
            Constants.CIGARRETTES_AGO_LIST else EnglishConstants.CIGARRETTES_AGO_LIST)

        spinner_excercise_frequency.adapter = ArrayAdapter<String>(context,
                R.layout.row_adapter, if (Locale.getDefault().language != "en")
            Constants.DURATION_LIST else EnglishConstants.DURATION_LIST)
        spinner_duration.adapter = ArrayAdapter<String>(context,
                R.layout.row_adapter, if (Locale.getDefault().language != "en")
            Constants.FREQUENCY_LIST else EnglishConstants.FREQUENCY_LIST)
        spinnerActivityName.adapter = ArrayAdapter<String>(context,
                R.layout.row_adapter, if (Locale.getDefault().language != "en")
            Constants.ACTIVITIES else EnglishConstants.ACTIVITIES)
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
    fun getInfo(): ThirdInformation {
        return when {
            view != null -> ThirdInformation(getSmokeViewPair().getCheckedPositionOrThrowException("Especificar si fuma"),
                    (spinner_how_many_cigarretes.selectedItemPosition),
                    (spinner_how_much_cigarretes.getSelectedValue() as String),
                    getPhysicViewPair().getCheckedPositionOrThrowException("Especificar si hace actividad física"),
                    (spinnerActivityName.getSelectedValue() as String),
                    spinner_excercise_frequency.selectedItemPosition + 1,
                    spinner_duration.selectedItemPosition + 1)
            info != null -> info!!
            else -> throw Throwable(message = "Por favor llenar todos los campos")
        }
    }

    private fun getSmokeViewPair(): Pair<ToggleButton, ToggleButton> {
        return (button_option_yes to button_option_no)
    }

    private fun getPhysicViewPair(): Pair<ToggleButton, ToggleButton> {
        return (button_option_yes_physic_activity to button_option_no_physic_activity)
    }

    data class ThirdInformation(
            val smoke: Int,
            val cigarretes: Int,
            val howLongSmoke: String,
            val physicalActivity: Int,
            val physicalActivityName: String,
            val frequency: Int,
            val duration: Int)
}