package com.oz.meow.convert

import org.beetl.sql.annotation.builder.AttributeConvert
import org.beetl.sql.clazz.kit.BeanKit
import org.beetl.sql.core.ExecuteContext

class MetaConvert: AttributeConvert {
    override fun toDb(ctx: ExecuteContext?, cls: Class<*>?, name: String?, pojo: Any?): Any {
        BeanKit.setBeanProperty(pojo, ctx?.getContextPara(name), name)
        if (ctx != null) {
            return ctx.getContextPara(name)
        }
        return ""
    }
}