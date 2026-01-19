package fr.mastersid.stackoverflow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import fr.mastersid.stackoverflow.data.Question
import fr.mastersid.stackoverflow.ui.theme.StackOverflowTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StackOverflowTheme {
                QuestionsScreen(modifier = Modifier.safeDrawingPadding())
            }
        }
    }
}

@Composable
fun QuestionsScreen(modifier: Modifier) {
    // un etat pour la checkbox, defini cm state mutable grace a remember
    // rememberSaveable conserve les modifications de l'etat lorsqu'on change la rotation ou quitte, données doivent parcelables (cm les boolean)
    var onlyNotAnsweredQuestions: Boolean by rememberSaveable { mutableStateOf(false) }

    // la liste donnee en dur
    val questionsAnswered = listOf(
        Question(0, "Find node that is connected to a node", 1),
        Question(1, "pdfjsLib not initializing and is undefined", 2),
        Question(2, "Error while building bundle in maven", 2),
        Question(3, "Translation of Bangladesh currency to words", 2),
        Question(4, "How to get update history of application installed on the Android platform", 1),
        Question(5, "Why does a floating-point multiplication compile more efficiently when I put it in an inline function?", 3),
        Question(6, "Get a single data entry from a custom database table in WordPress?", 0),
        Question(7, "Dynamic Array searchable Data Validation", 0),
        Question(8, "ReferenceError: HTMLElement is not defined in TypeScript", 2),
        Question(9, "Passing record id into a Bootstrap modal so modal file download button works", 0),
        Question(10, "How to make a structuredClone of a Proxy object?", 4),
        Question(11, "GCC warning: how to ignore -Wswitch-default on enum", 1),
        Question(12, "Create structured clone of Proxy", 1),
    )

    // un etat pour la liste de question
    val questionsList = if (onlyNotAnsweredQuestions) {
        questionsAnswered.sortedBy { question -> question.answerCount == 0 }
    } else {
        questionsAnswered
    }

    Scaffold(
        modifier = modifier,
        bottomBar = {
            Row() {
                Switch(
                    checked = onlyNotAnsweredQuestions
                    onCheckedChange = { checked -> onlyNotAnsweredQuestions = checked }
                )
                Text(
                    stringResource(id = R.string.only_not_answered_questions)
                )
            }
        }
    ) { innerPadding ->
        LazyColumn(


        ) {
            items(questionsList) { question -> QuestionsRow(question)}
        }
    }
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