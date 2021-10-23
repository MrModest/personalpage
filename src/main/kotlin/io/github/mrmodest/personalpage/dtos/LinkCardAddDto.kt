package io.github.mrmodest.personalpage.dtos

import io.github.mrmodest.personalpage.entities.LinkCard
import io.github.mrmodest.personalpage.entities.Locale

data class LinkCardAddDto(
    val logoUrl: String,
    val cardName: String,
    val title: String,
    val note: String,
    val description: String,
    val url: String,
    val sectionId: Long,
    val locale: Locale,
    val userId: Long
) {
    fun validate() {
        if (sectionId <= 0) {
            throw IllegalArgumentException("LinkCardEditDto.sectionId: sectionId is required! [$sectionId]")
        }

        if (userId <= 0) {
            throw IllegalArgumentException("LinkCardEditDto.userId: user is required! [$userId]")
        }
    }
}

fun LinkCardAddDto.toEntity() =
    LinkCard(0, logoUrl, cardName, title, note, description, url, sectionId, locale, userId, false)