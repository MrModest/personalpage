package io.github.mrmodest.personalpage.persistence

import io.github.mrmodest.personalpage.entities.HasId

fun HasId.throwIfAlreadyExists() {
    if (this.id > 0) {
        throw IllegalArgumentException("You try insert existed entity!")
    }
}

fun HasId.throwIfNotExists() {
    if (this.id <= 0) {
        throw IllegalArgumentException("You try update/delete not existed entity!")
    }
}