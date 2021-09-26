package io.github.mrmodest.personalpage.entities

import java.time.LocalDate
import org.springframework.data.annotation.*

class ProfileCard @PersistenceConstructor constructor(
    override val id: Long,
    val avatarUrl: String,
    val nickname: String,
    val firstname: String,
    val lastname: String,
    val dateOfBirth: LocalDate,
    val about: String,

    override val locale: Locale,

    override val userId: Long,

    override val isArchived: Boolean
) : HasId, Localizable, Ownerable, Archivable