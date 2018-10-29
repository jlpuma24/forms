package com.ergomotions.fragments

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.ergomotions.R
import com.ergomotions.activity.EmployeeMainActivity

class CompanyReportFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v =  inflater?.inflate(R.layout.fragment_company_report, container, false)
        v?.findViewById<TextView>(R.id.mainMenuButton)?.setOnClickListener {
            goToMainMenu()
        }
        v?.findViewById<TextView>(R.id.exitButton)?.setOnClickListener {
            goToMainMenu()
        }
        return v
    }

    private fun goToMainMenu() {
        val builder = AlertDialog.Builder(activity)
        builder.setMessage(getString(R.string.exit_survey))
        builder.setCancelable(false)
        builder.setPositiveButton(getString(android.R.string.yes)) { dialog, _ ->
            dialog.dismiss()
            val intent = Intent(activity, EmployeeMainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            activity.finish()
        }
        builder.setNegativeButton(getString(android.R.string.no)) { dialog, _ ->
            dialog.dismiss()
        }
        val alert = builder.create()
        alert.show()
    }
}