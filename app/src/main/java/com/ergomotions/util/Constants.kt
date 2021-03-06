package com.ergomotions.util

import com.ergomotions.network.ReportResponse

object Constants {

    const val SPLASH_DISPLAY_LENGTH = 1500L
    const val ITEMS = 21
    const val BASE_URL = "http://ec2-52-14-239-106.us-east-2.compute.amazonaws.com:8001/api/"

    private const val MALE = "Masculino"
    private const val FEMALE = "Femenino"
    private const val YES = "Si"
    private const val NO = "No"

    private const val RIGHT = "Derecho"
    private const val LEFT = "Izquierdo"
    private const val BOTH = "Ambos"

    private const val LEFT_SIDE = "Lado izquierdo"
    private const val RIGHT_SIDE = "Lado derecho"

    private const val DO_MY_JOB = "Al realizar mi trabajo"
    private const val AT_END_OF_DAY =  "Al final del dia"
    private const val AT_MY_PLACE = "En mi casa"
    private const val ALL_TIME = "Todo el tiempo"
    private const val AT_END_OF_WEEK = "Al final de la semana"
    private const val PAIN = "Dolor"
    private const val TINGLE = "Hormigueo"
    private const val DISCOMFORT =  "Malestar"
    private const val NUMBNESS = "Adormecimiento"

    private const val ONE_WEEK = "1 semana"
    private const val ONE_MONTH = "1 mes"
    private const val THREE_MONTHS = "3 meses"
    private const val SIX_MONTHS = "6 meses"
    private const val TWELVE_MONTS = "12 meses"
    private const val MORE_THAN_TWELVE_MONTHS = "Mas de 12 meses"

    private const val LESS_THAN_24_HOURS = "Menos de 24 horas"
    private const val FROM_ONE_TO_SEVEN_DAYS = "De 1 a 7 dias"
    private const val FROM_EIGHT_TO_THIRTY_DAYS = "De 8 a 30 dias"
    private const val PERMANENT_WAY = "De manera permanente"
    private const val INTERMITTENT_WAY = "De manera intermitente"

    private const val NOTHING = "Nada"
    private const val LITTLE_AKWARD = "Un poco incomodo"
    private const val MEDIUM_AKWARD = "Moderamente incomodo"
    private const val VERY_AKWARD = "Muy incomodo"

    private const val NOTHING_AT_ALL = "No en lo absoluto"
    private const val LITTLE_INTERFERENCE = "Poca interferencia"
    private const val SUBSTANTIAL_INTERFERENCE = "Interfiere sustancialmente"

    private const val FIFTEEN_MINUTES  = "15 min"
    private const val THIRTY_MINUTES = "30 min"
    private const val ONE_HOUR = "1 hora"
    private const val MORE_THAN_ONE_HOUR = "Mas de una hora"

    private const val DAILY = "Diario"
    private const val TWO_TIMES_AT_WEEK = "Dos veces a la semana"
    private const val THREE_TIMES_AT_WEEK = "Tres veces a la semana"
    private const val WEEKENDS = "Fines de semana"

    private const val FIRST_RANGE = "0H - 1H"
    private const val SECOND_RANGE = "1H - 2H"
    private const val THIRD_RANGE = "2H - 4H"
    private const val FOUR_RANGE = "4H - 6H"
    private const val EIGHT_RANGE = "8H"
    private const val NINE_RANGE = "12H"
    private const val TEN_RANGE = "Otro"

    private const val WALK = "Caminar"
    private const val JOGGING = "Trotar"
    private const val RUNNING = "Corriendo"
    private const val GYM = "Gimnasio"
    private const val BICYCLE = "Bicicleta"
    private const val SOCCER = "Futbol"
    private const val BASKETBALL = "Baloncesto"
    private const val VOLEYBALL = "Voleibol"
    private const val SWIMMING = "Nadando"
    private const val TENNIS_COURT = "Pista de tenis"
    private const val CYCLOVIA  = "Cyclovia"
    private const val SKATING = "Patinaje"
    private const val OTHER = "Otro"
    private const val OPERATOR = "Operador"
    private const val SUPERVISOR = "Supervisor"
    private const val ADMINISTRATOR = "Administrador"

    private const val ONE_CIGARRETTES_OPTION = "De 1 a 5 cigarrillos"
    private const val TWO_CIGARRETTES_OPTION = "De 6 a 15 cigarrillos"
    private const val THREE_CIGARRETTES_OPTION = "16 o mas cigarrillos"

