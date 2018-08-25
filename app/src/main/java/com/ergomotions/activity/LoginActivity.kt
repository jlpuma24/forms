package com.ergomotions.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ergomotions.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        buttonLogin.setOnClickListener {
            startActivity(Intent(applicationContext, CompanyMainActivity::class.java))
            finish()
        }
    }
}