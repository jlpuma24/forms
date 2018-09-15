package com.ergomotions.network

import com.ergomotions.viewModels.GeneralViewModel.GeneralFormData
import com.google.gson.annotations.SerializedName

data class EmployeeRequestWrapper(
        @SerializedName("employee") val employee: EmployeeRequest,
        @SerializedName("employeeForms") val employeeForms: List<GeneralFormData>
)