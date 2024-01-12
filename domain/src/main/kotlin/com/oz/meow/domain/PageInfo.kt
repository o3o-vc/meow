package com.oz.meow.domain

import org.beetl.sql.core.page.PageRequest
import org.beetl.sql.core.page.PageResult

class PageInfo<T>(
    private var pageNumber: Long,
    private var pageSize: Int,
    private var totalRequired: Boolean = true,
    private var listRequired: Boolean = true,
    private var orderBy: String? = null,
    private var records: MutableList<T>? = null,
    private var pageCount: Long = 0,
    private var itemCount: Long = 0
) : PageRequest<T>, PageResult<T> {
    //pageRequest
    override fun getPageNumber(): Long = pageNumber

    override fun getPageSize(): Int = pageSize

    override fun getOrderBy(): String? = orderBy

    override fun isTotalRequired(): Boolean = totalRequired

    override fun isListRequired(): Boolean = listRequired

    override fun of(result: MutableList<T>?, total: Long): PageResult<T> {
        return PageInfo(
            pageNumber = pageNumber,
            pageSize = pageSize,
            itemCount = total,
            records = result
        ).calcTotalPage()
    }

    override fun of(result: MutableList<T>?): PageResult<T> {
        return of(result, 0)
    }
    // pageResult
    override fun getTotalRow(): Long = itemCount

    override fun getList(): MutableList<T>? = records

    override fun getTotalPage(): Long = pageCount

    override fun setList(list: MutableList<T>?) {
        records = list
    }

    private fun calcTotalPage(): PageInfo<T> {
        if (this.itemCount == 0L) {
            this.pageCount = 1L
        } else if (itemCount % this.pageSize == 0L) {
            this.pageCount = itemCount / this.pageSize
        } else {
            this.pageCount = itemCount / this.pageSize + 1L
        }
        return this
    }
}
