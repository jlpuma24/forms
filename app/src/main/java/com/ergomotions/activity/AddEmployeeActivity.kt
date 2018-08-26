package com.ergomotions.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.ergomotions.R
import com.ergomotions.adapter.SimpleFragmentPagerAdapter
import com.ergomotions.viewModels.GeneralViewModel
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_add_employee.tabs
import kotlinx.android.synthetic.main.activity_add_employee.toolbar
import kotlinx.android.synthetic.main.activity_add_employee.viewpager
import javax.inject.Inject

class AddEmployeeActivity : AppCompatActivity(), HasSupportFragmentInjector {

    @Inject
    lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    @Inject
    lateinit var viewModelMap: @JvmSuppressWildcards Map<String, GeneralViewModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
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
//        when (item?.itemId) {
        viewModelMap.entries.forEach {
            val value = it.value
            val key = it.key
            Log.d("Jose Degug", "Para $key el valor es ${value.provideData()}")
        }
//        }
        return super.onOptionsItemSelected(item)
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return fragmentDispatchingAndroidInjector
    }
}