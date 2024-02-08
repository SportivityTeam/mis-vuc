package ru.sportivityteam.vucmirea.assistant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import ru.alexgladkov.odyssey.compose.setup.OdysseyConfiguration
import ru.alexgladkov.odyssey.compose.setup.setNavigationContent
import ru.sportivityteam.vucmirea.assistant.presentation.navigation.navigationGraph


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val configuration = OdysseyConfiguration(canvas = this)
            setNavigationContent(configuration = configuration) {
                navigationGraph()
            }
        }
    }
}