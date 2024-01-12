package com.oz.meow.domain.system

import com.oz.meow.domain.Base
import com.oz.meow.enums.UserStatus
import org.beetl.sql.annotation.entity.Table

@Table(name = "user")
data class User(
    var name: String? = null,
    var username: String? = null,
    var password: String? = null,
    var status: UserStatus? = UserStatus.ENABLE,
    var age: Int? = null,
    var gender: String? = null,
    var phone: String? = null,
    var email: String? = null
) : Base<Long>()
