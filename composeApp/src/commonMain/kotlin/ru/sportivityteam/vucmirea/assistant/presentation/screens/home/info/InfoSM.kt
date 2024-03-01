package ru.sportivityteam.vucmirea.assistant.presentation.screens.home.info

import ru.sportivityteam.vucmirea.assistant.presentation.ui.mvi.BaseStateScreenModel

class InfoSM: BaseStateScreenModel<InfoViewState, InfoViewAction, InfoViewEvent>(initialState = InfoViewState()) {
    override fun obtainEvent(viewEvent: InfoViewEvent) {
        when(viewEvent){
            is InfoViewEvent.OpenLesson -> viewEvent.lessonId
        }
    }
}