package com.oz.meow.domain

import org.beetl.sql.annotation.entity.InsertIgnore
import org.beetl.sql.annotation.entity.UpdateIgnore
import java.io.Serializable

open class Tree<T : Serializable> : Base<T>() {
    var parentId: T? = null
    @InsertIgnore
    @UpdateIgnore
    var children: MutableList<out Tree<T>>? = null
    companion object {
        fun <T: Serializable> trees(list: MutableList<Tree<T>>): MutableList<Tree<T>>? {
            return trees(list) { it }
        }
        fun <T: Serializable, R: Serializable> trees(list: MutableList<out Tree<T>>, transform: (Tree<T>) -> Tree<R>): MutableList<Tree<R>>? {
            var result: MutableList<Tree<R>>? = null
            val uniqueMap = list.map(transform).associateBy {
                it.id
            }
            val groupMap = uniqueMap.values.groupBy { it.parentId }
            groupMap.entries.forEach {
                val get = uniqueMap[it.key]
                if (get == null) {
                    result = groupMap[it.key]?.toMutableList()
                } else {
                    get.children = groupMap[it.key]?.toMutableList()
                }
            }
            return result
        }
    }
}
