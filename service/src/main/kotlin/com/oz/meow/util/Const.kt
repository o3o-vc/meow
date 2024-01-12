package com.oz.meow.util

import java.time.format.DateTimeFormatter

object DatePatten {
    const val DATE_FORMAT: String = "yyyy-MM-dd"
    const val DATE_TIME_FORMAT: String = "yyyy-MM-dd HH:mm:ss"

    const val NUMBER_DATE_FORMAT: String = "yyyyMMdd"
    const val NUMBER_DATE_TIME_FORMAT: String = "yyyyMMddHHmmss"

    const val MONTH_FORMAT = "yyyy-MM"
    const val TIME_FORMAT = "HH:mm:ss"
    const val MINUTE_FORMAT = "yyyy-MM-dd HH:mm"
    val DATE_FORMATS = listOf(DATE_TIME_FORMAT, DATE_FORMAT, MINUTE_FORMAT, TIME_FORMAT)

    val DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_FORMAT)
    val DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);
    val MINUTE_FORMATTER = DateTimeFormatter.ofPattern(MINUTE_FORMAT)
    val TIME_FORMATTER = DateTimeFormatter.ofPattern(TIME_FORMAT)

    val DATE_FORMATTERS = listOf(DATE_TIME_FORMATTER, DATE_FORMATTER, MINUTE_FORMATTER, TIME_FORMATTER)
}