package com.ergomotions.network

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

const val ADD_COMPANY = "addCompany"
const val LOGIN = "login"

interface ApiService {

    @POST(ADD_COMPANY)
    fun addCompany(@Body company: CompanyRequest): Call<CompanyResponse>

    @POST(LOGIN)
    fun login(@Body loginBody: LoginRequest): Call<LoginResponse>
}