package ru.sportivityteam.vucmirea.assistant.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.sogya.projects.activity_and_charity.ui.theme.AssistantColors
import ru.sogya.projects.activity_and_charity.ui.theme.AssistantCorners
import ru.sogya.projects.activity_and_charity.ui.theme.AssistantShape
import ru.sogya.projects.activity_and_charity.ui.theme.AssistantSize
import ru.sogya.projects.activity_and_charity.ui.theme.AssistantTypography
import ru.sogya.projects.activity_and_charity.ui.theme.LocalAssistantColors
import ru.sogya.projects.activity_and_charity.ui.theme.LocalAssistantShape
import ru.sogya.projects.activity_and_charity.ui.theme.LocalAssistantTypography
import ru.sportivityteam.vucmirea.assistant.MR

@Composable
internal fun AppTheme(
    textSize: AssistantSize = AssistantSize.Medium,
    paddingSize: AssistantSize = AssistantSize.Medium,
    corners: AssistantCorners = AssistantCorners.Rounded,
    content: @Composable () -> Unit
) {

    val colors = basePalette

    val typography = AssistantTypography(
        heading = TextStyle(
            fontSize = when (textSize) {
                AssistantSize.Small -> 18.sp
                AssistantSize.Medium -> 20.sp
                AssistantSize.Big -> 22.sp
            },
            fontWeight = FontWeight.Normal,
                fontFamily = FontFamily(Font(MR.fonts.roboto_regular.fontResourceId))
        ),
        regular = TextStyle(
            fontSize = when (textSize) {
                AssistantSize.Small -> 12.sp
                AssistantSize.Medium -> 14.sp
                AssistantSize.Big -> 16.sp
            },
            fontWeight = FontWeight.Normal,
            fontFamily = FontFamily(Font(MR.fonts.roboto_regular.fontResourceId))
        ),
        regularBold = TextStyle(
            fontSize = when (textSize) {
                AssistantSize.Small -> 12.sp
                AssistantSize.Medium -> 14.sp
                AssistantSize.Big -> 16.sp
            },
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily(Font(MR.fonts.roboto_bold.fontResourceId))
        ),
        regularMedium = TextStyle(
            fontSize = when (textSize) {
                AssistantSize.Small -> 12.sp
                AssistantSize.Medium -> 14.sp
                AssistantSize.Big -> 16.sp
            },
            fontWeight = FontWeight.Medium,
            fontFamily = FontFamily(Font(MR.fonts.roboto_medium.fontResourceId))
        )
    )

    val shapes = AssistantShape(
        padding = when (paddingSize) {
            AssistantSize.Small -> 12.dp
            AssistantSize.Medium -> 16.dp
            AssistantSize.Big -> 20.dp
        },
        cornersStyle = when (corners) {
            AssistantCorners.Flat -> RoundedCornerShape(0.dp)
            AssistantCorners.Rounded -> RoundedCornerShape(16.dp)
        }
    )

    CompositionLocalProvider(
        LocalAssistantColors provides colors,
        LocalAssistantTypography provides typography,
        LocalAssistantShape provides shapes,
        content = content
    )
}

object AppTheme {
    val colors: AssistantColors
        @Composable
        @ReadOnlyComposable
        get() = LocalAssistantColors.current

    val typography: AssistantTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalAssistantTypography.current
}

//
//@Composable
//fun AppTheme(
//    useDarkTheme: Boolean = true,
//    typography: AppTypography = AppTheme.typography,
//    content: @Composable () -> Unit,
//) {
//    val colors = basePalette
//    MaterialTheme(
//        colorScheme = debugColors(),
//        typography = MaterialTypography,
//    ) {
//        CompositionLocalProvider(
//            LocalAppTypography provides typography,
//            LocalContentColor provides colors.darkBlue,
//            content = content,
//        )
//    }
//}
//
//object AppTheme {
//    val colors: AppColors
//        @Composable
//        @ReadOnlyComposable
//        get() = LocalAppColors.current
//
//    val typography: AppTypography
//        @Composable
//        @ReadOnlyComposable
//        get() = LocalAppTypography.current
//}
//
//fun debugColors() = Colors(
//    primary = DebugColor,
//    primaryVariant = DebugColor,
//    secondary = DebugColor,
//    secondaryVariant = DebugColor,
//    background = DebugColor,
//    surface = DebugColor,
//    error = DebugColor,
//    onPrimary = DebugColor,
//    onSecondary = DebugColor,
//    onBackground = DebugColor,
//    onSurface = DebugColor,
//    onError = DebugColor,
//)
//
//private val DebugColor = Color.Magenta