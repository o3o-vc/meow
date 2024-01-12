package com.oz.meow.config

import com.beetl.sql.pref.PerformanceConfig
import org.beetl.sql.core.Interceptor
import org.beetl.sql.starter.SQLManagerCustomize
import org.springframework.context.annotation.Configuration

@Configuration
class BeetlsqlConfig {

    fun mysqlManagerCustomize(): SQLManagerCustomize {
        return SQLManagerCustomize { _, manager ->
            var interceptors = mutableListOf<Interceptor>()
            manager.inters = interceptors.toTypedArray()
            PerformanceConfig().config(manager)
        }
    }
}