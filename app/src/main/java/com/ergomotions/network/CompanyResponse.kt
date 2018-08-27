package com.ergomotions.network

data class CompanyResponse (var status: String,
                            var message: String,
                            var id: Int,
                            var employees: ArrayList<Employee>)