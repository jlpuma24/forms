package com.ergomotions.adapter

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.ergomotions.R
import com.ergomotions.fragments.*
import com.ergomotions.util.Constants.ITEMS

class SimpleFragmentPagerAdapter (private var mContext: Context, fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> EmployeeInfoFragment()
            1 -> YourWorkFragment()
            2 -> YourHabitsFragment()
            3 -> HealthStateFragment()
            4 -> GeneralFragment.newInstance(GeneralFragment.CERVIX)
            5 -> GeneralFragment.newInstance(GeneralFragment.SHOULDER)
            6 -> GeneralFragment.newInstance(GeneralFragment.ELBOW)
            7 -> GeneralFragment.newInstance(GeneralFragment.FOREARM)
            8 -> GeneralFragment.newInstance(GeneralFragment.WRIST)
            9 -> GeneralFragment.newInstance(GeneralFragment.HAND)
            10 -> GeneralFragment.newInstance(GeneralFragment.FINGER)
            11 -> GeneralFragment.newInstance(GeneralFragment.LOW_BAG)
            12 -> GeneralFragment.newInstance(GeneralFragment.HIGH_BAG)
            else -> GeneralFragment.newInstance(GeneralFragment.HIP)
        }
    }

    override fun getCount() = ITEMS

    override fun getPageTitle(position: Int) =
        when (position) {
            0 -> mContext.getString(R.string.one)
            1 -> mContext.getString(R.string.two)
            2 -> mContext.getString(R.string.three)
            3 -> mContext.getString(R.string.four)
            4 -> mContext.getString(R.string.six)
            5 -> mContext.getString(R.string.seven)
            6 -> mContext.getString(R.string.eigth)
            7 -> mContext.getString(R.string.nine)
            8 -> mContext.getString(R.string.ten)
            9 -> mContext.getString(R.string.eleven)
            10 -> mContext.getString(R.string.twelve)
            11 -> mContext.getString(R.string.thirteen)
            12 -> mContext.getString(R.string.fourteen)
            else -> mContext.getString(R.string.fifteen)
    }
}