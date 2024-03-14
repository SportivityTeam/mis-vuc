package ru.sportivityteam.vucmirea.assistant.core.uikit.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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