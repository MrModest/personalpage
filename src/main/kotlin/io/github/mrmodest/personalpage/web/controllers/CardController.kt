package io.github.mrmodest.personalpage.web.controllers

import org.springframework.web.bind.annotation.*
import io.github.mrmodest.personalpage.dtos.LinkCardAddDto
import io.github.mrmodest.personalpage.dtos.LinkCardEditDto
import io.github.mrmodest.personalpage.dtos.LinkSectionAddDto
import io.github.mrmodest.personalpage.entities.LinkCard
import io.github.mrmodest.personalpage.entities.LinkSection
import io.github.mrmodest.personalpage.services.CardService
import io.github.mrmodest.personalpage.services.UserCards
import io.github.mrmodest.personalpage.web.config.getUserContext

@RestController
@RequestMapping("/users")
class CardController(
    private val cardService: CardService
) {
    @GetMapping("/{userId}")
    fun getUserCards(userId: Long) =
        cardService.getUserCards(userId)

    @GetMapping("/my")
    fun getUserCards(): UserCards {
        return cardService.getUserCards(getUserContext().id)
    }

    @GetMapping("/link/add")
    fun addLink(link: LinkCardAddDto): LinkCard {
        if (link.userId != getUserContext().id) {
            throw IllegalArgumentException("You can add cards only for self, but tried ${link.userId}!")
        }
        val section = cardService.getLinkSection(link.sectionId)
        if (section.userId != getUserContext().id) {
            throw IllegalArgumentException("You can add cards only for own sections, but tried ${section.userId}!")
        }

        return cardService.createCard(link)
    }

    @GetMapping("/section/add")
    fun addSection(linkSection: LinkSectionAddDto): LinkSection {
        return cardService.createSection(linkSection)
    }

    @GetMapping("/link/edit")
    fun editLink(link: LinkCardEditDto): LinkCard {
        return cardService.editCard(link)
    }

    @GetMapping("/section/edit")
    fun editSection(linkSection: LinkSectionAddDto): LinkSection {
        if (linkSection.userId != getUserContext().id) {
            throw IllegalArgumentException("You can change only self cards, but tried ${linkSection.userId}!")
        }
        return cardService.createSection(linkSection)
    }
}