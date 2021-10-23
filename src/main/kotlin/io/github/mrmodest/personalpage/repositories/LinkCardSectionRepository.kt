package io.github.mrmodest.personalpage.repositories

import io.github.mrmodest.personalpage.dtos.CardSectionEditDto
import io.github.mrmodest.personalpage.dtos.LinkSectionAddDto
import io.github.mrmodest.personalpage.entities.LinkSection

interface LinkCardSectionRepository {
    fun find(cardId: Long): LinkSection
    fun findByUser(userId: Long): List<LinkSection>

    fun add(section: LinkSectionAddDto): LinkSection
    fun edit(section: CardSectionEditDto): LinkSection
    fun archive(sectionId: Long): LinkSection
    fun unarchive(sectionId: Long): LinkSection
}