package com.ergomotions.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ergomotions.R
import kotlinx.android.synthetic.main.activity_company_main.*

class CompanyMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_company_main)
        companiesAdd.setOnClickListener {
            startActivity(Intent(applicationContext, AddCompanyActivity::class.java))
            finish()
        }
    }
}