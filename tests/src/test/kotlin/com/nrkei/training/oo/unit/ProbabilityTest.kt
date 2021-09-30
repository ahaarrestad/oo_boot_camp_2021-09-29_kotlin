package com.nrkei.training.oo.unit

import com.nrkei.training.oo.rectangle.Probability
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.IllegalArgumentException

internal class ProbabilityTest {

    @Test fun not() {
        assertEquals(!Probability(0.2), Probability(0.8))
        assertEquals(!!Probability(0.20), Probability(0.20))
        assertEquals(!!Probability(0.003), Probability(0.003))
        assertEquals((!!Probability(0.00003)).hashCode(), Probability(0.00003).hashCode())
    }

    @Test fun or() {
        assertEquals(Probability(0.20).or(Probability(0.40)), Probability(0.52))
        assertEquals(Probability(0.60).or(Probability(0.70)), Probability(0.88))
    }

    @Test fun compare() {
        assertTrue(Probability(0.20) > Probability(0.10))
    }

    @Test fun hash() {
        assertEquals(Probability(0.20).hashCode(), Probability(0.20).hashCode())
        assertFalse(Probability(0.20).hashCode() == Probability(0.40).hashCode())
    }

    @Test fun `Range of probability`() {
        assertThrows<IllegalArgumentException> { Probability(-0.000000001) }
        assertThrows<IllegalArgumentException> { Probability(1.00000000001) }
    }

    @Test fun and() {
        assertEquals(Probability(0.20).and(Probability(0.20)), Probability(0.04))
        assertEquals(Probability(0.40).and(Probability(0.60)), Probability(0.24))
    }
}