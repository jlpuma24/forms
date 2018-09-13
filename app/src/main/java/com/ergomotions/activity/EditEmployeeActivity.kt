package com.ergomotions.activity

import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import com.ergomotions.R
import kotlinx.android.synthetic.main.activity_edit_employee.*
import android.content.Intent



class EditEmployeeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_employee)

        editTextName.setText(intent.getStringExtra("employeeName"))
        editTextLastName.setText(intent.getStringExtra("employeeLastname"))
        editTextId.setText(intent.getStringExtra("employeeIdentification"))

        buttonUpdate.setOnClickListener {
            val builder = AlertDialog.Builder(this@EditEmployeeActivity)
            builder.setMessage(getString(R.string.success_update))
            builder.setPositiveButton(getString(R.string.accept)) {_, _ ->
                val intent = Intent(applicationContext, EmployeeMainActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
                finish()
            }
            val dialog: AlertDialog = builder.create()
            dialog.show()
        }
    }

}