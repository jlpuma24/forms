package com.ergomotions.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Spinner
import com.ergomotions.R
import android.widget.ArrayAdapter
import com.ergomotions.util.Constants
import com.ergomotions.util.EnglishConstants
import java.util.*


class YourWorkFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_your_work, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        view?.findViewById<Spinner>(R.id.spinner_job_journey)?.adapter = ArrayAdapter<String>(context,
                        android.R.layout.simple_spinner_item, if (Locale.getDefault().language != "en") Constants.JOB_JOURNEY_LIST else EnglishConstants.JOB_JOURNEY_LIST)
        view?.findViewById<Spinner>(R.id.spinner_job_journey_duration)?.adapter = ArrayAdapter<String>(context,
                android.R.layout.simple_spinner_item, if (Locale.getDefault().language != "en") Constants.FREQUENCY_LIST else EnglishConstants.FREQUENCY_LIST)
    }
}