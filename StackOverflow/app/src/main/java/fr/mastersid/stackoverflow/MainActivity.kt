package fr.mastersid.stackoverflow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
//import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material.Icon
import fr.mastersid.stackoverflow.data.Question
import fr.mastersid.stackoverflow.ui.theme.StackOverflowTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StackOverflowTheme {
                QuestionsScreen(modifier = Modifier.fillMaxSize())
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
    val questionsListAnswered = listOf(
        Question(
            0, "Find node that is connected to a node", 1,
            body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas non eros non eros pulvinar ornare ut varius ante. Morbi molestie, dolor ac laoreet efficitur, erat orci mollis felis, ut finibus lectus dui sit amet nisl. Maecenas tincidunt hendrerit placerat. Aliquam ornare velit id maximus sollicitudin. Proin nisl sem, scelerisque eget fermentum eu, cursus eget ligula. Integer vel velit gravida, ultrices leo ac, vehicula nisi. Ut blandit lectus pellentesque erat luctus consequat. Curabitur lorem velit, venenatis rhoncus nunc nec, commodo ultricies elit. Morbi blandit odio et tincidunt rhoncus. Nunc et metus maximus, elementum enim quis, eleifend urna. Nulla aliquam odio sit amet tellus gravida rhoncus. "
        ),
        Question(
            1, "pdfjsLib not initializing and is undefined", 2,
            body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas non eros non eros pulvinar ornare ut varius ante. Morbi molestie, dolor ac laoreet efficitur, erat orci mollis felis, ut finibus lectus dui sit amet nisl. Maecenas tincidunt hendrerit placerat. Aliquam ornare velit id maximus sollicitudin. Proin nisl sem, scelerisque eget fermentum eu, cursus eget ligula. Integer vel velit gravida, ultrices leo ac, vehicula nisi. Ut blandit lectus pellentesque erat luctus consequat. Curabitur lorem velit, venenatis rhoncus nunc nec, commodo ultricies elit. Morbi blandit odio et tincidunt rhoncus. Nunc et metus maximus, elementum enim quis, eleifend urna. Nulla aliquam odio sit amet tellus gravida rhoncus. "
        ),
        Question(
            2, "Error while building bundle in maven", 2,
            body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas non eros non eros pulvinar ornare ut varius ante. Morbi molestie, dolor ac laoreet efficitur, erat orci mollis felis, ut finibus lectus dui sit amet nisl. Maecenas tincidunt hendrerit placerat. Aliquam ornare velit id maximus sollicitudin. Proin nisl sem, scelerisque eget fermentum eu, cursus eget ligula. Integer vel velit gravida, ultrices leo ac, vehicula nisi. Ut blandit lectus pellentesque erat luctus consequat. Curabitur lorem velit, venenatis rhoncus nunc nec, commodo ultricies elit. Morbi blandit odio et tincidunt rhoncus. Nunc et metus maximus, elementum enim quis, eleifend urna. Nulla aliquam odio sit amet tellus gravida rhoncus. "
        ),
        Question(
            3, "Translation of Bangladesh currency to words", 2,
            body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas non eros non eros pulvinar ornare ut varius ante. Morbi molestie, dolor ac laoreet efficitur, erat orci mollis felis, ut finibus lectus dui sit amet nisl. Maecenas tincidunt hendrerit placerat. Aliquam ornare velit id maximus sollicitudin. Proin nisl sem, scelerisque eget fermentum eu, cursus eget ligula. Integer vel velit gravida, ultrices leo ac, vehicula nisi. Ut blandit lectus pellentesque erat luctus consequat. Curabitur lorem velit, venenatis rhoncus nunc nec, commodo ultricies elit. Morbi blandit odio et tincidunt rhoncus. Nunc et metus maximus, elementum enim quis, eleifend urna. Nulla aliquam odio sit amet tellus gravida rhoncus. "
        ),
        Question(
            4, "How to get update history of application installed on the Android platform", 1,
            body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas non eros non eros pulvinar ornare ut varius ante. Morbi molestie, dolor ac laoreet efficitur, erat orci mollis felis, ut finibus lectus dui sit amet nisl. Maecenas tincidunt hendrerit placerat. Aliquam ornare velit id maximus sollicitudin. Proin nisl sem, scelerisque eget fermentum eu, cursus eget ligula. Integer vel velit gravida, ultrices leo ac, vehicula nisi. Ut blandit lectus pellentesque erat luctus consequat. Curabitur lorem velit, venenatis rhoncus nunc nec, commodo ultricies elit. Morbi blandit odio et tincidunt rhoncus. Nunc et metus maximus, elementum enim quis, eleifend urna. Nulla aliquam odio sit amet tellus gravida rhoncus. "
        ),
        Question(
            5,
            "Why does a floating-point multiplication compile more efficiently when I put it in an inline function?", 3,
            body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas non eros non eros pulvinar ornare ut varius ante. Morbi molestie, dolor ac laoreet efficitur, erat orci mollis felis, ut finibus lectus dui sit amet nisl. Maecenas tincidunt hendrerit placerat. Aliquam ornare velit id maximus sollicitudin. Proin nisl sem, scelerisque eget fermentum eu, cursus eget ligula. Integer vel velit gravida, ultrices leo ac, vehicula nisi. Ut blandit lectus pellentesque erat luctus consequat. Curabitur lorem velit, venenatis rhoncus nunc nec, commodo ultricies elit. Morbi blandit odio et tincidunt rhoncus. Nunc et metus maximus, elementum enim quis, eleifend urna. Nulla aliquam odio sit amet tellus gravida rhoncus. "
        ),
        Question(
            6, "Get a single data entry from a custom database table in WordPress?", 0,
            body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas non eros non eros pulvinar ornare ut varius ante. Morbi molestie, dolor ac laoreet efficitur, erat orci mollis felis, ut finibus lectus dui sit amet nisl. Maecenas tincidunt hendrerit placerat. Aliquam ornare velit id maximus sollicitudin. Proin nisl sem, scelerisque eget fermentum eu, cursus eget ligula. Integer vel velit gravida, ultrices leo ac, vehicula nisi. Ut blandit lectus pellentesque erat luctus consequat. Curabitur lorem velit, venenatis rhoncus nunc nec, commodo ultricies elit. Morbi blandit odio et tincidunt rhoncus. Nunc et metus maximus, elementum enim quis, eleifend urna. Nulla aliquam odio sit amet tellus gravida rhoncus. "
        ),
        Question(
            7, "Dynamic Array searchable Data Validation", 0,
            body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas non eros non eros pulvinar ornare ut varius ante. Morbi molestie, dolor ac laoreet efficitur, erat orci mollis felis, ut finibus lectus dui sit amet nisl. Maecenas tincidunt hendrerit placerat. Aliquam ornare velit id maximus sollicitudin. Proin nisl sem, scelerisque eget fermentum eu, cursus eget ligula. Integer vel velit gravida, ultrices leo ac, vehicula nisi. Ut blandit lectus pellentesque erat luctus consequat. Curabitur lorem velit, venenatis rhoncus nunc nec, commodo ultricies elit. Morbi blandit odio et tincidunt rhoncus. Nunc et metus maximus, elementum enim quis, eleifend urna. Nulla aliquam odio sit amet tellus gravida rhoncus. "
        ),
        Question(
            8, "ReferenceError: HTMLElement is not defined in TypeScript", 2,
            body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas non eros non eros pulvinar ornare ut varius ante. Morbi molestie, dolor ac laoreet efficitur, erat orci mollis felis, ut finibus lectus dui sit amet nisl. Maecenas tincidunt hendrerit placerat. Aliquam ornare velit id maximus sollicitudin. Proin nisl sem, scelerisque eget fermentum eu, cursus eget ligula. Integer vel velit gravida, ultrices leo ac, vehicula nisi. Ut blandit lectus pellentesque erat luctus consequat. Curabitur lorem velit, venenatis rhoncus nunc nec, commodo ultricies elit. Morbi blandit odio et tincidunt rhoncus. Nunc et metus maximus, elementum enim quis, eleifend urna. Nulla aliquam odio sit amet tellus gravida rhoncus. "
        ),
        Question(
            9, "Passing record id into a Bootstrap modal so modal file download button works", 0,
            body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas non eros non eros pulvinar ornare ut varius ante. Morbi molestie, dolor ac laoreet efficitur, erat orci mollis felis, ut finibus lectus dui sit amet nisl. Maecenas tincidunt hendrerit placerat. Aliquam ornare velit id maximus sollicitudin. Proin nisl sem, scelerisque eget fermentum eu, cursus eget ligula. Integer vel velit gravida, ultrices leo ac, vehicula nisi. Ut blandit lectus pellentesque erat luctus consequat. Curabitur lorem velit, venenatis rhoncus nunc nec, commodo ultricies elit. Morbi blandit odio et tincidunt rhoncus. Nunc et metus maximus, elementum enim quis, eleifend urna. Nulla aliquam odio sit amet tellus gravida rhoncus. "
        ),
        Question(
            10, "How to make a structuredClone of a Proxy object?", 4,
            body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas non eros non eros pulvinar ornare ut varius ante. Morbi molestie, dolor ac laoreet efficitur, erat orci mollis felis, ut finibus lectus dui sit amet nisl. Maecenas tincidunt hendrerit placerat. Aliquam ornare velit id maximus sollicitudin. Proin nisl sem, scelerisque eget fermentum eu, cursus eget ligula. Integer vel velit gravida, ultrices leo ac, vehicula nisi. Ut blandit lectus pellentesque erat luctus consequat. Curabitur lorem velit, venenatis rhoncus nunc nec, commodo ultricies elit. Morbi blandit odio et tincidunt rhoncus. Nunc et metus maximus, elementum enim quis, eleifend urna. Nulla aliquam odio sit amet tellus gravida rhoncus. "
        ),
        Question(
            11, "GCC warning: how to ignore -Wswitch-default on enum", 1,
            body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas non eros non eros pulvinar ornare ut varius ante. Morbi molestie, dolor ac laoreet efficitur, erat orci mollis felis, ut finibus lectus dui sit amet nisl. Maecenas tincidunt hendrerit placerat. Aliquam ornare velit id maximus sollicitudin. Proin nisl sem, scelerisque eget fermentum eu, cursus eget ligula. Integer vel velit gravida, ultrices leo ac, vehicula nisi. Ut blandit lectus pellentesque erat luctus consequat. Curabitur lorem velit, venenatis rhoncus nunc nec, commodo ultricies elit. Morbi blandit odio et tincidunt rhoncus. Nunc et metus maximus, elementum enim quis, eleifend urna. Nulla aliquam odio sit amet tellus gravida rhoncus. "
        ),
        Question(
            12, "Create structured clone of Proxy", 1,
            body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas non eros non eros pulvinar ornare ut varius ante. Morbi molestie, dolor ac laoreet efficitur, erat orci mollis felis, ut finibus lectus dui sit amet nisl. Maecenas tincidunt hendrerit placerat. Aliquam ornare velit id maximus sollicitudin. Proin nisl sem, scelerisque eget fermentum eu, cursus eget ligula. Integer vel velit gravida, ultrices leo ac, vehicula nisi. Ut blandit lectus pellentesque erat luctus consequat. Curabitur lorem velit, venenatis rhoncus nunc nec, commodo ultricies elit. Morbi blandit odio et tincidunt rhoncus. Nunc et metus maximus, elementum enim quis, eleifend urna. Nulla aliquam odio sit amet tellus gravida rhoncus. "
        ),
    )

    // un etat pour la liste de question
    val questionsList = if (onlyNotAnsweredQuestions) {
        questionsListAnswered.filter { question ->
            question.answerCount == 0
        }
    } else {
        questionsListAnswered
    }

    Scaffold(
        modifier = modifier,
        bottomBar = {
            SortByNotAnsweredSwitch(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .padding(bottom = WindowInsets.safeDrawing //ajout de la marge
                        .asPaddingValues()
                        .calculateBottomPadding()
                    ),
                onlyNotAnsweredQuestions = onlyNotAnsweredQuestions
            ) {
                checked ->
                onlyNotAnsweredQuestions = checked
            }
        }
        floatingActionButton = {
            FloatingActionButton(
//                onClick =
            ) {
                Icon(
                    painterRessource(R.drawable.baseline_refresh_24),
                    stringResource(id = R.string.refresh_button_content_description)
                )
            }
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding).fillMaxSize()){
            LazyColumn(
                modifier = Modifier.padding(innerPadding),
                contentPadding = PaddingValues(16.dp), //separation autour du texte
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(questionsList) { question ->
                    QuestionsRow(question)
                }
            }

            if (refreshing) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }

    }
}

