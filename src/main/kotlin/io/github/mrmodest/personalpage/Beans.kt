package io.github.mrmodest.personalpage

import org.springframework.context.*
import org.springframework.context.support.*
import io.github.mrmodest.personalpage.persistence.LinkCardRepositoryImpl
import io.github.mrmodest.personalpage.persistence.LinkCardSectionRepositoryImpl
import io.github.mrmodest.personalpage.repositories.LinkCardRepository
import io.github.mrmodest.personalpage.repositories.LinkCardSectionRepository
import io.github.mrmodest.personalpage.services.CardService
import io.github.mrmodest.personalpage.services.CardServiceImpl

val beans = beans {
    bean<LinkCardRepository> {
        LinkCardRepositoryImpl(ref())
    }
    bean<LinkCardSectionRepository> {
        LinkCardSectionRepositoryImpl(ref())
    }
    // profile
    bean<CardService> {
        CardServiceImpl(ref(), ref())
    }
}

// See application.properties context.initializer.classes entry
class BeansInitializer : ApplicationContextInitializer<GenericApplicationContext> {
    override fun initialize(context: GenericApplicationContext) =
        beans.initialize(context)
}