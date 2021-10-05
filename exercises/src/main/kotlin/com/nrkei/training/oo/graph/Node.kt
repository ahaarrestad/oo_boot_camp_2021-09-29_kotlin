package com.nrkei.training.oo.graph

import java.awt.image.MultiPixelPackedSampleModel

// Understands its neighbors
class Node {
    private val neighbors = mutableListOf<Node>()

    companion object {
        private const val UNREACHABLE = -1
    }

    infix fun to(neighbor: Node) = neighbor.also { neighbors.add(neighbor) }

    infix fun canReach(destination: Node) = canReach(destination, noVisitedNodes)

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

    private fun canReach(destination: Node, visitedNodes: MutableList<Node>): Boolean {
        if (this == destination) return true
        if (this in visitedNodes) return false
        visitedNodes.add(this)
        return neighbors.any { it.canReach(destination, visitedNodes) }
    }

    private val noVisitedNodes get() = mutableListOf<Node>()
}