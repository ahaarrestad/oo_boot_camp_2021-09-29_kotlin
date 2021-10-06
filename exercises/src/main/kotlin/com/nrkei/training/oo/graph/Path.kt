/*
 * Copyright (c) 2021 by Fred George
 * May be used freely except for training; license required for training.
 * @author Fred George  fredgeorge@acm.org
 */

package com.nrkei.training.oo.graph

import com.nrkei.training.oo.graph.Link.Companion.cost

class Path internal constructor() {
    private val links = mutableListOf<Link>()

    internal infix fun prepend(link: Link) = links.add(link)

    fun cost() = links.cost()

    fun hopCount() = links.size
}
