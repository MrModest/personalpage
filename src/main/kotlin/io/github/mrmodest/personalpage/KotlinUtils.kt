package io.github.mrmodest.personalpage

import java.util.*

fun <T>Optional<T>.orNull(): T? {
    return this.orElse(null)
}

@Throws(IllegalArgumentException::class)
inline fun <reified T>Optional<T>.orNotFoundThrow(id: Long): T {
    return this.orElseThrow { IllegalArgumentException("Not found ${T::class.simpleName} with id $id!") }
}