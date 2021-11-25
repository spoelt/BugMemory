package com.example.memory.utils

import com.example.memory.constants.COLON
import org.joda.time.Period
import org.joda.time.format.PeriodFormatter
import org.joda.time.format.PeriodFormatterBuilder

fun convertTimestampToString(elapsedTime: Long): String =
    getPeriodFormatter().print(Period(elapsedTime))

fun getPeriodFormatter(): PeriodFormatter = PeriodFormatterBuilder()
    .printZeroAlways()
    .minimumPrintedDigits(2)
    .appendHours()
    .appendSeparator(COLON)
    .printZeroAlways()
    .minimumPrintedDigits(2)
    .appendMinutes()
    .appendSeparator(COLON)
    .printZeroAlways()
    .minimumPrintedDigits(2)
    .appendSeconds()
    .toFormatter()