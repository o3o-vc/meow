package com.oz.meow.service.system

import com.oz.meow.domain.PageInfo
import com.oz.meow.domain.system.User
import com.oz.meow.mapper.system.UserMapper
import org.beetl.sql.core.page.PageResult
import org.beetl.sql.core.query.Query
import org.springframework.stereotype.Service

@Service
class UserService(private val userMapper: UserMapper) {

    fun get(id: Long): User = userMapper.single(id)

    fun page(page: PageInfo<User>, user: User): PageResult<User> {
        return userMapper.createLambdaQuery()
            .andEq(User::username, Query.filterEmpty(user.username))
            .page(page)
    }
}