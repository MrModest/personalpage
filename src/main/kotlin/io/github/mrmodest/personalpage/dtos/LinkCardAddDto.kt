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
    val locale: Locale,
    val userId: Long
)

fun LinkCardAddDto.toEntity() =
    LinkCard(0, logoUrl, cardName, title, note, description, url, locale, userId, false)