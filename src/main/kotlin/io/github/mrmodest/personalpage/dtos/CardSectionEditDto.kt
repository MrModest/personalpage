package io.github.mrmodest.personalpage.dtos

import io.github.mrmodest.personalpage.entities.Locale

data class CardSectionEditDto(
    val id: Long,
    val title: String,
    val description: String,
    val locale: Locale
)