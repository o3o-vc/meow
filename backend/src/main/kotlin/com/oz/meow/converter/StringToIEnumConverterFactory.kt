package com.oz.meow.converter

import com.oz.meow.annotation.IEnum
import org.springframework.core.convert.converter.Converter
import org.springframework.core.convert.converter.ConverterFactory

class StringToIEnumConverterFactory: ConverterFactory<String, Enum<*>> {
    override fun <T : Enum<*>> getConverter(targetType: Class<T>): Converter<String, T> {
        return StringToEnum(targetType)
    }

    data class StringToEnum<T: Enum<*>>(val enumType: Class<T>): Converter<String, T> {
        private fun typeOf(source: Class<*>, target: Class<*>): Boolean {
            return source.interfaces.contains(target)
        }
        override fun convert(source: String): T? {
            if (typeOf(enumType, IEnum::class.java)) {
                return enumType.enumConstants.findLast { (it as IEnum<*>).value == source }
            }
            return enumType.enumConstants.findLast { it.name == source }
        }

    }
}
