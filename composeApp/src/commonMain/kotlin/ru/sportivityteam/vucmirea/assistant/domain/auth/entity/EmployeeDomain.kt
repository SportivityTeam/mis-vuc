package ru.sportivityteam.vucmirea.assistant.domain.auth.entity

interface EmployeeDomain {
    val imageUri: String
    val fullName: String
    val jobTitle: String
    val email: String
    val phone: String
    val phoneAdd: String
    val audience: String
    val type: String
}