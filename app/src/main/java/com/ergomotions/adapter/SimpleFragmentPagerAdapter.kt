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
            6  -> GeneralFragment.newInstance(GeneralFragment.ARM)
            7 -> GeneralFragment.newInstance(GeneralFragment.ELBOW)
            8 -> GeneralFragment.newInstance(GeneralFragment.FOREARM)
            9 -> GeneralFragment.newInstance(GeneralFragment.WRIST)
            10 -> GeneralFragment.newInstance(GeneralFragment.HAND)
            11 -> GeneralFragment.newInstance(GeneralFragment.FINGER)
            12 -> GeneralFragment.newInstance(GeneralFragment.HIGH_BAG)
            13 -> GeneralFragment.newInstance(GeneralFragment.LOW_BAG)
            14 -> GeneralFragment.newInstance(GeneralFragment.HIP)
            15 -> GeneralFragment.newInstance(GeneralFragment.TIGHT)
            16 -> GeneralFragment.newInstance(GeneralFragment.KNEE)
            17 -> GeneralFragment.newInstance(GeneralFragment.LEG)
            18 -> GeneralFragment.newInstance(GeneralFragment.FOOT)
            19 -> TakePhotosFragment()
            else -> CompanyReportFragment()
        }
    }

    override fun getCount() = ITEMS

    override fun getPageTitle(position: Int): String {
        return when (position) {
            0 -> mContext.getString(R.string.one)
            1 -> mContext.getString(R.string.two)
            2 -> mContext.getString(R.string.three)
            3 -> mContext.getString(R.string.four)
            4 -> mContext.getString(R.string.six)
            5 -> mContext.getString(R.string.seven)
            6 -> mContext.getString(R.string.new_eigth)
            7 -> mContext.getString(R.string.eigth)
            8 -> mContext.getString(R.string.nine)
            9 -> mContext.getString(R.string.ten)
            10 ->mContext.getString(R.string.eleven)
            11 -> mContext.getString(R.string.twelve)
            12 -> mContext.getString(R.string.thirteen)
            13 -> mContext.getString(R.string.fourteen)
            14 -> mContext.getString(R.string.fifteen)
            15 -> mContext.getString(R.string.sixteen)
            16 -> mContext.getString(R.string.seventeen)
            17 -> mContext.getString(R.string.eighteen)
            18 -> mContext.getString(R.string.nineteen)
            19 -> mContext.getString(R.string.photos)
            else -> mContext.getString(R.string.company_report)
        }
    }
}