package com.ergomotions.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
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

    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this, ReportsActivity::class.java))
        finish()
    }
}