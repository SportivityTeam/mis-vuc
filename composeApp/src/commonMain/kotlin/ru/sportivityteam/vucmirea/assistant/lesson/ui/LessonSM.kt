package ru.sportivityteam.vucmirea.assistant.lesson.ui

import ru.sportivityteam.vucmirea.assistant.core.uikit.mvi.BaseStateScreenModel

class LessonSM: BaseStateScreenModel<LessonViewState, LessonViewAction, LessonViewEvent>
    (initialState = LessonViewState()) {
    override fun obtainEvent(viewEvent: LessonViewEvent) {
        TODO("Not yet implemented")
    }
}