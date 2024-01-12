package com.oz.meow.converter

import com.oz.meow.annotation.IEnum
import org.springframework.core.convert.converter.Converter
import org.springframework.core.convert.converter.ConverterFactory

class IntegerToIEnumConverterFactory: ConverterFactory<Int, Enum<*>> {
    override fun <T : Enum<*>> getConverter(targetType: Class<T>): Converter<Int, T> {
        return IntToEnum(targetType)
    }
    data class IntToEnum<T: Enum<*>>(val enumType: Class<T>): Converter<Int, T> {
        private fun typeOf(source: Class<*>, target: Class<*>): Boolean {
            return source.interfaces.contains(target)
        }
        override fun convert(source: Int): T? {
            if (typeOf(enumType, IEnum::class.java)) {
                return enumType.enumConstants.findLast { (it as IEnum<*>).value == source }
            }
            return enumType.enumConstants[source]
        }

    }
}