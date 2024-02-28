package ru.sportivityteam.vucmirea.assistant.presentation.screens.home.timetable

import ru.sportivityteam.vucmirea.assistant.presentation.ui.mvi.BaseStateScreenModel

class TimetableSM :
    BaseStateScreenModel<TimetableViewState, TimetableViewAction, TimetableViewEvent>(initialState = TimetableViewState()) {

    override fun obtainEvent(viewEvent: TimetableViewEvent) {
        viewAction = when (viewEvent) {
            is TimetableViewEvent.OpenLesson -> {
                TimetableViewAction.NavigateToLesson(viewEvent.lessonId)
            }

            is TimetableViewEvent.Clear -> null
        }
    }
}