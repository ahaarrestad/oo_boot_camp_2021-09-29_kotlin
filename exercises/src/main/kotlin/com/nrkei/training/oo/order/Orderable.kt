/*
 * Copyright (c) 2021 by Fred George
 * May be used freely except for training; license required for training.
 * @author Fred George  fredgeorge@acm.org
 */

package com.nrkei.training.oo.order

interface Orderable<T> {
    infix fun isBetterThan(other: T): Boolean
}

fun <S: Orderable<S>> List<S>.bestOrNull() =
    this.reduceOrNull { champion, challenger -> if (challenger isBetterThan champion) challenger else champion }
