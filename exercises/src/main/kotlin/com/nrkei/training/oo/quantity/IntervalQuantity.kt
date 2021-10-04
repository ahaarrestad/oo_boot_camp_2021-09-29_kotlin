package com.nrkei.training.oo.quantity

import com.nrkei.training.oo.order.Orderable
import kotlin.math.absoluteValue

open class IntervalQuantity internal constructor(amount: Number, protected val unit: Unit)
    : Orderable<IntervalQuantity> {

    companion object {
        internal const val EPSILON = 1e-10
    }

    protected val amount = amount.toDouble()

    @Suppress("ComplexMethod")
    override fun equals(other: Any?) = this === other || other is IntervalQuantity && this.equals(other)

    private fun equals(other: IntervalQuantity) = this isCompatible other
            && (this.amount - convertedAmount(other)).absoluteValue < EPSILON

    protected fun convertedAmount(other: IntervalQuantity) = this.unit.convertedAmount(other.amount, other.unit)

    override fun hashCode() = unit.hashCode(amount)

    private infix fun isCompatible(other: IntervalQuantity) = this.unit.isCompatible(other.unit)

    override fun isBetterThan(other: IntervalQuantity) = this.amount > convertedAmount(other)
}
