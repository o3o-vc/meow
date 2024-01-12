package com.oz.meow.converter

import com.oz.meow.util.DatePatten
import org.springframework.core.convert.converter.Converter
import java.time.LocalDateTime

class LocalDateTimeConverter: Converter<String, LocalDateTime> {
    override fun convert(source: String): LocalDateTime? {
        var current: LocalDateTime? = null
        for (df in DatePatten.DATE_FORMATTERS) {
            try {
                current = LocalDateTime.parse(source, df)
            } catch (ignore: Exception) {
                continue
            }
        }
        return current
    }
}