package io.github.mrmodest.personalpage.entities

class LinkCard(
    override val id: Long,
    val logoUrl: String,
    val cardName: String,
    val title: String,
    val note: String,
    val description: String,
    val url: String,
    val sectionId: Long,

    override val locale: Locale,

    override val userId: Long,

    override var isArchived: Boolean
) : HasId, Localizable, Ownerable, Archivable