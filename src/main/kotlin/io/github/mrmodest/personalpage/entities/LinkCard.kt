package io.github.mrmodest.personalpage.entities

class LinkCard(
    override val id: Long,
    val logoUrl: String,
    val cardName: String,
    val title: String,
    val note: String,
    val description: String,
    val url: String,

    override val locale: Locale,

    override val userId: Long,

    override val isArchived: Boolean
) : HasId, Localizable, Ownerable, Archivable