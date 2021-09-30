/*
 * Copyright (c) 2021 by Fred George
 * May be used freely except for training; license required for training.
 * @author Fred George  fredgeorge@acm.org
 */

package com.nrkei.training.oo.unit

import com.nrkei.training.oo.quantity.Quantity
import com.nrkei.training.oo.quantity.Unit.Companion.PINT
import com.nrkei.training.oo.quantity.Unit.Companion.TABLESPOON

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

// Ensures Quantity operates correctly
internal class QuantityTest {

    @Test fun `equality of like Units`() {
        assertEquals(Quantity(8, TABLESPOON), Quantity(8, TABLESPOON))
        assertNotEquals(Quantity(8, TABLESPOON), Quantity(6, TABLESPOON))
        assertNotEquals(Quantity(8, TABLESPOON), Any())
        assertNotEquals(Quantity(8, TABLESPOON), null)
    }

    @Test fun `equality of different Units`() {
        assertNotEquals(Quantity(8, TABLESPOON), Quantity(8, PINT))
    }

    @Test
    fun `Chance in sets`() {
        assertTrue(Quantity(8, TABLESPOON) in hashSetOf(Quantity(8, TABLESPOON)))
        assertEquals(1, hashSetOf(Quantity(8, TABLESPOON), Quantity(8, TABLESPOON)).size)
    }

    @Test fun hash() {
        assertEquals(Quantity(8, TABLESPOON).hashCode(), Quantity(8, TABLESPOON).hashCode())
    }

}
