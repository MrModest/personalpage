package io.github.mrmodest.personalpage.persistence

import org.springframework.data.repository.*
import io.github.mrmodest.personalpage.dtos.LinkCardAddDto
import io.github.mrmodest.personalpage.dtos.LinkCardEditDto
import io.github.mrmodest.personalpage.dtos.toEntity
import io.github.mrmodest.personalpage.entities.LinkCard
import io.github.mrmodest.personalpage.repositories.LinkCardRepository

interface LinkCardDataRepository : CrudRepository<LinkCard, Long>

class LinkCardRepositoryImpl(
    private val dataRepository: LinkCardDataRepository
) : LinkCardRepository {
    override fun add(card: LinkCardAddDto) = dataRepository.save(card.toEntity())

    override fun edit(card: LinkCardEditDto): LinkCard {
        card.validate()
        val entity = dataRepository.findById(card.id)
            .orElseThrow{ IllegalArgumentException("Not found card with id ${card.id}!") }
        return dataRepository.save(card.toEntity(entity.userId, entity.isArchived))
    }

    override fun remove(cardId: Long) {
        dataRepository.deleteById(cardId)
    }
}