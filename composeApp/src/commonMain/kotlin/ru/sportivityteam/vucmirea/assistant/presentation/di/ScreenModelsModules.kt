package ru.sportivityteam.vucmirea.assistant.presentation.di

import org.koin.dsl.module
import ru.sportivityteam.vucmirea.assistant.presentation.screens.auth.AuthSM
import ru.sportivityteam.vucmirea.assistant.presentation.screens.splash.SplashSM

internal fun screenModelsModule() = module {
    factory { SplashSM(get()) }
    factory { AuthSM(get()) }
}