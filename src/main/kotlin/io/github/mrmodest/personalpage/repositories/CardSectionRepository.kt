package io.github.mrmodest.personalpage.repositories

import io.github.mrmodest.personalpage.dtos.CardSectionAddDto
import io.github.mrmodest.personalpage.dtos.CardSectionEditDto
import io.github.mrmodest.personalpage.entities.CardSection

interface CardSectionRepository {
    fun add(cardSection: CardSectionAddDto): CardSection
    fun addLinkCard(linkCardId: Long)
    fun removeLinkCard(linkCardId: Long)
    fun edit(cardSection: CardSectionEditDto): CardSection
    fun archive(cardSectionId: Long)
}