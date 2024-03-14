package ru.sportivityteam.vucmirea.assistant.home.schedule.domain.entity

data class InfoItem(
    val header: String,
    val text: String
)

data class InfoFutureItem(
    val iconResId: Int,
    val text: String,
    val onClickAction: () -> Unit
)