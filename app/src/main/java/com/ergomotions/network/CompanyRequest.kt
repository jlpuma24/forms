package com.ergomotions.network

data class CompanyRequest (var name: String,
                           var nit: String,
                           var city: String,
                           var department: String,
                           var date: String,
                           var id: Int,
                           var employees: ArrayList<EmployeeRequest>)