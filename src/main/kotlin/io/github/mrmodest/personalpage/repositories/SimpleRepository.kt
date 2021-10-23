package io.github.mrmodest.personalpage.repositories

import io.github.mrmodest.personalpage.entities.Archivable
import io.github.mrmodest.personalpage.entities.HasId

interface SimpleRepository<T>
        where T: HasId,
              T: Archivable {
    fun findById(entityId: Long): T
    fun save(entity: T): T
}