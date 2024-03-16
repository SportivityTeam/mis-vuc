package ru.sportivityteam.vucmirea.assistant.di

import org.koin.dsl.module
import ru.sportivityteam.vucmirea.assistant.auth.data.AuthRepositoryImpl
import ru.sportivityteam.vucmirea.assistant.auth.domain.AuthRepository
import ru.sportivityteam.vucmirea.assistant.home.employee.data.repository.EmployeeRepositoryImpl
import ru.sportivityteam.vucmirea.assistant.home.employee.domain.repository.EmployeeRepository
import ru.sportivityteam.vucmirea.assistant.home.schedule.data.repository.ScheduleRepositoryImpl
import ru.sportivityteam.vucmirea.assistant.home.schedule.domain.repository.ScheduleRepository


internal val repositoryModule = module {
    single<AuthRepository> { AuthRepositoryImpl(get()) }
    single<ScheduleRepository> { ScheduleRepositoryImpl(get()) }
    single<EmployeeRepository> { EmployeeRepositoryImpl(get()) }
}