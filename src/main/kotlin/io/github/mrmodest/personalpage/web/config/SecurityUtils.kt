package io.github.mrmodest.personalpage.web.config

import org.springframework.security.core.context.*

fun getUserContext() = SecurityContextHolder.getContext().authentication.details as UserDetails