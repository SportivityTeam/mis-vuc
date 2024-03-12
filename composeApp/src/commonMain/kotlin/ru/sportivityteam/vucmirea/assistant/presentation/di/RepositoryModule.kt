package ru.sportivityteam.vucmirea.assistant.presentation.di

import org.koin.dsl.module
import ru.sportivityteam.vucmirea.assistant.data.auth.repository.AuthRepositoryImpl
import ru.sportivityteam.vucmirea.assistant.domain.auth.repository.AuthRepository


internal fun repositoryModule() = module {
    single<AuthRepository> { AuthRepositoryImpl(get()) }
}