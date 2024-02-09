package ru.sportivityteam.vucmirea.assistant.presentation.di

import org.koin.dsl.module
import ru.sportivityteam.vucmirea.assistant.domain.usecase.auth.GetUserLoginUseCase
import ru.sportivityteam.vucmirea.assistant.domain.usecase.auth.GetUserLoginUseCaseImpl

internal fun useCaseModule() = module {
    factory<GetUserLoginUseCase> { GetUserLoginUseCaseImpl(get()) }
}