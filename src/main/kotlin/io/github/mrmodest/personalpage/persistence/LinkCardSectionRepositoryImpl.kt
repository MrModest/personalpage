package io.github.mrmodest.personalpage.persistence

import org.springframework.data.repository.*
import io.github.mrmodest.personalpage.dtos.CardSectionEditDto
import io.github.mrmodest.personalpage.dtos.LinkSectionAddDto
import io.github.mrmodest.personalpage.dtos.toEntity
import io.github.mrmodest.personalpage.entities.LinkSection
import io.github.mrmodest.personalpage.orNotFoundThrow
import io.github.mrmodest.personalpage.repositories.LinkCardSectionRepository
import io.github.mrmodest.personalpage.repositories.SimpleRepository

interface LinkCardSectionDataRepository : CrudRepository<LinkSection, Long> {
    fun findByUserId(userId: Long): List<LinkSection>
}

class LinkCardSectionRepositoryImpl(
    private val dataRepository: LinkCardSectionDataRepository
) : LinkCardSectionRepository, SimpleRepository<LinkSection> {
    override fun find(cardId: Long) = findById(cardId)

    override fun findByUser(userId: Long): List<LinkSection> {
        return dataRepository.findByUserId(userId)
    }

    override fun add(section: LinkSectionAddDto): LinkSection {
        section.validate()
        return dataRepository.save(section.toEntity())
    }

    override fun edit(section: CardSectionEditDto): LinkSection {
        section.validate()
        val entity = dataRepository.findById(section.id)
            .orElseThrow { IllegalArgumentException("Not found section with id ${section.id}!") }
        return dataRepository.save(section.toEntity(entity.userId, entity.isArchived))
    }

    override fun archive(sectionId: Long) = archive(this, sectionId)

    override fun unarchive(sectionId: Long) = unarchive(this, sectionId)

    override fun findById(entityId: Long): LinkSection {
        return dataRepository.findById(entityId)
            .orNotFoundThrow(entityId)
    }

    override fun save(entity: LinkSection): LinkSection {
        return dataRepository.save(entity)
    }
}