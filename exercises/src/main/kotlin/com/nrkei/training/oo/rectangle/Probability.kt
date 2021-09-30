package com.nrkei.training.oo.rectangle

import java.math.BigDecimal

class Probability(fraction: Number) : Comparable<Probability> {
    private val fraction = BigDecimal.valueOf(fraction.toDouble())

    companion object {
        val CERTAIN_FRACTION = BigDecimal.valueOf(1.0)
    }

    init {
        require(this.fraction >= BigDecimal.ZERO && this.fraction <= CERTAIN_FRACTION) { "no!" }
    }

    override fun equals(other: Any?) = this === other || (other is Probability && this.equals(other))
    override fun compareTo(other: Probability) = this.fraction.compareTo(other.fraction)
    override fun hashCode() = fraction.hashCode()

    fun and(other: Probability) = Probability(this.fraction * other.fraction)
    //fun or(other: Probability) = this - this.and(other) + other
    fun or(other: Probability) = Probability(this.fraction + other.fraction - (this.fraction * other.fraction))
    operator fun not() = Probability((CERTAIN_FRACTION - fraction))

    override fun toString() = "Probability(fraction=$fraction)"

    // ===== Internal stuff ============================================================================================
    private fun equals(other: Probability) = this.fraction == other.fraction
    private operator fun plus(other: Probability) = Probability(this.fraction + other.fraction)
    private operator fun minus(other: Probability) = Probability(this.fraction - other.fraction)
}
