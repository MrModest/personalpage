package io.github.mrmodest.personalpage.dtos

import io.github.mrmodest.personalpage.entities.LinkCard
import io.github.mrmodest.personalpage.entities.Locale

class LinkCardEditDto(
    val id: Long,
    val logoUrl: String,
    val cardName: String,
    val title: String,
    val note: String,
    val description: String,
    val url: String,
    val locale: Locale
) {
    fun validate() {
        if (id <= 0) {
            throw IllegalArgumentException("LinkCardEditDto.id: expect positive, but got $id!")
        }
    }
}

fun LinkCardEditDto.toEntity(userId: Long, isArchived: Boolean) =
    LinkCard(id, logoUrl, cardName, title, note, description, url, locale, userId, isArchived)
