package com.oz.meow.config

import org.springframework.core.MethodParameter
import org.springframework.http.MediaType
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.server.ServerHttpRequest
import org.springframework.http.server.ServerHttpResponse
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice
import com.oz.meow.model.Result
import org.springframework.web.bind.annotation.ExceptionHandler

@RestControllerAdvice(basePackages = ["com.oz.meow.controller"])
class ResponseAdvice: ResponseBodyAdvice<Any> {
    override fun supports(returnType: MethodParameter, converterType: Class<out HttpMessageConverter<*>>): Boolean {
        return true
    }

    override fun beforeBodyWrite(
        body: Any?,
        returnType: MethodParameter,
        selectedContentType: MediaType,
        selectedConverterType: Class<out HttpMessageConverter<*>>,
        request: ServerHttpRequest,
        response: ServerHttpResponse
    ): Any? {
        if (body is Result<*>) {
            return body
        }
        return Result.ok(body)
    }

    @ExceptionHandler(Exception::class)
    fun handleException(e: Exception): Result<*> {
        e.printStackTrace()
        return Result.error(e.message!!)
    }
}