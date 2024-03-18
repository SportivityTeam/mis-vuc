package ru.sportivityteam.vucmirea.assistant.di

import ru.sportivityteam.vucmirea.assistant.auth.di.authUseCaseModule
import ru.sportivityteam.vucmirea.assistant.config.di.configUseCaseModule
import ru.sportivityteam.vucmirea.assistant.home.employee.di.employeeUseCaseModule
import ru.sportivityteam.vucmirea.assistant.home.schedule.di.scheduleUseCaseModule

internal val useCaseModule = listOf(
    authUseCaseModule,
    configUseCaseModule,
    scheduleUseCaseModule,
    employeeUseCaseModule,
)