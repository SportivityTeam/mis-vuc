@file:Suppress("OPT_IN_USAGE")

package ru.sportivityteam.vucmirea.assistant.presentation.di

import org.koin.dsl.module
import ru.sportivityteam.vucmirea.assistant.data.repository.AuthRepositoryImpl
import ru.sportivityteam.vucmirea.assistant.domain.repository.auth.AuthRepository


internal fun repositoryModule() = module {
    single<AuthRepository> { AuthRepositoryImpl() }
}