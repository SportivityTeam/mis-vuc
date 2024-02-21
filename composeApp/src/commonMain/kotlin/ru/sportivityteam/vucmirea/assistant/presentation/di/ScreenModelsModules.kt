package ru.sportivityteam.vucmirea.assistant.presentation.di

import org.koin.dsl.module
import ru.sportivityteam.vucmirea.assistant.presentation.screens.auth.AuthSM
import ru.sportivityteam.vucmirea.assistant.presentation.screens.home.employee.EmployeeSM
import ru.sportivityteam.vucmirea.assistant.presentation.screens.home.info.InfoSM
import ru.sportivityteam.vucmirea.assistant.presentation.screens.home.timetable.TimetableSM
import ru.sportivityteam.vucmirea.assistant.presentation.screens.settings.SettingsSM
import ru.sportivityteam.vucmirea.assistant.presentation.screens.splash.SplashSM

internal fun screenModelsModule() = module {
    factory { SplashSM(get()) }
    factory { AuthSM(get()) }
    factory { TimetableSM() }
    factory { EmployeeSM() }
    factory { InfoSM() }
    factory { SettingsSM(get()) }
}