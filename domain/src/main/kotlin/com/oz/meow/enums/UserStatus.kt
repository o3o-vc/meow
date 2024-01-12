package com.oz.meow.enums

import com.oz.meow.annotation.IEnum
import org.beetl.sql.annotation.entity.EnumValue

enum class UserStatus(@EnumValue override val value: String, override val label: String): IEnum<String>{
    ENABLE("1", "启用"), LOCKED("2", "锁定")

}