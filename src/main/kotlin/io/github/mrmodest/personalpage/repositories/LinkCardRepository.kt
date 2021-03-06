package io.github.mrmodest.personalpage.repositories

import io.github.mrmodest.personalpage.dtos.LinkCardAddDto
import io.github.mrmodest.personalpage.dtos.LinkCardEditDto
import io.github.mrmodest.personalpage.entities.LinkCard

interface LinkCardRepository {
    fun find(cardId: Long): LinkCard
    fun findByUser(userId: Long): List<LinkCard>

    fun add(card: LinkCardAddDto): LinkCard
    fun edit(card: LinkCardEditDto): LinkCard
    fun archive(cardId: Long): LinkCard
    fun unarchive(cardId: Long): LinkCard
}