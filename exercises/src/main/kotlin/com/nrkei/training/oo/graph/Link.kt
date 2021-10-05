/*
 * Copyright (c) 2021 by Fred George
 * May be used freely except for training; license required for training.
 * @author Fred George  fredgeorge@acm.org
 */

package com.nrkei.training.oo.graph

// Understands a connection from one Node to another
internal class Link(private val cost: Double, private val target: Node) {

    internal fun hopCount(destination: Node, visitedNodes: List<Node>) =
        target.hopCount(destination, visitedNodes) + 1
}