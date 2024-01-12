package com.oz.meow.domain

import com.oz.meow.annotation.Create
import com.oz.meow.annotation.Modify
import org.beetl.sql.annotation.entity.AutoID
import org.beetl.sql.annotation.entity.InsertIgnore
import org.beetl.sql.annotation.entity.UpdateIgnore
import java.io.Serializable
import java.time.LocalDateTime

abstract class Base<T: Serializable> {
    @AutoID
    var id: T? = null

    @Create
    @UpdateIgnore
    var creator: Long? = null

    @Create
    @UpdateIgnore
    var creatorName: String? = null

    @Create
    @UpdateIgnore
    var created: LocalDateTime? = null

    @Modify
    @InsertIgnore
    var modifier: Long? = null

    @Modify
    @InsertIgnore
    var modifierName: String? = null

    @Modify
    @InsertIgnore
    var modified: LocalDateTime? = null
}