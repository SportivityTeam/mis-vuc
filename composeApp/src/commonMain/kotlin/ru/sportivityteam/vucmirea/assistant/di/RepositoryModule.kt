package ru.sportivityteam.vucmirea.assistant.di

import org.koin.dsl.module
import ru.sportivityteam.vucmirea.assistant.auth.data.AuthRepositoryImpl
import ru.sportivityteam.vucmirea.assistant.auth.domain.AuthRepository


internal fun repositoryModule() = module {
    single<AuthRepository> { AuthRepositoryImpl(get()) }
}