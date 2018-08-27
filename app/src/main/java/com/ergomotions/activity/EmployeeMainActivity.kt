package com.ergomotions.activity

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ergomotions.R
import com.ergomotions.network.ApiService
import com.ergomotions.network.LoginRequest
import com.ergomotions.network.LoginResponse
import com.ergomotions.util.Constants
import com.ergomotions.util.PrefsUtil
import kotlinx.android.synthetic.main.activity_employee_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class EmployeeMainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee_main)
        employeeAdd.setOnClickListener {
            startActivity(Intent(applicationContext, AddEmployeeActivity::class.java))
            finish()
        }
        employeeEdit.setOnClickListener {
            startActivity(Intent(applicationContext, ListEmployeeActivity::class.java))
            finish()
        }
        doLogin()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this, CompanyMainActivity::class.java))
        finish()
    }

    private fun doLogin() {
        val dialog = ProgressDialog(this)
        dialog.setMessage(getString(R.string.please_wait))
        dialog.show()

        val retrofit = Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val service = retrofit.create<ApiService>(ApiService::class.java)
        val pairCredentials = PrefsUtil.getInstance().userCredentials
        service.login(LoginRequest(pairCredentials.first, pairCredentials.second))
                .enqueue(object : Callback<LoginResponse> {
                    override fun onFailure(call: Call<LoginResponse>?, t: Throwable?) {
                        dialog.dismiss()
                    }

                    override fun onResponse(call: Call<LoginResponse>?, response: Response<LoginResponse>?) {
                        dialog.dismiss()
                        if (response != null && response.isSuccessful && response.body()?.status == "OK") {
                            PrefsUtil.getInstance().userData = response.body()
                        }
                    }
                })
    }
}