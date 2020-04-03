package com.codebrewlabs.base_application.utils

import android.app.Activity
import android.app.DatePickerDialog
import android.text.format.DateUtils
import java.text.SimpleDateFormat
import java.util.*


object DateUtils {

    val utcFormat = SimpleDateFormat(DateFormat.UTC_FORMAT, Locale.getDefault())

    fun openDatePicker(activity: Activity, listener: OnDateSelected) {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        val dpd = DatePickerDialog(activity,
            DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                var selectedDate = "$dayOfMonth/${monthOfYear.plus(1)}/$year"

                selectedDate =
                    dateFormatChange(DateFormat.DATE_FORMAT_SLASH_YEAR, DateFormat.DATE_FORMAT_SLASH, selectedDate)
                listener.onDateSelected(selectedDate)

            }, year, month, day
        )

        dpd.datePicker.maxDate = System.currentTimeMillis() - 36000
        dpd.show()
    }


    fun dateFormatFromMillis(format: String, timeInMillis: Long?): String {
        val fmt = SimpleDateFormat(format, Locale.ENGLISH)
        return if (timeInMillis == null || timeInMillis == 0L)
            ""
        else
            fmt.format(timeInMillis)
    }


    fun dateFormatChange(formatFrom: String, formatTo: String, value: String): String {
        val originalFormat = SimpleDateFormat(formatFrom, Locale.ENGLISH)
        val targetFormat = SimpleDateFormat(formatTo, Locale.ENGLISH)
        val date = originalFormat.parse(value)
        val formattedDate = targetFormat.format(date)
        return formattedDate
    }


    fun getTimeAgo(createdAt: String?, removeAgo: String): String {
        val agoString: String

        if (createdAt == null) {
            return ""
        }

        utcFormat.timeZone = TimeZone.getTimeZone("Etc/UTC")
        val time = utcFormat.parse(createdAt).time
        val now = System.currentTimeMillis()

        val ago = DateUtils.getRelativeTimeSpanString(
            time, now, DateUtils.SECOND_IN_MILLIS, DateUtils.FORMAT_ABBREV_RELATIVE
        )


        agoString = ago.toString().removeSuffix(removeAgo)

        return agoString
    }

    fun getTimeAgoForMillis(millis: Long): String {

        val now = System.currentTimeMillis()

        return DateUtils.getRelativeTimeSpanString(
            millis, now, DateUtils.SECOND_IN_MILLIS,
            DateUtils.FORMAT_ABBREV_RELATIVE
        ).toString()
    }

    fun getLocalTimeAgo(timeString: Long?, removeAgo: String): String {
        var agoString = ""

        timeString?.let {
            val now = System.currentTimeMillis()

            val ago = DateUtils.getRelativeTimeSpanString(
                timeString,
                now,
                DateUtils.SECOND_IN_MILLIS,
                DateUtils.FORMAT_SHOW_TIME
            )

            agoString = ago.toString()
        }

        return agoString
    }

    fun dateTimeFormatFromUTC(createdDate: String?): String {
        return if (createdDate == null || createdDate.isEmpty())
            ""
        else {
            utcFormat.timeZone = TimeZone.getTimeZone("Etc/UTC")

            val fmt = SimpleDateFormat(DateFormat.DATE_TIME_FORMAT, Locale.getDefault())
            fmt.format(utcFormat.parse(createdDate))
        }
    }
}

/*On Date selected listener*/
interface OnDateSelected {
    fun onDateSelected(date: String)
}

object DateFormat {
    const val DATE_FORMAT = "yyyy-MM-dd"
    const val DATE_TIME_FORMAT = "dd MMM yyyy · hh:mm a"
    const val TIME_FORMAT = "hh:mm a"
    const val MON_YEAR_FORMAT = "dd MMM yy"
    const val MON_DAY_YEAR = "MMM dd, yyyy"
    const val MON_DATE = "MMM dd"
    const val DATE_FORMAT_SLASH = "MM/dd/yy"
    const val DATE_FORMAT_SLASH_YEAR = "dd/MM/yyyy"
    const val DATE_FORMAT_RENEW = "yyyy-MM-dd hh:mm"
    const val UTC_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
    const val MONTH_FORMAT = "MMM"
}
