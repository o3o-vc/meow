package com.oz.meow.config

import org.beetl.sql.core.ExecuteContext
import org.beetl.sql.core.SQLExecutor
import org.beetl.sql.core.db.MySqlStyle

class MysqlStyle: MySqlStyle() {
    override fun buildExecutor(executeContext: ExecuteContext?): SQLExecutor {
        val sqlType = executeContext?.sqlSource?.sqlType
        return super.buildExecutor(executeContext)
    }
}