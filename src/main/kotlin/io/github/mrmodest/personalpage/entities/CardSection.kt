package io.github.mrmodest.personalpage.entities

class CardSection(
    override val id: Long,
    val title: String,
    val description: String,

    override val locale: Locale,

    override val userId: Long,

    override val isArchived: Boolean
) : HasId, Localizable, Ownerable, Archivable