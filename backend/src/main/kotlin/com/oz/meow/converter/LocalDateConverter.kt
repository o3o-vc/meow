package com.oz.meow.converter

import com.oz.meow.util.DatePatten
import org.springframework.core.convert.converter.Converter
import java.time.LocalDate

class LocalDateConverter: Converter<String, LocalDate> {
    override fun convert(source: String): LocalDate? {
        return LocalDate.parse(source, DatePatten.DATE_FORMATTER)
    }
}