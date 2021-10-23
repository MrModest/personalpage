package io.github.mrmodest.personalpage.services

import io.github.mrmodest.personalpage.dtos.CardSectionEditDto
import io.github.mrmodest.personalpage.dtos.LinkCardAddDto
import io.github.mrmodest.personalpage.dtos.LinkCardEditDto
import io.github.mrmodest.personalpage.dtos.LinkSectionAddDto
import io.github.mrmodest.personalpage.entities.LinkCard
import io.github.mrmodest.personalpage.entities.LinkSection
import io.github.mrmodest.personalpage.entities.ProfileCard

interface CardService {
    fun getUserCards(userId: Long): UserCards

    fun getLink(linkId: Long): LinkCard
    fun getLinkSection(linkSectionId: Long): LinkSection
    fun getProfile(profileId: Long): ProfileCard

    fun createCard(card: LinkCardAddDto): LinkCard
    fun editCard(card: LinkCardEditDto): LinkCard
    fun archiveCard(cardId: Long): LinkCard
    fun unarchiveCard(cardId: Long): LinkCard

    fun createSection(section: LinkSectionAddDto): LinkSection
    fun editSection(section: CardSectionEditDto): LinkSection
    fun archiveSection(sectionId: Long): LinkSection
    fun unarchiveSection(sectionId: Long): LinkSection
}

class UserCards(
    val profiles: Array<ProfileCard>,
    val linksSections: Array<LinkSection>,
    val links: Array<LinkCard>
)