package dev.reimer.kotlin.jvm.ktx

inline val Int.isEven: Boolean get() = rem(2) == 0
inline val Int.isOdd: Boolean get() = !isEven

fun Double.takeUnlessNaN() = takeUnless(Double::isNaN)
fun Float.takeUnlessNaN() = takeUnless(Float::isNaN)

tailrec infix fun Long.gcd(other: Long): Long =
    if (other == 0L) this else other.gcd(this % other)

tailrec infix fun Int.gcd(other: Int): Int =
    if (other == 0) this else other.gcd(this % other)

fun Sequence<Long>.gcd(): Long = reduce(Long::gcd)

fun Iterable<Long>.gcd() = asSequence().gcd()

fun LongArray.gcd() = asSequence().gcd()

fun Sequence<Int>.gcd(): Int = reduce(Int::gcd)

fun Iterable<Int>.gcd() = asSequence().gcd()

fun IntArray.gcd() = asSequence().gcd()

infix fun Long.lcm(other: Long) = this * (other / (this gcd other))

infix fun Int.lcm(other: Int) = this * (other / (this gcd other))

fun Sequence<Long>.lcm(): Long = reduce(Long::lcm)

fun Iterable<Long>.lcm() = asSequence().lcm()

fun LongArray.lcm() = asSequence().lcm()

fun Sequence<Int>.lcm(): Int = reduce(Int::lcm)

fun Iterable<Int>.lcm() = asSequence().lcm()

fun IntArray.lcm() = asSequence().lcm()

fun Sequence<Double>.maxDelta(): Double? {
    val iterator = iterator()
    if (!iterator.hasNext()) return null
    var max = iterator.next()
    var min = iterator.next()
    if (max.isNaN()) return max
    if (min.isNaN()) return min
    while (iterator.hasNext()) {
        val e = iterator.next()
        if (e.isNaN()) return e
        if (max < e) max = e
        if (min > e) min = e
    }
    return max - min
}

fun Iterable<Double>.maxDelta(): Double? = asSequence().maxDelta()

fun DoubleArray.maxDelta(): Double? = asSequence().maxDelta()

fun Sequence<Float>.maxDelta(): Float? {
    val iterator = iterator()
    if (!iterator.hasNext()) return null
    var max = iterator.next()
    var min = iterator.next()
    if (max.isNaN()) return max
    if (min.isNaN()) return min
    while (iterator.hasNext()) {
        val e = iterator.next()
        if (e.isNaN()) return e
        if (max < e) max = e
        if (min > e) min = e
    }
    return max - min
}

fun Iterable<Float>.maxDelta(): Float? = asSequence().maxDelta()

fun FloatArray.maxDelta(): Float? = asSequence().maxDelta()

fun Sequence<Long>.maxDelta(): Long? {
    val iterator = iterator()
    if (!iterator.hasNext()) return null
    var max = iterator.next()
    var min = iterator.next()
    while (iterator.hasNext()) {
        val e = iterator.next()
        if (max < e) max = e
        if (min > e) min = e
    }
    return max - min
}

fun Iterable<Long>.maxDelta(): Long? = asSequence().maxDelta()

fun LongArray.maxDelta(): Long? = asSequence().maxDelta()

fun Sequence<Int>.maxDelta(): Int? {
    val iterator = iterator()
    if (!iterator.hasNext()) return null
    var max = iterator.next()
    var min = iterator.next()
    while (iterator.hasNext()) {
        val e = iterator.next()
        if (max < e) max = e
        if (min > e) min = e
    }
    return max - min
}

fun Iterable<Int>.maxDelta(): Int? = asSequence().maxDelta()

fun IntArray.maxDelta(): Int? = asSequence().maxDelta()

inline fun <T> Iterable<T>.productBy(selector: (T) -> Int): Int =
    fold(1) { acc, element -> acc * selector(element) }

inline fun <T> Iterable<T>.productByDouble(selector: (T) -> Double): Double =
    fold(1.0) { acc, element -> acc * selector(element) }

@JvmName("productOfByte")
fun Iterable<Byte>.product(): Int = fold(1) { acc, element -> acc * element }

@JvmName("productOfShort")
fun Iterable<Short>.product(): Int = fold(1) { acc, element -> acc * element }

@JvmName("productOfInt")
fun Iterable<Int>.product(): Int = fold(1) { acc, element -> acc * element }

@JvmName("productOfLong")
fun Iterable<Long>.product(): Long = fold(1L) { acc, element -> acc * element }

@JvmName("productOfFloat")
fun Iterable<Float>.product(): Float = fold(1.0f) { acc, element -> acc * element }

@JvmName("productOfDouble")
fun Iterable<Double>.product(): Double = fold(1.0) { acc, element -> acc * element }
