package ru.sportivityteam.vucmirea.assistant.presentation.entity

data class InfoItem(
    val header: String,
    val text: String
)

data class InfoFutureItem(
    val iconResId: Int,
    val text: String,
    val onClickAction: () -> Unit
)