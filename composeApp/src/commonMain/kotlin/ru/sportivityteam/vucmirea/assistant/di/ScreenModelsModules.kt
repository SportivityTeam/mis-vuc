package ru.sportivityteam.vucmirea.assistant.di

import org.koin.dsl.module
import ru.sportivityteam.vucmirea.assistant.auth.ui.AuthSM
import ru.sportivityteam.vucmirea.assistant.home.employee.ui.EmployeeSM
import ru.sportivityteam.vucmirea.assistant.home.info.ui.InfoSM
import ru.sportivityteam.vucmirea.assistant.home.schedule.ui.TimetableSM
import ru.sportivityteam.vucmirea.assistant.lesson.ui.LessonSM
import ru.sportivityteam.vucmirea.assistant.settings.ui.SettingsSM
import ru.sportivityteam.vucmirea.assistant.splash.ui.SplashSM

internal val screenModelsModule = module {
    factory { SplashSM(get()) }
    factory { AuthSM(get()) }
    factory { TimetableSM(get()) }
    factory { EmployeeSM() }
    factory { InfoSM() }
    factory { SettingsSM(get()) }
    factory { LessonSM() }
}