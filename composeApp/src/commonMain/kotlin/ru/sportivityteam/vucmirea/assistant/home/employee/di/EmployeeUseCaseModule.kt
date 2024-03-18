package ru.sportivityteam.vucmirea.assistant.home.employee.di

import org.koin.dsl.module
import ru.sportivityteam.vucmirea.assistant.home.employee.domain.usecase.GetEmployeeUseCase
import ru.sportivityteam.vucmirea.assistant.home.employee.domain.usecase.GetEmployeeUseCaseImpl

internal val employeeUseCaseModule = module {
    single<GetEmployeeUseCase> { GetEmployeeUseCaseImpl(get()) }
}