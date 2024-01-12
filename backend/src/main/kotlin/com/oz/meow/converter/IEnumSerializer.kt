package com.oz.meow.converter

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import com.oz.meow.annotation.IEnum

class IEnumSerializer: JsonSerializer<IEnum<*>>() {
    override fun serialize(en: IEnum<*>, jg: JsonGenerator?, sp: SerializerProvider?) {
        jg?.writeStartObject()
        val valueField = "value"
        when (en.value) {
            is Int -> jg?.writeNumberField(valueField, en.value as Int)
            is Double -> jg?.writeNumberField(valueField, en.value as Double)
            else -> jg?.writeStringField(valueField, en.value.toString())
        }
        jg?.writeStringField("label", en.label)
        jg?.writeEndObject()
    }
}