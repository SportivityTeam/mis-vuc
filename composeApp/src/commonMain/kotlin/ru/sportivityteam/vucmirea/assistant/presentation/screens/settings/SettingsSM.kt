package ru.sportivityteam.vucmirea.assistant.presentation.screens.settings

import ru.sportivityteam.vucmirea.assistant.presentation.ui.mvi.BaseStateScreenModel

class SettingsSM: BaseStateScreenModel<HomeViewState, HomeViewAction, HomeViewEvent>(initialState = HomeViewState()) {
    override fun obtainEvent(viewEvent: HomeViewEvent) {
        when(viewEvent){
            is HomeViewEvent.OpenLesson -> viewEvent.lessonId
        }
    }
}