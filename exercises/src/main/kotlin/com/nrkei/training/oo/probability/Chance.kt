/*
 * Copyright (c) 2021 by Fred George
 * May be used freely except for training; license required for training.
 * @author Fred George  fredgeorge@acm.org
 */

package com.nrkei.training.oo.probability

// Understands the likelihood of something occurring
class Chance(valueAsFraction: Number) {
    private val fraction = valueAsFraction.toDouble()

    init {
        require(fraction in 0.0..1.0)
    }

    companion object {
        private const val CERTAIN_FRACTION = 1.0
    }

    @Suppress("ComplexMethod")
    override fun equals(other: Any?) = this === other || other is Chance && this.equals(other)

    private fun equals(other: Chance) = this.fraction == other.fraction

    override fun hashCode() = fraction.hashCode()

    operator fun not() = Chance(CERTAIN_FRACTION - fraction)

    infix fun and(other: Chance) = Chance(this.fraction * other.fraction)
}
