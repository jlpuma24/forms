package com.ergomotions.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.ergomotions.R
import com.ergomotions.adapter.SingleListAdapter
import com.ergomotions.util.Constants
import kotlinx.android.synthetic.main.activity_list_employee.*

class ListEmployeeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_employee)
        val employeesListDict = Constants.getEmployeesList()
        if (employeesListDict != null && employeesListDict.isNotEmpty()) {
            employeesList.layoutManager = LinearLayoutManager(this)
            employeesList.adapter = SingleListAdapter(this, true)
        } else {
            Toast.makeText(this, getString(R.string.no_employees), Toast.LENGTH_LONG).show()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this, EmployeeMainActivity::class.java))
        finish()
    }
}