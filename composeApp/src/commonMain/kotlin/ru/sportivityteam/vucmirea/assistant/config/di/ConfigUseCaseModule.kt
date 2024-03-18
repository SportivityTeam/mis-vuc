package ru.sportivityteam.vucmirea.assistant.config.di

import org.koin.dsl.module
import ru.sportivityteam.vucmirea.assistant.config.domain.usecase.ConfigAppUseCase
import ru.sportivityteam.vucmirea.assistant.config.domain.usecase.ConfigAppUseCaseImpl

internal val configUseCaseModule = module {
    factory<ConfigAppUseCase> { ConfigAppUseCaseImpl(get()) }
}