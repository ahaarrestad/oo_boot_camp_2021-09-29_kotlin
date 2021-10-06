/*
 * Copyright (c) 2021 by Fred George
 * May be used freely except for training; license required for training.
 * @author Fred George  fredgeorge@acm.org
 */

package com.nrkei.training.oo.graph

import com.nrkei.training.oo.graph.Link.Companion.FEWEST_HOPS
import com.nrkei.training.oo.graph.Link.Companion.LEAST_COST

class Node {
    private val links = mutableListOf<Link>()

    companion object {
        private const val UNREACHABLE = Double.POSITIVE_INFINITY
    }

    infix fun canReach(destination: Node) = cost(destination, noVisitedNodes, LEAST_COST) != UNREACHABLE

    infix fun hopCount(destination: Node) = cost(destination, FEWEST_HOPS).toInt()

    infix fun cost(destination: Node) = cost(destination, LEAST_COST)

    infix fun path(destination: Node) = path(destination, noVisitedNodes)
        ?: throw IllegalArgumentException("Destination is unreachable")

    @Suppress("ComplexMethod")
    internal fun path(destination: Node, visitedNodes: List<Node>): Path? {
        if (this == destination) return Path()
        if (this in visitedNodes) return null
        return links
            .map { it.path(destination, visitedNodes + this) }
            .minByOrNull{ it?.cost() ?: Double.POSITIVE_INFINITY }
    }

    private fun cost(destination: Node, strategy: CostStrategy /* = (kotlin.Double) -> kotlin.Double */) =
        cost(destination, noVisitedNodes, strategy)
            .also { result -> require(result != UNREACHABLE) { "Destination is unreachable" } }

    @Suppress("ComplexMethod")
    internal fun cost(destination: Node, visitedNodes: List<Node>, strategy: CostStrategy): Double {
        if (this == destination) return 0.0
        if (this in visitedNodes || links.isEmpty()) return UNREACHABLE
        return links.minOf { it.cost(destination, visitedNodes + this, strategy) }
    }

    private val noVisitedNodes = emptyList<Node>()

    infix fun cost(amount: Number) = LinkBuilder(amount.toDouble(), links)

    class LinkBuilder internal constructor(private val cost: Double, private val links: MutableList<Link>) {
        infix fun to(neighbor: Node) = neighbor.also { links.add(Link(neighbor, cost)) }
    }
}