    private const val ONE_YEAR = "Menos de 1 año"
    private const val TWO_YEAR = "1 a 2 años"
    private const val THREE_YEAR = "3 a 4 años"
    private const val FOUR_YEAR = "5 a 9 años"
    private const val FIVE_YEAR = "10 años o más"

    val CIGARRETTES_LIST : ArrayList<String> = arrayListOf(ONE_CIGARRETTES_OPTION, TWO_CIGARRETTES_OPTION, THREE_CIGARRETTES_OPTION)
    val CIGARRETTES_AGO_LIST: ArrayList<String> = arrayListOf(ONE_YEAR, TWO_YEAR, THREE_YEAR, FOUR_YEAR, FIVE_YEAR)

    val HAND_LIST : ArrayList<String> = arrayListOf(RIGHT, LEFT, BOTH)
    val GENDER_LIST: ArrayList<String> = arrayListOf(MALE, FEMALE)
    val YES_NO_LIST: ArrayList<String> = arrayListOf(YES, NO)
    val PAIN_SIDE_LIST: ArrayList<String> = arrayListOf(RIGHT_SIDE, LEFT_SIDE, BOTH)
    val AREAS: ArrayList<String> = arrayListOf(OPERATOR, SUPERVISOR, ADMINISTRATOR)
    val ACTIVITIES : ArrayList<String> = arrayListOf(WALK, JOGGING, RUNNING, GYM, BICYCLE, SOCCER, BASKETBALL, VOLEYBALL, SWIMMING, TENNIS_COURT, CYCLOVIA, SKATING, OTHER)
    val PAIN_WHEN_LIST: ArrayList<String> = arrayListOf(DO_MY_JOB, AT_END_OF_DAY, AT_MY_PLACE ,AT_END_OF_WEEK, ALL_TIME)
    val PAIN_PRESENTED_HOW_LIST: ArrayList<String> = arrayListOf(PAIN, TINGLE, DISCOMFORT, NUMBNESS)
    val PAIN_AGO_LIST: ArrayList<String> = arrayListOf(ONE_WEEK, ONE_MONTH, THREE_MONTHS, SIX_MONTHS, TWELVE_MONTS, MORE_THAN_TWELVE_MONTHS)
    val PAIN_DURATION_LIST: ArrayList<String> = arrayListOf(LESS_THAN_24_HOURS, FROM_ONE_TO_SEVEN_DAYS, FROM_EIGHT_TO_THIRTY_DAYS, PERMANENT_WAY, INTERMITTENT_WAY)
    val PAIN_INTENSITY_LIST: List<Int> = (0.. 10).toList()
    val HOW_MANY_CIGARRETES_LIST: List<Int> = (0.. 9).toList()
    val PAIN_LEVEL_LIST: ArrayList<String> = arrayListOf(NOTHING, LITTLE_AKWARD, MEDIUM_AKWARD, VERY_AKWARD)
    val JOB_JOURNEY_LIST: ArrayList<String> = arrayListOf(FIRST_RANGE, SECOND_RANGE, THIRD_RANGE, FOUR_RANGE, EIGHT_RANGE, NINE_RANGE, TEN_RANGE)
    val DURATION_LIST: ArrayList<String> = arrayListOf(DAILY, TWO_TIMES_AT_WEEK, THREE_TIMES_AT_WEEK, WEEKENDS)
    val FREQUENCY_LIST: ArrayList<String> = arrayListOf(FIFTEEN_MINUTES, THIRTY_MINUTES, ONE_HOUR, MORE_THAN_ONE_HOUR)
    val FREQUENCY_WORK_LIST: List<Int> = (1.. 24).toList()
    val PAIN_LEVEL_WORK_LIST: ArrayList<String> = arrayListOf(NOTHING_AT_ALL, LITTLE_INTERFERENCE, SUBSTANTIAL_INTERFERENCE)

    private lateinit var reportResponse: ReportResponse

    fun getHowManyCigarretesList() : ArrayList<String> {
        val result = ArrayList<String>()
        HOW_MANY_CIGARRETES_LIST.map { result.add(it.toString()) }
        return result
    }

    fun getReportResponse() = reportResponse

    fun setReportResponse(reportResponseObject: ReportResponse) {
        reportResponse = reportResponseObject
    }

    fun getEmployeesList() = PrefsUtil.getInstance().userData.companies.firstOrNull { it.id == PrefsUtil.getInstance().companyId }?.employees
}