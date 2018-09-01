package com.ergomotions.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.ergomotions.R
import com.ergomotions.util.Constants
class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed({
            startActivity(Intent(applicationContext, LoginActivity::class.java))
            finish()
        }, Constants.SPLASH_DISPLAY_LENGTH)
    }
}