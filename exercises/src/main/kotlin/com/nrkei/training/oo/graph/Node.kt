/*
 * Copyright (c) 2021 by Fred George
 * May be used freely except for training; license required for training.
 * @author Fred George  fredgeorge@acm.org
 */

package com.nrkei.training.oo.graph

import org.jetbrains.annotations.NotNull

// Understands its neighbors
class Node {
    private val neighbors = mutableListOf<Node>()

    companion object {
        private const val UNREACHABLE = Double.POSITIVE_INFINITY
    }

    infix fun to(neighbor: Node) = neighbor.also { neighbors.add(neighbor) }

    infix fun canReach(destination: Node) = hopCount(destination, noVisitedNodes) != UNREACHABLE

    infix fun hopCount(destination: Node) = hopCount(destination, noVisitedNodes).also {
        require(it != UNREACHABLE) { "Destination is unreachable" }
    }.toInt()

    private fun hopCount(destination: Node, visitedNodes: List<Node>): Double {
        if (this == destination) return 0.0
        if (this in visitedNodes) return UNREACHABLE
        return neighbors.minOfOrNull { it.hopCount(destination, visitedNodes + this) + 1 } ?: UNREACHABLE
    }

    private val noVisitedNodes = emptyList<Node>()
}