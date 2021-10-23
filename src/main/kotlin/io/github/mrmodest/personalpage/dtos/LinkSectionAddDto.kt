package io.github.mrmodest.personalpage.dtos

import io.github.mrmodest.personalpage.entities.LinkSection
import io.github.mrmodest.personalpage.entities.Locale

data class LinkSectionAddDto(
    val title: String,
    val description: String,
    val locale: Locale,
    val userId: Long
) {
    fun validate() {
        if (title.isBlank()) {
            throw IllegalArgumentException("CardSectionEditDto.title: title is required! [$title]")
        }

        if (userId <= 0) {
            throw IllegalArgumentException("CardSectionEditDto.userId: user is required! [$userId]")
        }
    }
}

fun LinkSectionAddDto.toEntity() =
    LinkSection(0, title, description, locale, userId, false )