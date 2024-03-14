package ru.sportivityteam.vucmirea.assistant.core.uikit.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.sportivityteam.vucmirea.assistant.core.uikit.theme.AppTheme
import ru.sportivityteam.vucmirea.assistant.core.uikit.theme.AssistantTheme

enum class ButtonSlot {
    /**
     * Position a slot before text
     */
    BeforeText,

    /**
     * Position a slot after text
     */
    AfterText,

    /**
     * Position a slot in the end of the text
     */
    End,

    /**
     * No slot is reserved. Icon and progress bar related arguments are ignored in this mode.
     */
    None
}

enum class ButtonSize {
    Normal,
    Medium,
    Big,
    Small,
}

@Suppress("LongMethod") // complex composable
@Composable
fun Button(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String,
    icon: @Composable (() -> Unit)? = null,
    isProgressBarVisible: Boolean = false,
    slotPosition: ButtonSlot = ButtonSlot.End,
    enabled: Boolean = true,
    size: ButtonSize = ButtonSize.Medium,
    colors: ButtonColors = ButtonDefaults.primaryButtonColors(),
    elevation: androidx.compose.material.ButtonElevation = androidx.compose.material.ButtonDefaults
        .elevation(defaultElevation = 0.dp, pressedElevation = 0.dp),
    shape: CornerBasedShape = RoundedCornerShape(24.dp),
    border: BorderStroke? = null,
) {
    return Button(
        modifier = modifier,
        onClick = onClick,
        icon = icon,
        slotPosition = slotPosition,
        isProgressBarVisible = isProgressBarVisible,
        enabled = enabled,
        size = size,
        colors = colors,
        elevation = elevation,
        shape = shape,
        border = border,
    ) {
        ButtonText(size, text)
    }
}

@Suppress("LongMethod") // complex composable
@Composable
internal fun Button(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    icon: @Composable (() -> Unit)? = null,
    isProgressBarVisible: Boolean = false,
    slotPosition: ButtonSlot = ButtonSlot.End,
    enabled: Boolean = true,
    size: ButtonSize = ButtonSize.Medium,
    colors: ButtonColors = ButtonDefaults.primaryButtonColors(),
    elevation: androidx.compose.material.ButtonElevation = androidx.compose.material.ButtonDefaults
        .elevation(defaultElevation = 0.dp, pressedElevation = 0.dp),
    shape: CornerBasedShape = RoundedCornerShape(24.dp),
    border: BorderStroke? = null,
    content: @Composable RowScope.() -> Unit,
) {
    val iconPadding = when (size) {
        ButtonSize.Normal -> 8.dp
        ButtonSize.Small -> 4.dp
        ButtonSize.Medium -> 8.dp
        ButtonSize.Big -> 8.dp
    }
    val contentPadding = when (size) {
        ButtonSize.Normal -> PaddingValues(horizontal = 16.dp, vertical = 16.dp)
        ButtonSize.Medium -> PaddingValues(horizontal = 16.dp, vertical = 14.dp)
        ButtonSize.Big -> PaddingValues(horizontal = 20.dp, vertical = 22.dp)
        ButtonSize.Small -> PaddingValues(horizontal = 12.dp, vertical = 12.dp)
    }
    androidx.compose.material.Button(
        onClick = onClick,
        modifier = modifier.heightIn(
            min = when (size) {
                ButtonSize.Normal -> 51.dp
                ButtonSize.Small -> 38.dp
                ButtonSize.Medium -> 44.dp
                ButtonSize.Big -> 64.dp
            }
        ),
        enabled = enabled,
        colors = colors,
        elevation = elevation,
        shape = shape,
        border = border,
        contentPadding = contentPadding
    ) {
        val contentColor by colors.contentColor(enabled = enabled)
        CompositionLocalProvider(LocalContentColor provides contentColor) {
            when (slotPosition) {
                ButtonSlot.None -> {
                    content()
                }

                ButtonSlot.AfterText -> {
                    content()
                    SlotContent(
                        modifier = Modifier.padding(start = iconPadding),
                        icon = icon,
                        isProgressBarVisible = isProgressBarVisible,
                    )
                }

                ButtonSlot.BeforeText -> {
                    SlotContent(
                        modifier = Modifier.padding(end = iconPadding),
                        icon = icon,
                        isProgressBarVisible = isProgressBarVisible,
                    )
                    content()
                }

                ButtonSlot.End -> {
                    // this is required to keep text horizontally centered
                    SlotContent(
                        modifier = Modifier
                            .padding(end = iconPadding)
                            .alpha(alpha = 0f),
                        icon = icon,
                        isProgressBarVisible = isProgressBarVisible,
                    )
                    Spacer(modifier = Modifier.weight(weight = 1f))
                    content()
                    Spacer(modifier = Modifier.weight(weight = 1f))
                    SlotContent(
                        modifier = Modifier.padding(start = iconPadding),
                        icon = icon,
                        isProgressBarVisible = isProgressBarVisible,
                    )
                }
            }
        }
    }
}


