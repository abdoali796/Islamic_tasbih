import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

@Composable
@Preview
fun App() {


    MaterialTheme {
        val pattern = remember { Regex("^\\d+\$") }

        var number by remember { mutableStateOf("33") }

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Row {
                TextField(
                    value = number.toString(),
                    onValueChange = { if (it.isEmpty() || it.matches(pattern)) number = it },
                    label = { Text("target") },
                    isError = number == "",
                    shape = MaterialTheme.shapes.large,


                    )

            }

            Row {
                zeker("سبحان الله", number.toIntS())
                zeker("الحمد الله", number.toIntS())
                zeker("الله اكبر", number.toIntS())
                zeker("لا اله الا الله", number.toIntS())
                zeker(" استغفر الله", number.toIntS())
            }

        }
    }
}

private fun String.toIntS(): Int {
    try {
        return this.toInt()
    } catch (e: Exception) {
        return 0
    }
}

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "abdoali",
    ) {
        App()
    }
}
