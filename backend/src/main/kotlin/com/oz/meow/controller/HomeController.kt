package com.oz.meow.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.oz.meow.domain.PageInfo
import com.oz.meow.domain.Tree
import com.oz.meow.domain.system.Cmd
import com.oz.meow.domain.system.Menu
import com.oz.meow.domain.system.User
import com.oz.meow.enums.Enable
import com.oz.meow.enums.UserStatus
import com.oz.meow.mapper.system.UserMapper
import com.oz.meow.service.system.UserService
import org.beetl.sql.core.page.PageResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HomeController(val userService: UserService, val userMapper: UserMapper) {
    @GetMapping("sayHi")
    fun sayHi(): PageResult<User> {
        val user = User().apply {
            name = "meow"
            username = "meow"
            age = 20
        }
        userMapper.insert(user)
        println(user)
        var page = userMapper.page(PageInfo(1, 2), "2")
        return userService.page(PageInfo(2, 2), User(status = UserStatus.ENABLE))
    }
}
