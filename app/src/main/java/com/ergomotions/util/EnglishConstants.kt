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

    private const val WALK = "Walking"
    private const val JOGGING = "Jogging"
    private const val RUNNING = "Running"
    private const val GYM = "Gymnasium"
    private const val BICYCLE = "Bicycle"
    private const val SOCCER = "Football"
    private const val BASKETBALL = "Basketball"
    private const val VOLEYBALL = "Volleyball"
    private const val SWIMMING = "Swimming"
    private const val TENNIS_COURT = "Tennis court"
    private const val CYCLOVIA  = "Cyclovia"
    private const val SKATING = "Skating"
    private const val OTHER = "Other"
    private const val OPERATOR = "Operator"
    private const val SUPERVISOR = "Supervisor"
    private const val ADMINISTRATOR = "Administrator"

    private const val ONE_CIGARRETTES_OPTION = "1 to 5 cigarrettes"
    private const val TWO_CIGARRETTES_OPTION = "6 to 15 cigarrettes"
    private const val THREE_CIGARRETTES_OPTION = "16 and more cigarrettes"

    private const val ONE_YEAR = "Less than a year"
    private const val TWO_YEAR = "1 to 2 years"
    private const val THREE_YEAR = "3 to 4 years"
    private const val FOUR_YEAR = "5 to 9 years"
    private const val FIVE_YEAR = "10 years and older"


    val CIGARRETTES_LIST : ArrayList<String> = arrayListOf(ONE_CIGARRETTES_OPTION, TWO_CIGARRETTES_OPTION, THREE_CIGARRETTES_OPTION)
    val CIGARRETTES_AGO_LIST: ArrayList<String> = arrayListOf(ONE_YEAR, TWO_YEAR, THREE_YEAR, FOUR_YEAR, FIVE_YEAR)

    val HAND_LIST: ArrayList<String> = arrayListOf(RIGHT, LEFT, BOTH)
    val GENDER_LIST: ArrayList<String> = arrayListOf(MALE, FEMALE)
    val YES_NO_LIST: ArrayList<String> = arrayListOf(YES, NO)
    val PAIN_SIDE_LIST: ArrayList<String> = arrayListOf(RIGHT_SIDE, LEFT_SIDE, BOTH)
    val AREAS: ArrayList<String> = arrayListOf(OPERATOR, SUPERVISOR, ADMINISTRATOR)
    val ACTIVITIES : ArrayList<String> = arrayListOf(WALK, JOGGING, RUNNING, GYM, BICYCLE, SOCCER, BASKETBALL, VOLEYBALL, SWIMMING, TENNIS_COURT, CYCLOVIA, SKATING, OTHER)
    val PAIN_WHEN_LIST: ArrayList<String> = arrayListOf(DO_MY_JOB, AT_END_OF_DAY, AT_MY_PLACE, AT_END_OF_WEEK, ALL_TIME)
    val PAIN_PRESENTED_HOW_LIST: ArrayList<String> = arrayListOf(PAIN, TINGLE, DISCOMFORT, NUMBNESS)
    val PAIN_AGO_LIST: ArrayList<String> = arrayListOf(ONE_WEEK, ONE_MONTH, THREE_MONTHS, SIX_MONTHS, TWELVE_MONTS, MORE_THAN_TWELVE_MONTHS)
    val PAIN_DURATION_LIST: ArrayList<String> = arrayListOf(LESS_THAN_24_HOURS, FROM_ONE_TO_SEVEN_DAYS, FROM_EIGHT_TO_THIRTY_DAYS, PERMANENT_WAY, INTERMITTENT_WAY)
    val PAIN_LEVEL_LIST: ArrayList<String> = arrayListOf(NOTHING, LITTLE_AKWARD, MEDIUM_AKWARD, VERY_AKWARD)
    val JOB_JOURNEY_LIST: ArrayList<String> = arrayListOf(FIRST_RANGE, SECOND_RANGE, THIRD_RANGE, FOUR_RANGE, EIGHT_RANGE, NINE_RANGE, TEN_RANGE)
    val DURATION_LIST: ArrayList<String> = arrayListOf(DAILY, TWO_TIMES_AT_WEEK, THREE_TIMES_AT_WEEK, WEEKENDS)
    val FREQUENCY_LIST: ArrayList<String> = arrayListOf(FIFTEEN_MINUTES, THIRTY_MINUTES, ONE_HOUR, MORE_THAN_ONE_HOUR)
    val PAIN_LEVEL_WORK_LIST: ArrayList<String> = arrayListOf(NOTHING_AT_ALL, LITTLE_INTERFERENCE, SUBSTANTIAL_INTERFERENCE)

    val FREQUENCY_WORK_LIST: List<Int> = (1.. 24).toList()

}