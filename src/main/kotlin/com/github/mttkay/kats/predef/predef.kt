package com.github.mttkay.kats.predef

import com.github.mttkay.kats.Monoid
import com.github.mttkay.kats.Semigroup

/*
Monoids
 */
val AddIntMonoid: Monoid<Int> by lazy { Monoid.of(0) { a, b -> a + b } }
val AddLongMonoid: Monoid<Long> by lazy { Monoid.of(0L) { a, b -> a + b } }
val AddFloatMonoid: Monoid<Float> by lazy { Monoid.of(0F) { a, b -> a + b } }
val AddDoubleMonoid: Monoid<Double> by lazy { Monoid.of(0.0) { a, b -> a + b } }
val AddStringMonoid: Monoid<String> by lazy { Monoid.of("") { a, b -> a + b } }

private fun <T> nullableMonoid(sg: Semigroup<T>): Monoid<T?> = Monoid.of(null as T?) { a, b ->
  sg.maybeCombine(a, b)
}
val AddNullableIntMonoid: Monoid<Int?> by lazy { nullableMonoid(AddIntMonoid) }
val AddNullableLongMonoid: Monoid<Long?> by lazy { nullableMonoid(AddLongMonoid) }
val AddNullableFloatMonoid: Monoid<Float?> by lazy { nullableMonoid(AddFloatMonoid) }
val AddNullableDoubleMonoid: Monoid<Double?> by lazy { nullableMonoid(AddDoubleMonoid) }
val AddNullableStringMonoid: Monoid<String?> by lazy { nullableMonoid(AddStringMonoid) }

val MulIntMonoid: Monoid<Int> by lazy { Monoid.of(1) { a, b -> a * b } }
val MulLongMonoid: Monoid<Long> by lazy { Monoid.of(1L) { a, b -> a * b } }
val MulFloatMonoid: Monoid<Float> by lazy { Monoid.of(1F) { a, b -> a * b } }
val MulDoubleMonoid: Monoid<Double> by lazy { Monoid.of(1.0) { a, b -> a * b } }

val BoolOrMonoid: Monoid<Boolean> by lazy { Monoid.of(false) { a, b -> a or b } }
val BoolAndMonoid: Monoid<Boolean> by lazy { Monoid.of(true) { a, b -> a and b } }
