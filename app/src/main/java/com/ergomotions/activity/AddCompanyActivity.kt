package com.ergomotions.activity

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ergomotions.R
import com.ergomotions.network.ApiService
import com.ergomotions.network.CompanyRequest
import com.ergomotions.network.CompanyResponse
import com.ergomotions.util.Constants
import com.ergomotions.util.DateUtil
import com.shagi.materialdatepicker.date.DatePickerFragmentDialog
import kotlinx.android.synthetic.main.activity_add_company.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import java.util.*
import android.app.AlertDialog
import android.content.Intent
import retrofit2.converter.gson.GsonConverterFactory


class AddCompanyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_company)

        editTextDate.setOnClickListener {
            val dialog = DatePickerFragmentDialog.newInstance({ _, year, monthOfYear, dayOfMonth ->
                editTextDate.setText(DateUtil.getDateStringFromPicker(year, monthOfYear, dayOfMonth))
            }, Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH) + 1, Calendar.getInstance().get(Calendar.DAY_OF_MONTH))
            dialog.show(supportFragmentManager, "tag")
        }
        buttonCreateCompany.setOnClickListener {
            postData()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this, CompanyMainActivity::class.java))
        finish()
    }

    private fun postData() {
        val dialog = ProgressDialog(this)
        dialog.setMessage(getString(R.string.please_wait))
        dialog.show()

        val retrofit = Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val service = retrofit.create<ApiService>(ApiService::class.java)
        service.addCompany(CompanyRequest(editTextName.text.toString(), editTextNit.text.toString(),
                editTextCity.text.toString(), editTextDeparment.text.toString(),
                editTextDate.text.toString())).enqueue(object : Callback<CompanyResponse> {
            override fun onResponse(call: Call<CompanyResponse>, response: Response<CompanyResponse>) {
                dialog.dismiss()
                if (response.isSuccessful && response.body() != null && response.body()!!.status == "OK") {
                    showResponseMessage(getString(R.string.success_company_add), false)
                } else {
                    showResponseMessage(getString(R.string.error_company_add), true)
                }
            }
            override fun onFailure(call: Call<CompanyResponse>, t: Throwable) {
                dialog.dismiss()
                showResponseMessage(getString(R.string.error_company_add), true)
            }
        })
    }

    private fun showResponseMessage(message: String, isError: Boolean) {
        val builder = AlertDialog.Builder(this)
        builder.setMessage(getString(R.string.success_company_add))
        builder.setCancelable(false)
        builder.setPositiveButton(getString(android.R.string.yes)) { dialog , _ ->
            if (!isError) {
                startActivity(Intent(applicationContext, EmployeeMainActivity::class.java))
                finish()
            } else {
                dialog.cancel()
            }
        }
        val alert = builder.create()
        alert.show()
    }
}