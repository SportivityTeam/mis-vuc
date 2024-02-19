package ru.sportivityteam.vucmirea.assistant.presentation.screens.home.info

import ru.sportivityteam.vucmirea.assistant.presentation.ui.mvi.BaseStateScreenModel

class InfoSM: BaseStateScreenModel<HomeViewState, HomeViewAction, HomeViewEvent>(initialState = HomeViewState()) {
    override fun obtainEvent(viewEvent: HomeViewEvent) {
        when(viewEvent){
            is HomeViewEvent.OpenLesson -> viewEvent.lessonId
        }
    }
}