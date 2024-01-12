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
        val menu = Menu("ye")
        menu.id = 1
        menu.parentId = 0
        val menu1 = Menu("ha")
        menu1.id = 2
        menu1.parentId = 1
        val subs = mutableListOf<Menu>()
        menu.children = subs
        subs.add(menu1)
        val om: ObjectMapper = ObjectMapper()
        println(om.writeValueAsString(menu))
        val list = mutableListOf(menu, menu1)
        println(om.writeValueAsString(Tree.trees(list) {
            if (it is Menu) {
                Cmd(it.title).apply {
                    id = it.id.toString()
                }
            }
            it
        }))
        var page = userMapper.page(PageInfo(1, 2), "2")
        return userService.page(PageInfo(2, 2), User(status = UserStatus.ENABLE))
    }
}
