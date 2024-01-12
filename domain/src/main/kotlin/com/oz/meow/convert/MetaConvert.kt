package com.oz.meow.convert

import org.beetl.sql.annotation.builder.AttributeConvert
import org.beetl.sql.clazz.SQLType
import org.beetl.sql.clazz.kit.BeanKit
import org.beetl.sql.core.ExecuteContext

class MetaConvert: AttributeConvert {
    private val createFields = arrayOf("creator", "created", "creatorName")
    private val updateFields = arrayOf("modifier", "modified", "modifierName")
    override fun toDb(ctx: ExecuteContext?, cls: Class<*>?, name: String?, pojo: Any?): Any? {
        val beanProperty = BeanKit.getBeanProperty(pojo, name)
        if (beanProperty != null) {
            return beanProperty
        }
        val sqlType = ctx?.sqlSource?.sqlType
        val value = ctx?.getContextPara(name)
        if (sqlType == SQLType.INSERT && createFields.contains(name)) {
            BeanKit.setBeanProperty(pojo, value, name)
            return value
        }
        if (sqlType == SQLType.UPDATE && updateFields.contains(name)) {
            BeanKit.setBeanProperty(pojo, value, name)
            return value
        }
        return null
    }
}