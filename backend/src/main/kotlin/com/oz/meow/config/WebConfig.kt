package com.oz.meow.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer
import com.oz.meow.annotation.IEnum
import com.oz.meow.converter.*
import com.oz.meow.util.DatePatten
import org.springframework.context.annotation.Configuration
import org.springframework.format.FormatterRegistry
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
@EnableWebMvc
//@EnableAspectJAutoProxy
class WebConfig: WebMvcConfigurer {
    override fun addFormatters(registry: FormatterRegistry) {
        super.addFormatters(registry)
        registry.apply {
            removeConvertible(String::class.java, Enum::class.java)
            removeConvertible(Int::class.java, Enum::class.java)
            addConverterFactory(StringToIEnumConverterFactory())
            addConverterFactory(IntegerToIEnumConverterFactory())
            addConverter(LocalDateTimeConverter())
            addConverter(LocalDateConverter())
        }
    }

    override fun configureMessageConverters(converters: MutableList<HttpMessageConverter<*>>) {
        super.configureMessageConverters(converters)
        converters.add(0, MappingJackson2HttpMessageConverter().apply {
            objectMapper = ObjectMapper().apply {
                registerModule(SimpleModule().apply {
                    addSerializer(Long::class.java, ToStringSerializer.instance)
                    addSerializer(IEnum::class.java, IEnumSerializer())
                    addSerializer(LocalDateTimeSerializer(DatePatten.DATE_TIME_FORMATTER))
                    addSerializer(LocalDateSerializer(DatePatten.DATE_FORMATTER))
                    addSerializer(LocalTimeSerializer(DatePatten.TIME_FORMATTER))
                })
            }
        })
    }
}