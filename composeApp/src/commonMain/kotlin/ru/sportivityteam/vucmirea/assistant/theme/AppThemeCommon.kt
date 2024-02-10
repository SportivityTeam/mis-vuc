package ru.sportivityteam.vucmirea.assistant.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp


data class AssistantColors(
    val primary: Color,
    val secondary: Color,
    val tertiary: Color,
    val accent: Color,
    val white: Color,
    val disable: Color,
    val secondaryText: Color,
    val accentDisabled: Color
)

data class AssistantTypography(
    val heading: TextStyle,
    val regular: TextStyle,
    val regularBold: TextStyle,
    val regularMedium: TextStyle
)

data class AssistantShape(
    val padding: Dp,
    val cornersStyle: Shape
)

object AssistnatTheme {
    internal val colors: AssistantColors
        @ReadOnlyComposable @Composable get() = LocalAssistantColors.current

    internal val typography: AssistantTypography
        @ReadOnlyComposable @Composable get() = LocalAssistantTypography.current

    internal val shape: AssistantShape
        @ReadOnlyComposable @Composable get() = LocalAssistantShape.current
}

enum class AssistantSize {
    Small, Medium, Big
}

enum class AssistantCorners {
    Flat, Rounded
}


internal val LocalAssistantColors = staticCompositionLocalOf<AssistantColors> {
    error("No colors provided")
}

internal val LocalAssistantTypography = staticCompositionLocalOf<AssistantTypography> {
    error("No fonts provided")
}

internal val LocalAssistantShape = staticCompositionLocalOf<AssistantShape> {
    error("No shapes provided")
}