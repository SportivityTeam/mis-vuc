package ru.sportivityteam.vucmirea.assistant.home.employee.data.mapper

import ru.sportivityteam.vucmirea.assistant.home.employee.data.entity.EmployeeData
import rusportivityteamvucmireaassistantcoredatabase.Employee

internal fun EmployeeData.toStorageModel(): Employee = Employee(
    id = id,
    imageUri = imageUri,
    fullName = fullName,
    jobTitle = jobTitle,
    email = email,
    phone = phone,
    phoneAdd = phoneAdd,
    audience = audience,
    type = type
)

internal fun Employee.toDataModel(): EmployeeData = EmployeeData(
    id = id,
    imageUri = imageUri,
    fullName = fullName,
    jobTitle = jobTitle,
    email = email,
    phone = phone,
    phoneAdd = phoneAdd,
    audience = audience,
    type = type
)

internal fun List<Employee>.toDataModelList(): List<EmployeeData> {
    return this.map {
        it.toDataModel()
    }
}