package io.github.mrmodest.personalpage.persistence

import org.springframework.data.repository.*
import io.github.mrmodest.personalpage.dtos.LinkCardAddDto
import io.github.mrmodest.personalpage.dtos.LinkCardEditDto
import io.github.mrmodest.personalpage.dtos.toEntity
import io.github.mrmodest.personalpage.entities.LinkCard
import io.github.mrmodest.personalpage.orNotFoundThrow
import io.github.mrmodest.personalpage.repositories.LinkCardRepository
import io.github.mrmodest.personalpage.repositories.SimpleRepository

interface LinkCardDataRepository : CrudRepository<LinkCard, Long> {
    fun findByUserId(userId: Long): List<LinkCard>
}

class LinkCardRepositoryImpl(
    private val dataRepository: LinkCardDataRepository
) : LinkCardRepository, SimpleRepository<LinkCard> {

    override fun find(cardId: Long) = findById(cardId)

    override fun findByUser(userId: Long): List<LinkCard> {
        return dataRepository.findByUserId(userId)
    }

    override fun add(card: LinkCardAddDto): LinkCard {
        card.validate()
        return dataRepository.save(card.toEntity())
    }

    override fun edit(card: LinkCardEditDto): LinkCard {
        card.validate()
        val entity = dataRepository.findById(card.id)
            .orNotFoundThrow(card.id)
        return dataRepository.save(card.toEntity(entity.userId, entity.isArchived))
    }

    override fun archive(cardId: Long) = archive(this, cardId)

    override fun unarchive(cardId: Long) = unarchive(this, cardId)

    override fun findById(id: Long): LinkCard {
        return dataRepository.findById(id)
            .orNotFoundThrow(id)
    }

    override fun save(entity: LinkCard): LinkCard {
        return dataRepository.save(entity)
    }

}