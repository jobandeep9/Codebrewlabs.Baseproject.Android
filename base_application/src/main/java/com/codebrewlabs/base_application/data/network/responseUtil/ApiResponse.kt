package com.codebrewlabs.base_application.data.network.responseUtil

data class ApiResponse<out T>(
        val message: String? = null,
        val data: T? = null
)