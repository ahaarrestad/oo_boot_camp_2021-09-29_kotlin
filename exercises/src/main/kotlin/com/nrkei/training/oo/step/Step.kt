package com.nrkei.training.oo.step

class Step(private val action: Action) {
    fun execute(): Boolean = action.execute()
}
