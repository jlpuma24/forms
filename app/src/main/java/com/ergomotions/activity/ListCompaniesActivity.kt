package com.ergomotions.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ergomotions.R
import android.support.v7.widget.LinearLayoutManager
import com.ergomotions.adapter.SingleListAdapter
import kotlinx.android.synthetic.main.activity_list_companies.*


class ListCompaniesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_companies)
        companiesList.layoutManager = LinearLayoutManager(this)
        companiesList.adapter = SingleListAdapter(this, false)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this, CompanyMainActivity::class.java))
        finish()
    }
}