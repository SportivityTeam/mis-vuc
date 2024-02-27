package ru.sportivityteam.vucmirea.assistant.presentation.screens.lesson

import ru.sportivityteam.vucmirea.assistant.presentation.ui.mvi.BaseStateScreenModel

class LessonSM: BaseStateScreenModel<LessonViewState, LessonViewAction, LessonViewEvent>
    (initialState = LessonViewState()) {
    override fun obtainEvent(viewEvent: LessonViewEvent) {
        TODO("Not yet implemented")
    }
}