package com.ergomotions.network

data class LoginResponse (var status: String, var companies: ArrayList<CompanyRequest>, var id: Int, var message: String)