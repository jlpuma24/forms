package com.ergomotions.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ergomotions.R

class EmployeeMainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee_main)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this, CompanyMainActivity::class.java))
        finish()
    }
}