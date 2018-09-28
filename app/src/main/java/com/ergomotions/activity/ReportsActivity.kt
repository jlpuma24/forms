package com.ergomotions.activity

import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ergomotions.R
import com.ergomotions.network.ApiService
import com.ergomotions.network.ReportRequest
import com.ergomotions.network.ReportResponse
import com.ergomotions.util.Constants
import kotlinx.android.synthetic.main.activity_find_report.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ReportsActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_report)

        buttonFindReport.setOnClickListener { findReport() }
    }

    private fun findReport() {
        val dialog = ProgressDialog(this)
        dialog.setMessage(getString(R.string.please_wait))
        dialog.show()

        val retrofit = Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val service = retrofit.create<ApiService>(ApiService::class.java)
        service.getReport(ReportRequest(editTextId.text.toString())).enqueue(object : Callback<ReportResponse> {
            override fun onFailure(call: Call<ReportResponse>, t: Throwable) {
                dialog.dismiss()
                showDialog(getString(R.string.error_login))
            }

            override fun onResponse(call: Call<ReportResponse>, response: Response<ReportResponse>) {
                if (response.isSuccessful) {
                    dialog.dismiss()
                    Constants.setReportResponse(response.body()!!)
                    startActivity(Intent(applicationContext, ReportDisplayActivity::class.java))
                    finish()
                } else {
                    dialog.dismiss()
                    showDialog(getString(R.string.error_login))
                }
            }
        })
    }

    override fun onBackPressed() {
        startActivity(Intent(this, EmployeeMainActivity::class.java))
        finish()
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