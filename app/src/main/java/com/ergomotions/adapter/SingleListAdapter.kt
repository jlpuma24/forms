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
import com.ergomotions.activity.EmployeeMainActivity


class SingleListAdapter (var mContext: Context) : RecyclerView.Adapter<SingleListAdapter.CompaniesViewHolder>() {

    var companies = PrefsUtil.getInstance().userData.companies

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompaniesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.layout_list_cell, parent, false)
        return CompaniesViewHolder(view)
    }

    override fun getItemCount() = companies.size

    override fun onBindViewHolder(holder: CompaniesViewHolder?, position: Int) {
        holder?.itemView?.setOnClickListener {
            PrefsUtil.getInstance().companyId = companies[position].id
            mContext.startActivity(Intent(mContext, EmployeeMainActivity::class.java))
            (mContext as Activity).finish()
        }
        holder?.display(companies[position].name)
    }

    inner class CompaniesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val name: TextView = itemView.findViewById(R.id.name) as TextView
        fun display(nameString: String) {
            name.text = nameString
        }
    }
}