package com.oz.meow.config

import org.beetl.sql.clazz.SQLType
import org.beetl.sql.core.ExecuteContext
import org.beetl.sql.core.SQLExecutor
import org.beetl.sql.core.db.MySqlStyle
import java.time.LocalDateTime

class MysqlStyle: MySqlStyle() {
    override fun buildExecutor(executeContext: ExecuteContext?): SQLExecutor {
        val sqlType = executeContext?.sqlSource?.sqlType
        when (sqlType) {
            SQLType.INSERT  -> {
                executeContext.apply {
                    setContextPara("created", LocalDateTime.now())
                    setContextPara("creator", 0L)
                    setContextPara("creatorName", "admin")
                }
            }
            SQLType.UPDATE -> {
                executeContext.apply {
                    setContextPara("modified", LocalDateTime.now())
                    setContextPara("modifier", 0L)
                    setContextPara("modifierName", "admin")
                }
            }
            SQLType.UNKNOWN -> {}
            else -> {}
        }
        return super.buildExecutor(executeContext)
    }
}