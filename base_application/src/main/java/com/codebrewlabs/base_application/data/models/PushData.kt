package com.codebrewlabs.base_application.data.models

import java.io.Serializable

data class PushData(val msg: String, var title: String, val sound: String) : Serializable