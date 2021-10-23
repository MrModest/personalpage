package io.github.mrmodest.personalpage.services

import io.github.mrmodest.personalpage.dtos.CardSectionEditDto
import io.github.mrmodest.personalpage.dtos.LinkCardAddDto
import io.github.mrmodest.personalpage.dtos.LinkCardEditDto
import io.github.mrmodest.personalpage.dtos.LinkSectionAddDto
import io.github.mrmodest.personalpage.entities.ProfileCard
import io.github.mrmodest.personalpage.repositories.LinkCardRepository
import io.github.mrmodest.personalpage.repositories.LinkCardSectionRepository

class CardServiceImpl(
    private val linkRepository: LinkCardRepository,
    private val sectionRepository: LinkCardSectionRepository
) : CardService {

    override fun getUserCards(userId: Long): UserCards {
        val profiles = emptyArray<ProfileCard>()
        val linksSections = sectionRepository.findByUser(userId).toTypedArray()
        val links = linkRepository.findByUser(userId).toTypedArray()

        return UserCards(profiles, linksSections, links)
    }

    override fun getLink(linkId: Long) =
        linkRepository.find(linkId)

    override fun getLinkSection(linkSectionId: Long) =
        sectionRepository.find(linkSectionId)

    override fun getProfile(profileId: Long): ProfileCard {
        TODO("Not yet implemented")
    }

    override fun createCard(card: LinkCardAddDto) =
        linkRepository.add(card)

    override fun editCard(card: LinkCardEditDto) =
        linkRepository.edit(card)

    override fun archiveCard(cardId: Long) =
        linkRepository.archive(cardId)

    override fun unarchiveCard(cardId: Long) =
        linkRepository.unarchive(cardId)


    override fun createSection(section: LinkSectionAddDto) =
        sectionRepository.add(section)

    override fun editSection(section: CardSectionEditDto) =
        sectionRepository.edit(section)

    override fun archiveSection(sectionId: Long) =
        sectionRepository.archive(sectionId)

    override fun unarchiveSection(sectionId: Long) =
        sectionRepository.unarchive(sectionId)
}