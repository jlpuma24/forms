package com.ergomotions.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.widget.TextView
import com.ergomotions.R
import com.ergomotions.util.Constants
import kotlinx.android.synthetic.main.activity_report_display.*

class ReportDisplayActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report_display)

        val reportResponse = Constants.getReportResponse()
        sinceNote.text = reportResponse.d1Report.years.toString()
        chargeNote.text = reportResponse.d1Report.charge.toString()
        genderNote.text = reportResponse.d1Report.gender.toString()
        dominanceNote.text = reportResponse.d1Report.dominance.toString()
        imcNote.text = reportResponse.d1Report.imc.toString()
        ageNote.text = reportResponse.d1Report.age.toString()

        cigarreteConsumeNote.text = reportResponse.d2Report.cigarrettes.toString()
        cigarreteTimeNote.text = reportResponse.d2Report.howMuchSmoke.toString()
        exerciseDurationNote.text = reportResponse.d2Report.durationPhysicalActivity.toString()
        exerciseFrequencyNote.text = reportResponse.d2Report.frequencyPhysicalActivity.toString()

        weekDurationNote.text = reportResponse.d3Report.weekDuration.toString()
        workedHoursNote.text = reportResponse.d3Report.workedHours.toString()
        polifunctionaityNote.text = reportResponse.d3Report.polifunctionality.toString()

        containerD4Report.removeAllViews()

        val d4ListReport = reportResponse.d4Report
        for (reportObject in d4ListReport) {
            val view = LayoutInflater.from(this).inflate(R.layout.report_row, null)
            view.findViewById<TextView>(R.id.oned4).text = reportObject.painPresentedHow.toString()
            view.findViewById<TextView>(R.id.two4).text = reportObject.painWhen.toString()
            view.findViewById<TextView>(R.id.three4).text = reportObject.painAgo.toString()
            view.findViewById<TextView>(R.id.fourd4).text = reportObject.painDuration.toString()
            view.findViewById<TextView>(R.id.fived4).text = reportObject.painIntensity.toString()
            view.findViewById<TextView>(R.id.bodyPart).text = reportObject.bodyPart
            containerD4Report.addView(view)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this, ReportsActivity::class.java))
        finish()
    }
}