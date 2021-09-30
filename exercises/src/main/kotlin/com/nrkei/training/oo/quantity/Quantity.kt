package com.nrkei.training.oo.quantity

class Quantity(amount: Number, private val unit: Unit) {
    private val amount = amount.toDouble()

    override fun equals(other: Any?) = this === other || other is Quantity && this.equals(other)

    private fun equals(other: Quantity) = this.amount == other.amount && this.unit == other.unit

    override fun hashCode() = amount.hashCode() * 37 + unit.hashCode()
}