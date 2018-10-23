package com.ergomotions.activity

import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.ergomotions.BuildConfig
import com.ergomotions.R
import com.ergomotions.adapter.SimpleFragmentPagerAdapter
import com.ergomotions.network.ApiService
import com.ergomotions.network.EmployeeRequest
import com.ergomotions.network.EmployeeRequestWrapper
import com.ergomotions.network.EmployeeResponse
import com.ergomotions.util.Constants
import com.ergomotions.util.PrefsUtil
import com.ergomotions.viewModels.GeneralViewModel
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_add_employee.tabs
import kotlinx.android.synthetic.main.activity_add_employee.toolbar
import kotlinx.android.synthetic.main.activity_add_employee.viewpager
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class AddEmployeeActivity : AppCompatActivity(), HasSupportFragmentInjector {

    @Inject
    lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    @Inject
    lateinit var viewModelMap: @JvmSuppressWildcards Map<String, GeneralViewModel>

    var photosTaken: Int = 0

    private val viewPagerAdapter by lazy {
        SimpleFragmentPagerAdapter(this, supportFragmentManager)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_employee)
        viewpager.adapter = viewPagerAdapter
        tabs.setupWithViewPager(viewpager)
        toolbar.title = getString(R.string.add_employee)
        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val builder = AlertDialog.Builder(this)
        builder.setMessage(getString(R.string.info_post))
        builder.setCancelable(false)
        builder.setPositiveButton(getString(android.R.string.yes)) { dialog, _ ->
            val employee = processEmployeeResponse()
            val bodyParts = processBodyParts()
            if (employee != null) {
                if (photosTaken == 3) {
                    requestService(EmployeeRequestWrapper(employee, bodyParts))
                } else {
                    val builder = AlertDialog.Builder(this)
                    builder.setMessage(getString(R.string.photos_copy_alert))
                    builder.setCancelable(false)
                    builder.setPositiveButton(getString(android.R.string.yes)) { dialog, _ ->
                        dialog.dismiss()
                    }
                    val alert = builder.create()
                    alert.show()
                }
            }
            dialog.dismiss()
        }
        builder.setNegativeButton(getString(android.R.string.no)) { dialog, _ ->
            dialog.dismiss()
        }
        val alert = builder.create()
        alert.show()
        return super.onOptionsItemSelected(item)
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return fragmentDispatchingAndroidInjector
    }

    override fun onBackPressed() {
        startActivity(Intent(this, EmployeeMainActivity::class.java))
        finish()
    }


    private fun requestService(employee: EmployeeRequestWrapper) {
        val dialog = ProgressDialog(this)
        dialog.setMessage(getString(R.string.please_wait))
        dialog.show()

        val retrofit = Retrofit.Builder()
                .client(OkHttpClient.Builder().apply {
                    readTimeout(1, TimeUnit.MINUTES)
                    connectTimeout(1, TimeUnit.MINUTES)
                    addInterceptor(HttpLoggingInterceptor { message -> Log.e("SERVER", message) }
                            .apply {
                                level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
                                else HttpLoggingInterceptor.Level.NONE
                            })
                }.build())
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val service = retrofit.create<ApiService>(ApiService::class.java)
        service.addEmployee(employee).enqueue(object : Callback<EmployeeResponse> {
            override fun onResponse(call: Call<EmployeeResponse>, response: Response<EmployeeResponse>) {
                dialog.dismiss()
                if (response.isSuccessful && response.body() != null && response.body()!!.status == "OK") {
                    showResponseMessage(getString(R.string.success_employee_add), false)
                } else {
                    showResponseMessage(getString(R.string.error_employee_add), true)
                }
            }

            override fun onFailure(call: Call<EmployeeResponse>, t: Throwable) {
                dialog.dismiss()
                showResponseMessage(getString(R.string.error_employee_add), true)
            }
        })
    }

    private fun showResponseMessage(message: String, isError: Boolean) {
        val builder = AlertDialog.Builder(this)
        builder.setMessage(if (!isError) getString(R.string.success_employee_add) else message)
        builder.setCancelable(false)
        builder.setPositiveButton(getString(android.R.string.yes)) { dialog, _ ->
            if (!isError) {
                dialog.cancel()
                onBackPressed()
            } else {
                dialog.cancel()
            }
        }
        val alert = builder.create()
        alert.show()
    }

    private fun processBodyParts(): List<GeneralViewModel.GeneralFormData> {
        return viewModelMap.entries.map {
            val value = it.value
            value.provideData()
        }
    }

    private fun processEmployeeResponse(): EmployeeRequest? {
        return try {
            return viewPagerAdapter.getChildInformation()
        } catch (e: Throwable) {
            Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
            null
        }
    }

    @Throws(Throwable::class)
    private fun SimpleFragmentPagerAdapter.getChildInformation(): EmployeeRequest {
        val firstInfo = employeeFragment.getInfo()
        val secondInfo = workFragment.getInfo()
        val thirdInfo = habitsFragment.getInfo()
        val forthInfo = healthFragment.getInfo()
        photosTaken = takePhotosFragment.getInfo()
        return EmployeeRequest(-1, firstInfo.name, firstInfo.lastName, firstInfo.identification, firstInfo.weight,
                firstInfo.height, firstInfo.gender, firstInfo.age, firstInfo.monthsCompany,
                firstInfo.yearsCompany, firstInfo.dependency, firstInfo.dominance,
                secondInfo.jobJourney, secondInfo.workHoursByDay, secondInfo.viabilityJobJourney,
                secondInfo.viabilityJobJourneyExplanation,
                thirdInfo.smoke, thirdInfo.cigarretes, thirdInfo.howLongSmoke, thirdInfo.physicalActivity,
                thirdInfo.physicalActivityName, thirdInfo.frequency, thirdInfo.duration,
                forthInfo.inconveniences, forthInfo.sickness, forthInfo.sickName, forthInfo.observations,
                PrefsUtil.getInstance().companyId)
    }
}