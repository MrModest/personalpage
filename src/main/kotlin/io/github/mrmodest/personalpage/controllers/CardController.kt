package io.github.mrmodest.personalpage.controllers

import org.springframework.web.bind.annotation.*
import io.github.mrmodest.personalpage.repositories.LinkCardRepository

@RestController
class CardController(
    private val linkCardRepository: LinkCardRepository
) {
    
}