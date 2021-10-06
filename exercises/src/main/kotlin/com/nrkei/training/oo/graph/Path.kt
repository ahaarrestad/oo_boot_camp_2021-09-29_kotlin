/*
 * Copyright (c) 2021 by Fred George
 * May be used freely except for training; license required for training.
 * @author Fred George  fredgeorge@acm.org
 */

package com.nrkei.training.oo.graph

import com.nrkei.training.oo.graph.Link.Companion.cost

abstract class Path internal constructor() {
    internal open infix fun prepend(link: Link) { } // By default, ignore

    abstract fun cost(): Double

    abstract fun hopCount(): Int

    internal class ActualPath internal constructor() : Path() {
        private val links = mutableListOf<Link>()

        override infix fun prepend(link: Link) { links.add(link) }

        override fun cost() = links.cost()

        override fun hopCount() = links.size
    }

    internal object NONE: Path() {
        override fun cost() = Double.POSITIVE_INFINITY
        override fun hopCount() = Int.MAX_VALUE
    }
}
