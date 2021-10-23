package io.github.mrmodest.personalpage.persistence

import io.github.mrmodest.personalpage.entities.Archivable
import io.github.mrmodest.personalpage.entities.HasId
import io.github.mrmodest.personalpage.repositories.SimpleRepository

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

fun <T>archive(repo: SimpleRepository<T>, id: Long): T
    where T: HasId,
          T: Archivable {
    val entity = repo.findById(id)

    entity.isArchived = true

    return repo.save(entity)
}

fun <T>unarchive(repo: SimpleRepository<T>, id: Long): T
    where T: HasId,
          T: Archivable  {
    val entity = repo.findById(id)

    entity.isArchived = false

    return repo.save(entity)
}