/*
 * Copyright (c) 2021 by Fred George
 * May be used freely except for training; license required for training.
 * @author Fred George  fredgeorge@acm.org
 */

package com.nrkei.training.oo.unit

import com.nrkei.training.oo.rectangle.Rectangle
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

// Ensures Rectangle operates correctly
internal class RectangleTest {

    @Test fun area() {
        assertEquals(24.0, Rectangle(4.0, 6.0).area())
        assertEquals(24.0, Rectangle(4, 6).area())
        assertEquals(24.0, Rectangle(4, 6).area)
        assertEquals(36.0, Rectangle.square(6.0).area)
        assertEquals(36.0, Rectangle.square(6).area)
    }

    @Test fun perimeter() {
        assertEquals(20.0, Rectangle(4, 6).perimeter())
        assertEquals(24.0, Rectangle.square(6).perimeter())
    }

    @Test fun `valid parameters`() {
        assertThrows<IllegalArgumentException>{ Rectangle(0, 6) }
        assertThrows<IllegalArgumentException>{ Rectangle(4, 0) }
        assertThrows<IllegalArgumentException>{ Rectangle.square(0) }
    }
}