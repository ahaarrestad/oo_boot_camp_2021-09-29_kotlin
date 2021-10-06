/*
 * Copyright (c) 2021 by Fred George
 * May be used freely except for training; license required for training.
 * @author Fred George  fredgeorge@acm.org
 */

package com.nrkei.training.oo.graph

internal class Link internal constructor(private val target: Node, private val cost: Double) {
    companion object {
        internal val LEAST_COST = { cost: Double -> cost }
        internal val FEWEST_HOPS = { _: Double -> 1.0 }

        internal fun Collection<Link>.cost() = this.sumOf { it.cost }
    }

    internal fun cost(destination: Node, visitedNodes: List<Node>, strategy: CostStrategy): Double {
        return target.cost(destination, visitedNodes, strategy) + strategy(cost)
    }

    internal fun path(destination: Node, visitedNodes: List<Node>): Path? {
        return target.path(destination, visitedNodes)?.also { it prepend this }
    }
}

internal typealias CostStrategy = (Double) -> Double
