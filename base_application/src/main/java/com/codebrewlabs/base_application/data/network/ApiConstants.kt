package com.codebrewlabs.base_application.data.network

const val PER_PAGE_LOAD = 50


object ApiKeys {
    const val LAST_ITEM_ID = "lastId"
}

object LoadingStatus {
    const val ITEM = 0
    const val LOADING = 1
}


object MimeType {
    const val IMAGE = "image/*"
    const val VIDEO = "video/*"
    const val AUDIO = "audio/*"
    const val DOCUMENT = "multipart/form-data"
}

object PushType {
    const val CREATE_APPOINTMENT = "CREATE_APPOINTMENT"
    const val UPCOMING_APPOINTMENT = "UPCOMING_APPOINTMENT"
    const val APPOINTMENT_CONFIRMATION = "APPOINTMENT_CONFIRMATION"
    const val UPDATE_APPOINTMENT = "UPDATE_APPOINTMENT"
    const val CANCEL_APPOINTMENT = "CANCEL_APPOINTMENT"

    const val CREATE_POST = "CREATE_POST"
    const val POST_COMMENT = "POST_COMMENT"
    const val FOLLOW_USER = "FOLLOW_USER"

    const val CREATE_PHARMACY_REQUEST = "CREATE_PHARMACY_REQUEST"
    const val PHARMACY_ACTIONS = "PHARMACY_ACTIONS"

    const val HELP = "HELP"
    const val ADD_FEEDBACK = "ADD_FEEDBACK"

    const val USER_LIKE = "USER_LIKE"
    const val POST_LIKE = "POST_LIKE"
    const val COMMENT_LIKE = "COMMENT_LIKE"
    const val USER_CHAMPION = "USER_CHAMPION"
    const val NOT_USER_CHAMPION = "NOT_USER_CHAMPION"

    const val CREATE_TASK = "CREATE_TASK"
    const val COMPLETE_TASK = "COMPLETE_TASK"
    const val REJECT_TASK = "REJECT_TASK"
    const val ACCEPT_TASK = "ACCEPT_TASK"

    const val HIRE_PROFESSIONAL = "HIRE_PROFESSIONAL"
    const val CONTRACT_SIGNED = "CONTRACT_SIGNED"
    const val EDIT_CONTRACT = "EDIT_CONTRACT"
    const val REJECT_CONTRACT = "REJECT_CONTRACT"
    const val JOIN_FACILITY = "JOIN_FACILITY"

    const val CREATE_REPORT = "CREATE_REPORT"
    const val CREATE_LAB_REPORT = "CREATE_LAB_REPORT"
}