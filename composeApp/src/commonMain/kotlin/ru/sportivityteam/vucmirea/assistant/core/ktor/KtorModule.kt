package ru.sportivityteam.vucmirea.assistant.core.ktor

import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.resources.Resources
import io.ktor.http.HttpHeaders
import io.ktor.serialization.gson.gson
import org.koin.dsl.module

internal val ktorModule = module {
    single<HttpClient> {
        HttpClient {
            install(ContentNegotiation) {
                gson()
            }

            install(Logging){
                logger = Logger.DEFAULT
                level = LogLevel.HEADERS
                filter { request ->
                    request.url.host.contains("ktor.io")
                }
            }

            install(Resources)

            install(HttpTimeout) {
                connectTimeoutMillis = 15000
                requestTimeoutMillis = 30000
            }

            defaultRequest {
                // TODO: ЗАМЕНИМТЬ НА РЕЛИЗ
                url("http://10.0.2.2:8080/")
            }
        }
    }
}