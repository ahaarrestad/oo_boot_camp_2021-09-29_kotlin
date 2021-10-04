/*
 * Copyright (c) 2021 by Fred George
 * May be used freely except for training; license required for training.
 * @author Fred George  fredgeorge@acm.org
 */

package com.nrkei.training.oo.rectangle

import com.nrkei.training.oo.order.Orderable

// Understands a four-sided polygon with sides at right angles
class Rectangle(length: Number, width: Number) : Orderable<Rectangle> {
    private val length = length.toDouble()
    private val width = width.toDouble()

    init {
        require(length.toDouble() > 0.0 && width.toDouble() > 0.0)
        { "Rectangle dimensions must be greater than zero" }
    }

    companion object {
        fun square(side: Number) = Rectangle(side, side)
    }

    fun area() = width * length
    val area get() = area()

    fun perimeter() = 2 * (length + width)

    override fun isBetterThan(other: Rectangle) = this.area > other.area
}
