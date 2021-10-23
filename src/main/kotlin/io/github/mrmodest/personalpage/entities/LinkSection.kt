package io.github.mrmodest.personalpage.entities

class LinkSection(
    override val id: Long,
    val title: String,
    val description: String,

    override val locale: Locale,

    override val userId: Long,

    override var isArchived: Boolean
) : HasId, Localizable, Ownerable, Archivable