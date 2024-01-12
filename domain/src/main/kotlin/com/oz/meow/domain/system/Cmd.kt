package com.oz.meow.domain.system

import com.oz.meow.domain.Tree

data class Cmd(
    var name: String
) : Tree<String>()
