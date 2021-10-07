/*
 * Copyright (c) 2021 by Fred George
 * May be used freely except for training; license required for training.
 * @author Fred George  fredgeorge@acm.org
 */

package com.nrkei.training.oo.graph

internal class Link internal constructor(private val target: Node, private val cost: Double) {
    companion object {
        internal fun Collection<Link>.cost() = this.sumOf { it.cost }
    }

    internal fun paths(destination: Node, visitedNodes: List<Node>) =
        target.paths(destination, visitedNodes).onEach { it prepend this }
}
