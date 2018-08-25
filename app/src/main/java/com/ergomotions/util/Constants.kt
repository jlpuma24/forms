package com.ergomotions.util

object Constants {
    const val SPLASH_DISPLAY_LENGTH = 1500L
    const val ITEMS = 15
    const val BASE_URL = "http://ec2-18-188-78-198.us-east-2.compute.amazonaws.com:8001/api/"
    const val MALE = "Masculino"
    const val FEMALE = "Femenino"
    const val YES = "Si"
    const val NO = "No"
    const val RIGHT = "Derecho"
    const val LEFT = "Izquierdo"
    const val BOTH = "Ambos"
    const val LEFT_SIDE = "Lado izquierdo"
    const val RIGHT_SIDE = "Lado derecho"
    const val DO_MY_JOB = "Al realizar mi trabajo"
    const val AT_END_OF_DAY =  "Al final del dia"
    const val AT_MY_PLACE = "En mi casa"
    const val ALL_TIME = "Todo el tiempo"
    const val AT_END_OF_WEEK = "Al final de la semana"
    val HAND_LIST : ArrayList<String> = arrayListOf(RIGHT, LEFT, BOTH)
    val GENDER_LIST: ArrayList<String> = arrayListOf(MALE, FEMALE)
    val YES_NO_LIST: ArrayList<String> = arrayListOf(YES, NO)
    val PAIN_SIDE_LIST: ArrayList<String> = arrayListOf(RIGHT_SIDE, LEFT_SIDE, BOTH)
}