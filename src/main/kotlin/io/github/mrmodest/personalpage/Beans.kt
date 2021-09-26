package io.github.mrmodest.personalpage

import org.springframework.context.*
import org.springframework.context.support.*
import io.github.mrmodest.personalpage.persistence.LinkCardRepositoryImpl
import io.github.mrmodest.personalpage.repositories.LinkCardRepository

val beans = beans {
    bean<LinkCardRepository> {
        LinkCardRepositoryImpl(ref())
    }
}

// See application.properties context.initializer.classes entry
class BeansInitializer : ApplicationContextInitializer<GenericApplicationContext> {
    override fun initialize(context: GenericApplicationContext) =
        beans.initialize(context)
}