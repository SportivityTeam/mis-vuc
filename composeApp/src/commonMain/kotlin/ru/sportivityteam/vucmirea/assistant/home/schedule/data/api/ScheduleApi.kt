package ru.sportivityteam.vucmirea.assistant.home.schedule.data.api

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

import ru.sportivityteam.vucmirea.assistant.home.schedule.data.entity.LessonsData

class ScheduleApi(private val httpClient: HttpClient) {

    suspend fun getLessonsByGroupId(): LessonsData {
        return httpClient.get("/lessons").body<LessonsData>()
    }
}