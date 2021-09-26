package io.github.mrmodest.personalpage

import java.util.*

fun <T>Optional<T>.orNull(): T? {
    return this.orElse(null)
}