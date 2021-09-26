package io.github.mrmodest.personalpage.dtos

import io.github.mrmodest.personalpage.entities.Locale

data class CardSectionAddDto(
    val title: String,
    val description: String,
    val locale: Locale,
    val userId: Int
)