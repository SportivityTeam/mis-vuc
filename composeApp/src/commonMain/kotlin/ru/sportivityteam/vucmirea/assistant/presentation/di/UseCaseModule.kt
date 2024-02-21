package ru.sportivityteam.vucmirea.assistant.presentation.di

import org.koin.dsl.module
import ru.sportivityteam.vucmirea.assistant.domain.usecase.auth.AuthUserUseCase
import ru.sportivityteam.vucmirea.assistant.domain.usecase.auth.AuthUserUseCaseImpl
import ru.sportivityteam.vucmirea.assistant.domain.usecase.auth.GetUserLoginUseCase
import ru.sportivityteam.vucmirea.assistant.domain.usecase.auth.GetUserLoginUseCaseImpl
import ru.sportivityteam.vucmirea.assistant.domain.usecase.auth.LogoutUseCase
import ru.sportivityteam.vucmirea.assistant.domain.usecase.auth.LogoutUseCaseImpl

internal fun useCaseModule() = module {
    factory<GetUserLoginUseCase> { GetUserLoginUseCaseImpl(get()) }
    factory<AuthUserUseCase> { AuthUserUseCaseImpl(get()) }
    factory<LogoutUseCase> { LogoutUseCaseImpl(get()) }
}