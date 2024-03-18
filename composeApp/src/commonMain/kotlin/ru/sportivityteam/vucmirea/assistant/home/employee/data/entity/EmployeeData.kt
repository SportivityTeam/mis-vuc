package ru.sportivityteam.vucmirea.assistant.home.employee.data.entity

import kotlinx.serialization.Serializable
import ru.sportivityteam.vucmirea.assistant.home.employee.domain.entity.EmployeeDomain

@Serializable
data class EmployeeData(
    override val id: String,
    override val imageUri: String,
    override val fullName: String,
    override val jobTitle: String,
    override val email: String,
    override val phone: String,
    override val phoneAdd: String,
    override val audience: String,
    override val type: String
) : EmployeeDomain