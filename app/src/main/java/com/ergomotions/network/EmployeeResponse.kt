package com.ergomotions.network

import com.google.gson.annotations.SerializedName

data class EmployeeResponse(@SerializedName("status") var status: String,
                            @SerializedName("error") var error: String)