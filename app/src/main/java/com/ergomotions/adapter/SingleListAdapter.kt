package com.ergomotions.adapter

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.TextView
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.ergomotions.R
import com.ergomotions.util.PrefsUtil
import android.view.LayoutInflater
import com.ergomotions.activity.EditEmployeeActivity
import com.ergomotions.activity.EmployeeMainActivity
import com.ergomotions.util.Constants


class SingleListAdapter (private var mContext: Context, private var isEmployeesList: Boolean) : RecyclerView.Adapter<SingleListAdapter.CompaniesViewHolder>() {

    var companies = PrefsUtil.getInstance().userData.companies
    var employees = Constants.getEmployeesList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompaniesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.layout_list_cell, parent, false)
        return CompaniesViewHolder(view)
    }

    override fun getItemCount(): Int = if (!isEmployeesList) companies.size else employees?.size!!

    override fun onBindViewHolder(holder: CompaniesViewHolder?, position: Int) {
        holder?.itemView?.setOnClickListener {
            if (!isEmployeesList) {
                PrefsUtil.getInstance().companyId = companies[position].id
                mContext.startActivity(Intent(mContext, EmployeeMainActivity::class.java))
                (mContext as Activity).finish()
            } else {
                val intent = Intent(mContext, EditEmployeeActivity::class.java)
                intent.putExtra("employeeName", employees!![position].name)
                intent.putExtra("employeeLastname", employees!![position].lastName)
                intent.putExtra("employeeIdentification", employees!![position].identification)
                intent.putExtra("employeeId", employees!![position].id)
                intent.putExtra("employeeWeight", employees!![position].weight)
                intent.putExtra("employeeHeight", employees!![position].height)
                intent.putExtra("employeeAge", employees!![position].age)
                intent.putExtra("employeeDependency", employees!![position].dependency)
                intent.putExtra("employeeYears", employees!![position].yearsCompany)
                intent.putExtra("employeeMonths", employees!![position].monthsCompany)
                intent.putExtra("employeeGender", employees!![position].gender)
                intent.putExtra("employeeDominance", employees!![position].dominance)
                mContext.startActivity(intent)
            }
        }
        if (!isEmployeesList) {
            holder?.display(companies[position].name)
        } else {
            holder?.display(employees!![position].name + " " + employees!![position].lastName)
        }
    }

    inner class CompaniesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val name: TextView = itemView.findViewById(R.id.name) as TextView
        fun display(nameString: String) {
            name.text = nameString
        }
    }
}