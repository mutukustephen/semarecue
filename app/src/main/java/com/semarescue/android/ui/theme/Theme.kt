package com.semarescue.android.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = Red80,
    onPrimary = Grey10,
    primaryContainer = Red40,
    onPrimaryContainer = Grey99,
    secondary = Blue80,
    onSecondary = Grey10,
    secondaryContainer = Blue40,
    onSecondaryContainer = Grey99,
    tertiary = Amber80,
    onTertiary = Grey10,
    tertiaryContainer = Amber40,
    onTertiaryContainer = Grey99,
    error = Red80,
    onError = Grey10,
    errorContainer = Red20,
    onErrorContainer = Grey99,
    background = Grey10,
    onBackground = Grey90,
    surface = Grey20,
    onSurface = Grey90,
    surfaceVariant = Grey20,
    onSurfaceVariant = Grey90,
    outline = Grey90
)

private val LightColorScheme = lightColorScheme(
    primary = Red40,
    onPrimary = Grey99,
    primaryContainer = Red80,
    onPrimaryContainer = Grey10,
    secondary = Blue40,
    onSecondary = Grey99,
    secondaryContainer = Blue80,
    onSecondaryContainer = Grey10,
    tertiary = Amber40,
    onTertiary = Grey99,
    tertiaryContainer = Amber80,
    onTertiaryContainer = Grey10,
    error = Red40,
    onError = Grey99,
    errorContainer = Red80,
    onErrorContainer = Grey10,
    background = Grey99,
    onBackground = Grey10,
    surface = Grey95,
    onSurface = Grey10,
    surfaceVariant = Grey90,
    onSurfaceVariant = Grey20,
    outline = Grey20
)

@Composable
fun SemaRescueTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
