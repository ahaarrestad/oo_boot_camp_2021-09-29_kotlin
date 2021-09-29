/*
 * Copyright (c) 2021 by Fred George
 * May be used freely except for training; license required for training.
 * @author Fred George  fredgeorge@acm.org
 */

package com.nrkei.training.oo.unit

import com.nrkei.training.oo.probability.Chance
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

// Ensures Chance operates correctly
internal class ChanceTest {

    companion object {
        private val IMPOSSIBLE = Chance(0)
        private val UNLIKELY = Chance(0.25)
        private val EQUALLY_LIKELY = Chance(0.5)
        private val LIKELY = Chance(0.75)
        private val CERTAIN = Chance(1)
    }

    @Test fun equality() {
        assertEquals(LIKELY, Chance(0.75))
        assertNotEquals(LIKELY, Chance(0.25))
        assertNotEquals(LIKELY, Any())
        assertNotEquals(LIKELY, null)
    }

    @Test fun `Chance in sets`() {
        assertTrue(Chance(0.75) in hashSetOf(Chance(0.75)))
        assertEquals(1, hashSetOf(Chance(0.75), Chance(0.75)).size)
    }

    @Test fun hash() {
        assertEquals(Chance(0.75).hashCode(), Chance(0.75).hashCode())
    }

    @Test fun not() {
        assertEquals(UNLIKELY, LIKELY.not())
        assertEquals(LIKELY, LIKELY.not().not())
        assertEquals(LIKELY, !!LIKELY)
        assertEquals(IMPOSSIBLE, CERTAIN.not())
        assertEquals(EQUALLY_LIKELY, EQUALLY_LIKELY.not())
    }

    @Test fun and() {
        assertEquals(UNLIKELY, EQUALLY_LIKELY and EQUALLY_LIKELY)
        assertEquals(Chance(0.1875), LIKELY and UNLIKELY)
        assertEquals(LIKELY and UNLIKELY, UNLIKELY and LIKELY)
        assertEquals(IMPOSSIBLE, LIKELY and IMPOSSIBLE)
        assertEquals(LIKELY, CERTAIN and LIKELY)
    }

    @Test internal fun `invalid fractions`() {
        assertThrows<IllegalArgumentException> { Chance(-0.01) }
        assertThrows<IllegalArgumentException> { Chance(1.01) }
    }
}
