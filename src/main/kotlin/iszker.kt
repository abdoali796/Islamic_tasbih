import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
@Preview
fun zeker(
    zk: String,
    target: Int
) {
    val targetFloat = 1 / target.toFloat()
    var namber by remember { mutableStateOf(0f) }
    val numbers: Float by animateFloatAsState(namber)
    val color: Color by animateColorAsState(if (namber >= 1f) Color.Green else MaterialTheme.colors.primary)
    var nambe by remember { mutableStateOf(0) }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(10.dp)
            .border(width = 1.dp, color = Color.Black, shape = MaterialTheme.shapes.medium).padding(10.dp)
    ) {
        CircularProgressIndicator(progress = numbers, color = color, modifier = Modifier.size(100.dp))
        Text("$nambe / $target")
        Button(
            onClick = {
                namber += targetFloat
                nambe += 1
            },
            colors = ButtonDefaults.buttonColors(color),
        ) {

            Text(zk)
        }

        IconButton(
            onClick = ({
                namber = 0f
                nambe = 0
            }),
//            modifier = Modifier.size( height = 10.dp , width = ButtonDefaults.MinWidth)
        ) {
            Icon(Icons.Default.Refresh, null)
        }


    }
}