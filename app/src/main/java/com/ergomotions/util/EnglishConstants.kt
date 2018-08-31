package com.ergomotions.util

object EnglishConstants {

    private const val MALE = "Male"
    private const val FEMALE = "Female"
    private const val YES = "Yes"
    private const val NO = "No"
    private const val RIGHT = "Right"
    private const val LEFT = "Left"
    private const val BOTH = "Both"
    private const val LEFT_SIDE = "Left side"
    private const val RIGHT_SIDE = "Right side"
    private const val DO_MY_JOB = "When I do my job"
    private const val AT_END_OF_DAY = "At the end of the day"
    private const val AT_MY_PLACE = "In my house"
    private const val ALL_TIME = "All the time"
    private const val AT_END_OF_WEEK = "At the end of the week"
    private const val PAIN = "Pain"
    private const val TINGLE = "Tingling"
    private const val DISCOMFORT = "Upset"
    private const val NUMBNESS = "Numbness"
    private const val ONE_WEEK = "1 week"
    private const val ONE_MONTH = "1 month"
    private const val THREE_MONTHS = "3 months"
    private const val SIX_MONTHS = "6 months"
    private const val TWELVE_MONTS = "12 months"
    private const val MORE_THAN_TWELVE_MONTHS = "More than 12 months"
    private const val LESS_THAN_24_HOURS = "Less than 24 hours"
    private const val FROM_ONE_TO_SEVEN_DAYS = "From 1 to 7 days"
    private const val FROM_EIGHT_TO_THIRTY_DAYS = "From 8 to 30 days"
    private const val PERMANENT_WAY = "Permanently"
    private const val INTERMITTENT_WAY = "Intermittently"
    private const val NOTHING = "Nothing"
    private const val LITTLE_AKWARD = "A little uncomfortable"
    private const val MEDIUM_AKWARD = "Moderately uncomfortable"
    private const val VERY_AKWARD = "Very uncomfortable"
    private const val NOTHING_AT_ALL = "Not at all"
    private const val LITTLE_INTERFERENCE = "Little interference"
    private const val SUBSTANTIAL_INTERFERENCE = "Substantially interferes"
    private const val FIFTEEN_MINUTES = "15 min"
    private const val THIRTY_MINUTES = "30 min"
    private const val ONE_HOUR = "1 hour"
    private const val MORE_THAN_ONE_HOUR = "More than one hour"
    private const val DAILY = "Diary"
    private const val TWO_TIMES_AT_WEEK = "Twice a week"
    private const val THREE_TIMES_AT_WEEK = "Three times a week"
    private const val WEEKENDS = "Weekends"
    private const val FIRST_RANGE = "0H - 1H"
    private const val SECOND_RANGE = "1H - 2H"
    private const val THIRD_RANGE = "2H - 4H"
    private const val FOUR_RANGE = "4H - 6H"
    private const val EIGHT_RANGE = "8H"
    private const val NINE_RANGE = "12H"
    private const val TEN_RANGE = "Other"

    val HAND_LIST: ArrayList<String> = arrayListOf(RIGHT, LEFT, BOTH)
    val GENDER_LIST: ArrayList<String> = arrayListOf(MALE, FEMALE)
    val YES_NO_LIST: ArrayList<String> = arrayListOf(YES, NO)
    val PAIN_SIDE_LIST: ArrayList<String> = arrayListOf(RIGHT_SIDE, LEFT_SIDE, BOTH)
    val PAIN_WHEN_LIST: ArrayList<String> = arrayListOf(DO_MY_JOB, AT_END_OF_DAY, AT_MY_PLACE, AT_END_OF_WEEK, ALL_TIME)
    val PAIN_PRESENTED_HOW_LIST: ArrayList<String> = arrayListOf(PAIN, TINGLE, DISCOMFORT, NUMBNESS)
    val PAIN_AGO_LIST: ArrayList<String> = arrayListOf(ONE_WEEK, ONE_MONTH, THREE_MONTHS, SIX_MONTHS, TWELVE_MONTS, MORE_THAN_TWELVE_MONTHS)
    val PAIN_DURATION_LIST: ArrayList<String> = arrayListOf(LESS_THAN_24_HOURS, FROM_ONE_TO_SEVEN_DAYS, FROM_EIGHT_TO_THIRTY_DAYS, PERMANENT_WAY, INTERMITTENT_WAY)
    val PAIN_LEVEL_LIST: ArrayList<String> = arrayListOf(NOTHING, LITTLE_AKWARD, MEDIUM_AKWARD, VERY_AKWARD)
    val JOB_JOURNEY_LIST: ArrayList<String> = arrayListOf(FIRST_RANGE, SECOND_RANGE, THIRD_RANGE, FOUR_RANGE, EIGHT_RANGE, NINE_RANGE, TEN_RANGE)
    val DURATION_LIST: ArrayList<String> = arrayListOf(DAILY, TWO_TIMES_AT_WEEK, THREE_TIMES_AT_WEEK, WEEKENDS)
    val FREQUENCY_LIST: ArrayList<String> = arrayListOf(FIFTEEN_MINUTES, THIRTY_MINUTES, ONE_HOUR, MORE_THAN_ONE_HOUR)
    val PAIN_LEVEL_WORK_LIST: ArrayList<String> = arrayListOf(NOTHING_AT_ALL, LITTLE_INTERFERENCE, SUBSTANTIAL_INTERFERENCE)

}