package com.ergomotions.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.ergomotions.R
import com.ergomotions.util.Constants

class YourHabitsFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_your_habits, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        view?.findViewById<Spinner>(R.id.spinner_how_many_cigarretes)?.adapter = ArrayAdapter<String>(context,
                android.R.layout.simple_spinner_item, Constants.getHowManyCigarretesList())
        view?.findViewById<Spinner>(R.id.spinner_how_much_cigarretes)?.adapter = ArrayAdapter<String>(context,
                android.R.layout.simple_spinner_item, Constants.PAIN_AGO_LIST)
        view?.findViewById<Spinner>(R.id.spinner_excercise_frequency)?.adapter = ArrayAdapter<String>(context,
                android.R.layout.simple_spinner_item, Constants.DURATION_LIST)
        view?.findViewById<Spinner>(R.id.spinner_duration)?.adapter = ArrayAdapter<String>(context,
                android.R.layout.simple_spinner_item, Constants.FREQUENCY_LIST)
    }
}