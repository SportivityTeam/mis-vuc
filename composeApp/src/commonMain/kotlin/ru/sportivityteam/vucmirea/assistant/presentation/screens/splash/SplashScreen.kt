package ru.sportivityteam.vucmirea.assistant.presentation.screens.splash

import androidx.compose.runtime.Composable
import com.adeo.kviewmodel.compose.ViewModel
import com.adeo.kviewmodel.compose.observeAsState
import ru.alexgladkov.odyssey.compose.extensions.push
import ru.alexgladkov.odyssey.compose.local.LocalRootController
import ru.sportivityteam.vucmirea.assistant.presentation.navigation.NavigationTree

@Composable
fun SplashScreen() {
    val rootController = LocalRootController.current
    ViewModel(factory = { SplashVM() }) { viewModel ->
        val viewAction = viewModel.viewActions().observeAsState()

        viewAction.value?.let { action ->
            when (action) {
                is SplashAction.navigateToAuthScreen -> rootController.push(NavigationTree.Auth.name)
                is SplashAction.navigateToHomeScreen -> rootController.push(NavigationTree.Home.name)
            }
        }

    }
}