@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String,
    slotPosition: ButtonSlot = ButtonSlot.None,
    icon: @Composable (() -> Unit)? = null,
    isProgressBarVisible: Boolean = false,
    enabled: Boolean = true,
    size: ButtonSize = ButtonSize.Medium,
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        text = text,
        icon = icon,
        isProgressBarVisible = isProgressBarVisible,
        enabled = enabled,
        size = size,
        slotPosition = slotPosition,
        colors = ButtonDefaults.primaryButtonColors(),
    )
}

@Composable
internal fun ButtonText(
    size: ButtonSize,
    text: String,
) {
    Text(
        text = text,
        textAlign = TextAlign.Center,
        style = when (size) {
            ButtonSize.Normal -> AssistantTheme.typography.p1
            ButtonSize.Small -> AssistantTheme.typography.p3
            ButtonSize.Medium -> AssistantTheme.typography.p2
            ButtonSize.Big -> AssistantTheme.typography.h4
        },
        color = AssistantTheme.colors.white,
    )
}

@Suppress("UnusedPrivateMember") // preview
@Preview(showBackground = true, widthDp = 360)
@Composable
private fun PrimaryButtonsWrapped() {
    AppTheme {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            PrimaryButton(
                onClick = {},
                text = "Продолжить",
                slotPosition = ButtonSlot.None,
            )

            Spacer(modifier = Modifier.height(24.dp))

            PrimaryButton(
                onClick = {},
                text = "Продолжить",
                slotPosition = ButtonSlot.AfterText,
            )
            Spacer(modifier = Modifier.height(8.dp))
            PrimaryButton(
                onClick = {},
                slotPosition = ButtonSlot.AfterText,
                text = "Продолжить",
                isProgressBarVisible = true,
            )

            Spacer(modifier = Modifier.height(24.dp))

            PrimaryButton(
                onClick = {},
                text = "Продолжить",
                slotPosition = ButtonSlot.BeforeText,
            )
            Spacer(modifier = Modifier.height(8.dp))
            PrimaryButton(
                onClick = {},
                slotPosition = ButtonSlot.BeforeText,
                text = "Продолжить",
                isProgressBarVisible = true,
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Currently this renders incorrectly, but this shouldn't be used in "wrap_content mode", just use
            // ButtonSlot.AfterText
            PrimaryButton(
                onClick = {},
                text = "Продолжить",
                slotPosition = ButtonSlot.End,
            )
            Spacer(modifier = Modifier.height(8.dp))
            PrimaryButton(
                onClick = {},
                slotPosition = ButtonSlot.End,
                text = "Продолжить",
                isProgressBarVisible = true,
            )
        }
    }
}

internal object ButtonDefaults {
    @Composable
    fun primaryButtonColors(): ButtonColors {
        return ButtonColors(
            containerColor = AssistantTheme.colors.accent,
            contentColor = AssistantTheme.colors.primary,
            disabledContainerColor = AssistantTheme.colors.accentDisabled,
            disabledContentColor = AssistantTheme.colors.primary,
        )
    }
}

@Composable
private fun SlotContent(
    modifier: Modifier = Modifier,
    icon: @Composable (() -> Unit)?,
    isProgressBarVisible: Boolean,
) {
    if (icon == null && !isProgressBarVisible) {
        Box(modifier = modifier.size(18.dp))
    } else {
        Box(
            modifier = modifier,
            contentAlignment = Alignment.Center
        ) {
            if (icon != null && !isProgressBarVisible) {
                icon()
            }
            if (isProgressBarVisible) {
                CircularProgressIndicator(
                    modifier = Modifier.size(18.dp),
                    color = AssistantTheme.colors.white,
                    strokeWidth = 2.dp
                )
            }
        }
    }
}


@Immutable
data class ButtonColors(
    private val containerColor: Color,
    private val contentColor: Color,
    private val disabledContainerColor: Color,
    private val disabledContentColor: Color,
) : androidx.compose.material.ButtonColors {

    @Composable
    override fun backgroundColor(enabled: Boolean): State<Color> {
        return rememberUpdatedState(if (enabled) containerColor else disabledContainerColor)
    }

    @Composable
    override fun contentColor(enabled: Boolean): State<Color> {
        return rememberUpdatedState(if (enabled) contentColor else disabledContentColor)
    }
}