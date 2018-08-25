package com.ergomotions.activity

import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ergomotions.R
import com.ergomotions.network.ApiService
import com.ergomotions.network.LoginRequest
import com.ergomotions.network.LoginResponse
import com.ergomotions.util.Constants
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        buttonLogin.setOnClickListener {
            doLogin()
        }
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
        service.login(LoginRequest(editTextUsername.text.toString(), editTextPassword.text.toString()))
                .enqueue(object : Callback<LoginResponse> {
                    override fun onFailure(call: Call<LoginResponse>?, t: Throwable?) {
                        dialog.dismiss()
                        showDialog(getString(R.string.error_login))
                    }

                    override fun onResponse(call: Call<LoginResponse>?, response: Response<LoginResponse>?) {
                        dialog.dismiss()
                        if (response != null && response.isSuccessful && response.body()?.status == "OK") {
                            startActivity(Intent(applicationContext, CompanyMainActivity::class.java))
                            finish()
                        } else {
                            showDialog(response?.body()?.message)
                        }
                    }
                })
    }

    private fun showDialog(message: String?) {
        val builder = AlertDialog.Builder(this)
        builder.setMessage(message)
        builder.setCancelable(false)
        builder.setPositiveButton(getString(android.R.string.yes)) { dialog , _ ->
            dialog.cancel()
        }
        val alert = builder.create()
        alert.show()
    }
}