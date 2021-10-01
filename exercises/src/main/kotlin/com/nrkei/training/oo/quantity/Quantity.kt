package com.nrkei.training.oo.quantity

import kotlin.math.absoluteValue

class Quantity internal constructor(amount: Number, private val unit: Unit) {
    companion object {
        internal const val EPSILON = 1e-10
    }

    private val amount = amount.toDouble()

    @Suppress("ComplexMethod")
    override fun equals(other: Any?) = this === other || other is Quantity && this.equals(other)

    private fun equals(other: Quantity) = this isCompatible other
            && (this.amount - convertedAmount(other)).absoluteValue < EPSILON

    private fun convertedAmount(other: Quantity) = this.unit.convertedAmount(other.amount, other.unit)

    override fun hashCode() = unit.hashCode(amount)

    operator fun unaryPlus() = this

    operator fun unaryMinus() = Quantity(-amount, unit)

    operator fun plus(other: Quantity) = Quantity(this.amount + convertedAmount(other), unit)

    operator fun minus(other: Quantity) = this + -other

    private infix fun isCompatible(other: Quantity) = this.unit.isCompatible(other.unit)
}
