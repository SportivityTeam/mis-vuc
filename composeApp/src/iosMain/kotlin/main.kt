import androidx.compose.ui.window.ComposeUIViewController
import ru.sportivityteam.vucmirea.assistant.App
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController = ComposeUIViewController { App() }
