package ru.sportivityteam.vucmirea.assistant.di

import org.koin.dsl.module
import ru.sportivityteam.vucmirea.assistant.auth.domain.usecase.AuthUserUseCase
import ru.sportivityteam.vucmirea.assistant.auth.domain.usecase.AuthUserUseCaseImpl
import ru.sportivityteam.vucmirea.assistant.domain.usecase.auth.GetUserLoginUseCase
import ru.sportivityteam.vucmirea.assistant.domain.usecase.auth.GetUserLoginUseCaseImpl
import ru.sportivityteam.vucmirea.assistant.auth.domain.usecase.LogoutUseCase
import ru.sportivityteam.vucmirea.assistant.auth.domain.usecase.LogoutUseCaseImpl

internal fun useCaseModule() = module {
    factory<GetUserLoginUseCase> { GetUserLoginUseCaseImpl(get()) }
    factory<AuthUserUseCase> { AuthUserUseCaseImpl(get()) }
    factory<LogoutUseCase> { LogoutUseCaseImpl(get()) }
}