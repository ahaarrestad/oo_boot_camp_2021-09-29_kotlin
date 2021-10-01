package com.nrkei.training.oo.quantity

class RatioQuantity internal constructor(amount: Number, unit: Unit) : IntervalQuantity(amount, unit) {

    operator fun unaryPlus() = this

    operator fun unaryMinus() = RatioQuantity(-amount, unit)

    operator fun plus(other: RatioQuantity) = RatioQuantity(this.amount + convertedAmount(other), unit)

    operator fun minus(other: RatioQuantity) = this + -other
}
