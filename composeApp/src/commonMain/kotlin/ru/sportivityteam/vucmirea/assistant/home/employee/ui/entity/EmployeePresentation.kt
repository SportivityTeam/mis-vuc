package ru.sportivityteam.vucmirea.assistant.home.employee.ui.entity

import ru.sportivityteam.vucmirea.assistant.home.employee.domain.entity.EmployeeDomain

data class EmployeePresentation(
    override val imageUri: String,
    override val fullName: String,
    override val jobTitle: String,
    override val email: String,
    override val phone: String,
    override val phoneAdd: String,
    override val audience: String,
    override val type: String
) : EmployeeDomain


fun EmployeeDomain.toPresentation() = EmployeePresentation(
    imageUri = imageUri,
    fullName = fullName,
    jobTitle = jobTitle,
    email = email,
    phone = phone,
    phoneAdd = phoneAdd,
    audience = audience,
    type = type
)