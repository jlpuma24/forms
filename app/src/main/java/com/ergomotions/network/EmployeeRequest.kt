package com.ergomotions.network

import com.google.gson.annotations.SerializedName

data class EmployeeRequest(
        @SerializedName("id") val id: Int,
        @SerializedName("name") val name: String,
        @SerializedName("lastname") val lastName: String,
        @SerializedName("identification") val identification: String,
        @SerializedName("weight") val weight: String,
        @SerializedName("height") val height: String,
        @SerializedName("gender") val gender: Int,
        @SerializedName("age") val age: String,
        @SerializedName("monthsCompany") val monthsCompany: String,
        @SerializedName("yearsCompany") val yearsCompany: String,
        @SerializedName("dependency") val dependency: String,
        @SerializedName("dominance") val dominance: String,
        @SerializedName("jobJourney") val jobJourney: Int,
        @SerializedName("workHoursByDay") val workHoursByDay: String,
        @SerializedName("viabilityJobJourney") val viabilityJobJourney: Int,
        @SerializedName("viabilityJobJourneyExplanation") val viabilityJobJourneyExplanation: String,
        @SerializedName("smoke") val smoke: Int,
        @SerializedName("cigarretes") val cigarretes: Int,
        @SerializedName("howLongSmoke") val howLongSmoke: String,
        @SerializedName("physicalActivity") val physicalActivity: Int,
        @SerializedName("physicalActivityName") val physicalActivityName: String,
        @SerializedName("frequency") val frequency: Int,
        @SerializedName("duration") val duration: Int,
        @SerializedName("inconveniences") val inconveniences: Int,
        @SerializedName("sickness") val sickness: Int,
        @SerializedName("sickName") val sickName: String,
        @SerializedName("observations") val observations: String,
        @SerializedName("company") val company: Int
)