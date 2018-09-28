package com.ergomotions.network

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

const val ADD_COMPANY = "addCompany"
const val ADD_EMPLOYEE = "addEmployee"
const val EDIT_EMPLOYEE = "editEmployee"
const val REPORT = "employeeReport"
const val LOGIN = "login"

interface ApiService {

    @POST(ADD_COMPANY)
    fun addCompany(@Body company: CompanyRequest): Call<CompanyResponse>

    @POST(ADD_EMPLOYEE)
    fun addEmployee(@Body company: EmployeeRequestWrapper): Call<EmployeeResponse>

    @POST(EDIT_EMPLOYEE)
    fun editEmployee(@Body company: EmployeeRequest): Call<EmployeeResponse>

    @POST(REPORT)
    fun getReport(@Body body: ReportRequest): Call<ReportResponse>

    @POST(LOGIN)
    fun login(@Body loginBody: LoginRequest): Call<LoginResponse>
}