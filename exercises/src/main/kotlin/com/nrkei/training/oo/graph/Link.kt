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

    internal fun path(destination: Node, visitedNodes: List<Node>, strategy: PathStrategy) =
        target.path(destination, visitedNodes, strategy).also { it prepend this }
}
