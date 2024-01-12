package com.oz.meow.enums

import org.beetl.sql.annotation.entity.EnumValue


enum class Enable(@get:EnumValue val code: Int, value: String) {
    YES(1, "是"), NO(0, "否"), 你还没(3, "s")
}