package com.oz.meow.annotation

import com.oz.meow.convert.MetaConvert
import org.beetl.sql.annotation.builder.Builder

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FIELD)
@Builder(MetaConvert::class)
annotation class Modify()
