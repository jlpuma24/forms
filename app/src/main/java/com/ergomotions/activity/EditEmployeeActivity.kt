package com.ergomotions.activity

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import com.ergomotions.R
import kotlinx.android.synthetic.main.activity_edit_employee.*
import android.content.Intent
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import com.ergomotions.BuildConfig
import com.ergomotions.network.ApiService
import com.ergomotions.network.EmployeeRequest
import com.ergomotions.network.EmployeeResponse
import com.ergomotions.util.Constants
import kotlinx.android.synthetic.main.fragment_worker_info.*
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class EditEmployeeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_employee)

        editTextName.setText(intent.getStringExtra("employeeName"))
        editTextLastName.setText(intent.getStringExtra("employeeLastname"))
        editTextId.setText(intent.getStringExtra("employeeIdentification"))

        buttonUpdate.setOnClickListener {

            val dialog = ProgressDialog(this)
            dialog.setMessage(getString(R.string.please_wait))
            dialog.show()

            val employee = EmployeeRequest(intent.getIntExtra("employeeId", -1), editTextName.text.toString(), editTextLastName.text.toString(),
                    editTextId.text.toString(), editTextWeight.text.toString(),
                    editTextHeight.text.toString(), 2, editTextHeight.text.toString(),
                    editTextMonths.text.toString(), editTextYears.text.toString(), editTextArea.text.toString(),
                    -1,"",-1,"", -1, -1,
                    "", -1, "", -1, -1, -1, -1,
                    "", "", -1)

            val retrofit = Retrofit.Builder()
                    .client(OkHttpClient.Builder().apply {
                        readTimeout(1, TimeUnit.MINUTES)
                        connectTimeout(1, TimeUnit.MINUTES)
                    }.build())
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

            val service = retrofit.create<ApiService>(ApiService::class.java)
            service.editEmployee(employee).enqueue(object : Callback<EmployeeResponse> {
                override fun onResponse(call: Call<EmployeeResponse>, response: Response<EmployeeResponse>) {
                    dialog.dismiss()
                    if (response.isSuccessful && response.body() != null && response.body()!!.status == "OK") {
                        val builder = AlertDialog.Builder(this@EditEmployeeActivity)
                        builder.setMessage(getString(R.string.success_update))
                        builder.setPositiveButton(getString(R.string.accept)) {_, _ ->
                            val intent = Intent(applicationContext, EmployeeMainActivity::class.java)
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                            startActivity(intent)
                            finish()
                        }
                        val alertDialog: AlertDialog = builder.create()
                        alertDialog.show()
                    } else {
                        val builder = AlertDialog.Builder(this@EditEmployeeActivity)
                        builder.setMessage(getString(R.string.error_employee_add))
                        builder.setPositiveButton(getString(R.string.accept)) { dialog, _ ->
                            dialog.dismiss()
                        }
                        val alertDialog: AlertDialog = builder.create()
                        alertDialog.show()
                    }
                }

                override fun onFailure(call: Call<EmployeeResponse>, t: Throwable) {
                    dialog.dismiss()
                    val builder = AlertDialog.Builder(this@EditEmployeeActivity)
                    builder.setMessage(getString(R.string.error_employee_add))
                    builder.setPositiveButton(getString(R.string.accept)) { dialog, _ ->
                        dialog.dismiss()
                    }
                    val alertDialog: AlertDialog = builder.create()
                    alertDialog.show()
                }
            })
        }

        editTextAge.setText(intent.getStringExtra("employeeAge"))
        editTextArea.setText(intent.getStringExtra("employeeDependency"))

        editTextYears.setText(intent.getStringExtra("employeeYears"))
        editTextMonths.setText(intent.getStringExtra("employeeMonths"))

        editTextWeight?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (!s.toString().isEmpty()) {
                    if (!editTextHeight?.text.toString().isEmpty()) {
                        val heightInMts = editTextHeight?.text.toString().toDouble() / 100
                        val imc = s.toString().toDouble() / Math.pow(heightInMts, 2.0)
                        editTextImc?.setText("%.2f".format(imc))
                    }
                }
            }
        })
        editTextHeight?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (!s.toString().isEmpty()) {
                    if (!editTextWeight?.text.toString().isEmpty()) {
                        val heightInMts = s.toString().toDouble() / 100
                        val imc = (editTextWeight?.text.toString().toDouble()) / Math.pow(heightInMts, 2.0)
                        editTextImc?.setText("%.2f".format(imc))
                    }
                }
            }

        })

        editTextWeight.setText(intent.getStringExtra("employeeWeight"))
        editTextHeight.setText(intent.getStringExtra("employeeHeight"))
    }
}