@Composable
fun QuestionsRow(question: Question) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp) //espace entre les elts
    ) {
        Column(
            modifier = Modifier.weight(1f) //prend le max de place
        ) {
            //titre
            Text(
                text = question.title,
                maxLines = 1, //pas de retour à la ligne
                overflow = TextOverflow.Ellipsis, //pointillés finaux si text trop long
                style = MaterialTheme.typography.headlineSmall //style
            )

            //corps de la question
            Text(
                text = question.body,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                fontSize = 16.sp
            )
        }

        //nombres de réponse
        Text(
            text = stringResource(id = R.string.answer_count, question.answerCount),
            style = MaterialTheme.typography.displaySmall
        )
    }
}

@Composable
fun SortByNotAnsweredSwitch(modifier: Modifier, onlyNotAnsweredQuestions: Boolean, onChange: (Boolean) -> Unit) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Switch(
            checked =  onlyNotAnsweredQuestions,
            onCheckedChange = onChange
        )
        Text(stringResource(id = R.string.only_not_answered_questions))
    }
}

//prévisualisation
@Preview(widthDp = 400)
@Composable
fun SortByNotAnsweredSwitchPreview() {
    StackOverflowTheme {
        SortByNotAnsweredSwitch(
            modifier = Modifier.padding(horizontal = 16.dp),
            onlyNotAnsweredQuestions = true
        ) { }
    }
}
