/*
 * Copyright (c) 2021 by Fred George
 * May be used freely except for training; license required for training.
 * @author Fred George  fredgeorge@acm.org
 */

package com.nrkei.training.oo.graph

class Node {
    private val links = mutableListOf<Link>()

    infix fun canReach(destination: Node) = paths(destination).isNotEmpty()

    infix fun hopCount(destination: Node) = path(destination, Path::hopCount).hopCount()

    infix fun cost(destination: Node) = path(destination).cost()

    infix fun path(destination: Node) = path(destination, Path::cost)

    infix fun paths(destination: Node) = paths(destination, noVisitedNodes)

    @Suppress("ComplexMethod")
    internal fun paths(destination: Node, visitedNodes: List<Node>): List<Path> {
        if (this == destination) return listOf(Path())
        if (this in visitedNodes) return emptyList()
        return links.flatMap { it.paths(destination, visitedNodes + this) }
    }

    private fun path(destination: Node, strategy: PathStrategy) = paths(destination)
        .minByOrNull { strategy(it).toDouble() }
        ?: throw IllegalArgumentException("Destination is unreachable")

    private val noVisitedNodes = emptyList<Node>()

    infix fun cost(amount: Number) = LinkBuilder(amount.toDouble(), links)

    class LinkBuilder internal constructor(private val cost: Double, private val links: MutableList<Link>) {
        infix fun to(neighbor: Node) = neighbor.also { links.add(Link(neighbor, cost)) }
    }
}
