package com.ergomotions.activity

import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
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
import java.util.*

class EmployeeMainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee_main)

        toolbar.title = getString(R.string.worker)
        setSupportActionBar(toolbar)

        if (Locale.getDefault().language == "en") {
            employeeAdd.setImageResource(R.drawable.add_employee_en)
            employeeEdit.setImageResource(R.drawable.edit_employee_en)
        }

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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.reports, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
          R.id.action_refresh -> {
              startActivity(Intent(this, ReportsActivity::class.java))
              finish()
          }
          R.id.action_chart -> {
              val builder = AlertDialog.Builder(this@EmployeeMainActivity)

              val colors = arrayOf(getString(R.string.age_chart), getString(R.string.dominance_chart), getString(R.string.imc_chart),
                      getString(R.string.charge_chart),
                      getString(R.string.smoke_chart),
                      getString(R.string.cigarrettes_chart),
                      getString(R.string.cigarrettes_time_chart),
                      getString(R.string.physical_activity_chart),
                      getString(R.string.frequency_physical_activity_chart),
                      getString(R.string.duration_physical_activity_chart),
                      getString(R.string.hours_worked_chart),
                      getString(R.string.variable_hours_worked_chart),
                      getString(R.string.pain_chart),
                      getString(R.string.sick_chart))

              builder.setTitle(getString(R.string.pick_variables))

              var selectedIndex = 0

              builder.setSingleChoiceItems(colors, -1) { _, which ->
                  selectedIndex = which + 1
              }

              builder.setPositiveButton(getString(R.string.accept)) { dialog, _ ->
                  val intent = Intent(this@EmployeeMainActivity, WebViewActivity::class.java)
                  intent.putExtra("url", "http://ec2-52-14-239-106.us-east-2.compute.amazonaws.com:8001/api/charts/"+selectedIndex.toString()+"/0")
                  startActivity(intent)
                  finish()
                  dialog.dismiss()
              }

              builder.setNegativeButton(getString(R.string.cancel)) { dialog, _ ->
                  dialog.dismiss()
              }

              val dialog = builder.create()
              dialog.show()
          }
        }
        return super.onOptionsItemSelected(item)
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