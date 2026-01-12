package fr.mastersid.stackoverflow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import fr.mastersid.stackoverflow.data.Question
import fr.mastersid.stackoverflow.ui.theme.StackOverflowTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StackOverflowTheme {
                StackOverflowScreen(modifier = Modifier.safeDrawingPadding())
            }
        }
    }
}

@Composable
fun StackOverflowScreen(modifier: Modifier) {
    val onlyNotAnswredQuestion = remember() { mutableStateOf(false) }

    val stackOverflowNotAnswred = listOf(
        Question(0, "Find node that is connected to a node", 1),
        Question(1, "Find node that is connected to a node", 1),
        Question(2, "Find node that is connected to a node", 1),
        Question(3, "Find node that is connected to a node", 1),
        Question(4, "Find node that is connected to a node", 1),
        Question(5, "Find node that is connected to a node", 1),
        Question(6, "Find node that is connected to a node", 1),
        Question(7, "Find node that is connected to a node", 1),
        Question(8, "Find node that is connected to a node", 1),
        Question(9, "Find node that is connected to a node", 1),
        Question(10, "Find node that is connected to a node", 1),
        Question(11, "Find node that is connected to a node", 1),
        Question(12, "Find node that is connected to a node", 1),
    )
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    StackOverflowTheme {
        Greeting("Android")
    }
}