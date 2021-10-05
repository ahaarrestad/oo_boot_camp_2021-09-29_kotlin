/*
 * Copyright (c) 2021 by Fred George
 * May be used freely except for training; license required for training.
 * @author Fred George  fredgeorge@acm.org
 */

package com.nrkei.training.oo.graph

// Understands its neighbors
class Node {
    private val neighbors = mutableListOf<Node>()

    companion object {
        private const val UNREACHABLE = -1
    }

    infix fun to(neighbor: Node) = neighbor.also { neighbors.add(neighbor) }

    infix fun canReach(destination: Node) = hopCount(destination, noVisitedNodes) != UNREACHABLE

    infix fun hopCount(destination: Node) = hopCount(destination, noVisitedNodes).also {
        require(it != UNREACHABLE) { "Destination is unreachable" }
    }

    private fun hopCount(destination: Node, visitedNodes: MutableList<Node>): Int {
        if (this == destination) return 0
        if (this in visitedNodes) return UNREACHABLE
        visitedNodes.add(this)
        neighbors.forEach {
            it.hopCount(destination, visitedNodes).also { if (it != UNREACHABLE) return it + 1 }
        }
        return UNREACHABLE
    }

    private val noVisitedNodes get() = mutableListOf<Node>()
}