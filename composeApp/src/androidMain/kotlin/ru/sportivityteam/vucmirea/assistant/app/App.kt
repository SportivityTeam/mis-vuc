package ru.sportivityteam.vucmirea.assistant.app

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import ru.sportivityteam.vucmirea.assistant.presentation.di.appModule

class AndroidApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@AndroidApp)
            androidLogger()
            modules(appModule())
        }
    }
}