package com.oz.meow.mapper.system

import com.oz.meow.domain.PageInfo
import com.oz.meow.domain.system.User
import com.oz.meow.enums.UserStatus
import org.beetl.sql.core.page.PageResult
import org.beetl.sql.mapper.BaseMapper
import org.beetl.sql.mapper.annotation.Param
import org.beetl.sql.mapper.annotation.SpringData
import org.beetl.sql.mapper.annotation.SqlResource
import org.springframework.stereotype.Repository

@Repository
@SqlResource("system/user")
interface UserMapper: BaseMapper<User> {
    @SpringData
    fun findByUsername(username: String): User
    fun page(page: PageInfo<User>, @Param("status") status: String): PageResult<User>
}