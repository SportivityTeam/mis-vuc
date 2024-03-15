package ru.sportivityteam.vucmirea.assistant.home.schedule.ui

import cafe.adriel.voyager.core.model.screenModelScope
import kotlinx.coroutines.launch
import ru.sportivityteam.vucmirea.assistant.core.uikit.mvi.BaseStateScreenModel
import ru.sportivityteam.vucmirea.assistant.core.util.State
import ru.sportivityteam.vucmirea.assistant.home.schedule.domain.usecase.GetLessonByGroupNumberUseCase
import ru.sportivityteam.vucmirea.assistant.home.schedule.ui.entity.toPresentationModel

class TimetableSM(
    private val getLessonByGroupNumberUseCase: GetLessonByGroupNumberUseCase
) : BaseStateScreenModel<TimetableViewState, TimetableViewAction,
        TimetableViewEvent>(initialState = TimetableViewState()) {

    init {
        screenModelScope.launch {
            getLessonByGroupNumberUseCase.invoke("").collect { state ->
                when (state) {
                    is State.Loading -> viewState = viewState.copy(isLoading = true)
                    is State.Success -> {
                        val lessons = state.data!!.toPresentationModel()
                        viewState = viewState.copy(isLoading = false, lessons = lessons)
                    }

                    is State.Failed -> {}
                }
            }
        }
    }

    override fun obtainEvent(viewEvent: TimetableViewEvent) {
        viewAction = when (viewEvent) {
            is TimetableViewEvent.OpenLesson -> {
                TimetableViewAction.NavigateToLesson(viewEvent.lessonId)
            }

            is TimetableViewEvent.Clear -> null
        }
    }
}