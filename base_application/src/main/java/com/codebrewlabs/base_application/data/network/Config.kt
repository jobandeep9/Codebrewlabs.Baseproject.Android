package com.codebrewlabs.base_application.data.network

object Config {

    var BASE_URL = ""
    var BASE_URL_DEV = "https://dev-api.rooh.live/"
    var BASE_URL_TEST = "https://test-api.rooh.live/"
    var BASE_URL_CLIENT = "https://demo-api.rooh.live/"
    var BASE_URL_LIVE = "https://liveapp-api.rooh.live/"
    var BASE_URL_LOCAL = "http://192.168.100.84:8002/"

    var SITE_URL = ""

    private val appMode = AppMode.LOCAL

    val baseURL: String
        get() {
            init(appMode)
            return BASE_URL
        }

    val siteURL: String
        get() {
            init(appMode)
            return SITE_URL
        }

    private fun init(appMode: AppMode) {

        when (appMode) {
            AppMode.LOCAL -> {
                BASE_URL = BASE_URL_LOCAL
            }
            AppMode.DEV -> {
                BASE_URL = BASE_URL_DEV
            }
            AppMode.TEST -> {
                BASE_URL = BASE_URL_TEST
            }
            AppMode.CLIENT -> {
                BASE_URL = BASE_URL_CLIENT
            }
            AppMode.LIVE -> {
                BASE_URL = BASE_URL_LIVE
            }
        }
    }

    private enum class AppMode {
        LOCAL, DEV, TEST, CLIENT, LIVE
    }
}