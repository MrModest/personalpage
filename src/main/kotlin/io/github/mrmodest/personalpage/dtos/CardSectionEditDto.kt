package io.github.mrmodest.personalpage.dtos

import io.github.mrmodest.personalpage.entities.LinkSection
import io.github.mrmodest.personalpage.entities.Locale

data class CardSectionEditDto(
    val id: Long,
    val title: String,
    val description: String,
    val locale: Locale
) {
    fun validate() {
        if (id <= 0) {
            throw IllegalArgumentException("CardSectionEditDto.id: id is required! [$id]")
        }

        if (title.isBlank()) {
            throw IllegalArgumentException("CardSectionEditDto.title: title is required! [$title]")
        }
    }
}

fun CardSectionEditDto.toEntity(userId: Long, isArchived: Boolean) =
    LinkSection(id, title, description, locale, userId, isArchived)
