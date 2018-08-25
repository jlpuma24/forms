package com.ergomotions.adapter

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.ergomotions.R
import com.ergomotions.fragments.EmployeeInfoFragment
import com.ergomotions.util.Constants.ITEMS

class SimpleFragmentPagerAdapter (private var mContext: Context, fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> EmployeeInfoFragment()
            1 -> EmployeeInfoFragment()
            2 -> EmployeeInfoFragment()
            3 -> EmployeeInfoFragment()
            4 -> EmployeeInfoFragment()
            5 -> EmployeeInfoFragment()
            6 -> EmployeeInfoFragment()
            7 -> EmployeeInfoFragment()
            8 -> EmployeeInfoFragment()
            9 -> EmployeeInfoFragment()
            10 -> EmployeeInfoFragment()
            11 -> EmployeeInfoFragment()
            12 -> EmployeeInfoFragment()
            13 -> EmployeeInfoFragment()
            else -> EmployeeInfoFragment()
        }
    }

    override fun getCount() = ITEMS

    override fun getPageTitle(position: Int) =
        when (position) {
            0 -> mContext.getString(R.string.one)
            1 -> mContext.getString(R.string.two)
            2 -> mContext.getString(R.string.three)
            3 -> mContext.getString(R.string.four)
            4 -> mContext.getString(R.string.five)
            5 -> mContext.getString(R.string.six)
            6 -> mContext.getString(R.string.seven)
            7 -> mContext.getString(R.string.eigth)
            8 -> mContext.getString(R.string.nine)
            9 -> mContext.getString(R.string.ten)
            10 -> mContext.getString(R.string.eleven)
            11 -> mContext.getString(R.string.twelve)
            12 -> mContext.getString(R.string.thirteen)
            13 -> mContext.getString(R.string.fourteen)
            else -> mContext.getString(R.string.fifteen)
    }
}