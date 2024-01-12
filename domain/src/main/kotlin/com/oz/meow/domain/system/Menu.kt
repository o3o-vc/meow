package com.oz.meow.domain.system

import com.oz.meow.domain.Tree

data class Menu(
    var title: String
) : Tree<Long>()
