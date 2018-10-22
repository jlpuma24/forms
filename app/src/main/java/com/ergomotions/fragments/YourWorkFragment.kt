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
import kotlinx.android.synthetic.main.fragment_your_work.button_option_no_week_duration
import kotlinx.android.synthetic.main.fragment_your_work.button_option_yes_week_duration
import kotlinx.android.synthetic.main.fragment_your_work.editTextArea
import kotlinx.android.synthetic.main.fragment_your_work.spinner_job_journey
import kotlinx.android.synthetic.main.fragment_your_work.spinner_job_journey_duration
import java.util.*


class YourWorkFragment : Fragment() {

    private var info: SecondInformation? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_your_work, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        spinner_job_journey.adapter = ArrayAdapter<String>(context,
                android.R.layout.simple_spinner_item,
                if (Locale.getDefault().language != "en") Constants.JOB_JOURNEY_LIST else EnglishConstants.JOB_JOURNEY_LIST)

        spinner_job_journey_duration.adapter = ArrayAdapter<String>(context,
                android.R.layout.simple_spinner_item,
                if (Locale.getDefault().language != "en") Constants.FREQUENCY_WORK_LIST.map { it.toString() } else EnglishConstants.FREQUENCY_WORK_LIST.map { it.toString() })
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
    fun getInfo(): SecondInformation {
        return when {
            view != null ->
            SecondInformation(spinner_job_journey.selectedItemPosition + 1,
                    spinner_job_journey_duration.selectedItem as String,
                    getJobJourneyViewPair().getCheckedPositionOrThrowException("Especificar jornada variable es obligatorio"),
                    editTextArea.text.toString())
            info != null -> info!!
            else -> throw Throwable(message = "Por favor llenar todos los campos")
        }
    }

    private fun getJobJourneyViewPair(): Pair<ToggleButton, ToggleButton> {
        return (button_option_yes_week_duration to button_option_no_week_duration)
    }

    data class SecondInformation(
            val jobJourney: Int,
            val workHoursByDay: String,
            val viabilityJobJourney: Int,
            val viabilityJobJourneyExplanation: String)

}