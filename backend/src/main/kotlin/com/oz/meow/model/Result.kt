package com.oz.meow.model


data class Result<T>(
    var code: Int,
    var message: String,
    var data: T?
) {
    companion object {
        val OK: Int = 200
        val BIZ_SUCCESS = 219
        val BIZ_INFO = 220
        val BIZ_WARN = 221
        val BIZ_ERROR = 222
        val SYS_UNAUTHORIZED = 401
        val SYS_FORBIDDEN = 403

        fun <T> get(code: Int, message: String, data: T): Result<T> = Result(code, message, data)

        fun <T> ok(data: T): Result<T> = get(OK, "ok", data)

        fun <T> error(message: String, data: T): Result<T> = get(BIZ_ERROR, message, data)

        fun error(message: String): Result<Unit> = error(message, Unit)

        fun info(message: String): Result<Unit> = get(BIZ_INFO, message, Unit)

        fun warn(message: String): Result<Unit> = get(BIZ_WARN, message, Unit)
    }

}
