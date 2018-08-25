package com.ergomotions.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.ergomotions.R
import com.ergomotions.adapter.SimpleFragmentPagerAdapter
import kotlinx.android.synthetic.main.activity_add_employee.*

class AddEmployeeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_employee)
        viewpager.adapter = SimpleFragmentPagerAdapter(this, supportFragmentManager)
        tabs.setupWithViewPager(viewpager)
        toolbar.title = getString(R.string.add_employee)
        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {

        }
        return super.onOptionsItemSelected(item)
    }
}