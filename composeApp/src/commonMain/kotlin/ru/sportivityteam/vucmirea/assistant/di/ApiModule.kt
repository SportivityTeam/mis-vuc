package ru.sportivityteam.vucmirea.assistant.di

import org.koin.dsl.module
import ru.sportivityteam.vucmirea.assistant.home.schedule.data.api.ScheduleApi

internal val apiModule = module {
    single { ScheduleApi(get()) }
}