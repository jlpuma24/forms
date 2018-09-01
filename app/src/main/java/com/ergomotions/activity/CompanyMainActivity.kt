package com.ergomotions.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ergomotions.R
import kotlinx.android.synthetic.main.activity_company_main.*
import java.util.*

class CompanyMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_company_main)

        if (Locale.getDefault().language == "en") {
            companiesAdd.setImageResource(R.drawable.plus_en)
            companiesList.setImageResource(R.drawable.tasks_en)
        }

        companiesAdd.setOnClickListener {
            startActivity(Intent(applicationContext, AddCompanyActivity::class.java))
            finish()
        }
        companiesList.setOnClickListener {
            startActivity(Intent(applicationContext, ListCompaniesActivity::class.java))
            finish()
        }
        helpButton.setOnClickListener {
            startActivity(Intent(applicationContext, HelpActivity::class.java))
        }
    }
}