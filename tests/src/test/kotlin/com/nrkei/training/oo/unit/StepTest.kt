/*
 * Copyright (c) 2021 by Fred George
 * May be used freely except for training; license required for training.
 * @author Fred George  fredgeorge@acm.org
 */

package com.nrkei.training.oo.unit

import com.nrkei.training.oo.step.Action
import com.nrkei.training.oo.step.Step
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class StepTest {

    @Test
    fun `single step`() {
        CountingAction().also { counter ->
            assertEquals(0, counter.executionCount)
            Step(counter).execute()
        }
    }

    private class CountingAction: Action {
        var executionCount = 0

        override fun execute() = true.also { executionCount += 1 }
    }
}