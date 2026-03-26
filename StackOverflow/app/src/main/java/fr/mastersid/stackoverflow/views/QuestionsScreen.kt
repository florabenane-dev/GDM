package fr.mastersid.stackoverflow.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.wear.compose.material.Icon
import fr.mastersid.stackoverflow.R
import fr.mastersid.stackoverflow.viewmodel.QuestionsViewModel

@Composable
fun QuestionsScreen(
    modifier: Modifier,
    questionsViewModel: QuestionsViewModel = viewModel()
) {
    // un etat pour la checkbox, defini cm state mutable grace a remember
    // rememberSaveable conserve les modifications de l'etat lorsqu'on change la rotation ou quitte, données doivent parcelables (cm les boolean)
    var onlyNotAnsweredQuestions: Boolean by rememberSaveable { mutableStateOf(false) }

    val refreshing: Boolean by questionsViewModel.isUpdating.observeAsState(false)

    // la liste donnee en dur
    val questionsListAnsweredNotSorted by questionsViewModel.questions.observeAsState(emptyList())

    // un etat pour la liste de question
    val questionsList = if (onlyNotAnsweredQuestions) {
        questionsListAnsweredNotSorted.filter { question ->
            question.answerCount == 0
        }
    } else {
        questionsListAnsweredNotSorted
    }

    Scaffold(
        modifier = modifier,
        floatingActionButton = {
            FloatingActionButton(
                onClick = questionsViewModel::updateQuestions
            ) {
                Icon(
                    painterResource(R.drawable.baseline_refresh_24),
                    stringResource(id = R.string.refresh_button_content_description)
                )
            }
        },
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
    ) { innerPadding ->
        Box(
            modifier = Modifier.padding(innerPadding).fillMaxSize()
        ) {
            LazyColumn(
                modifier = Modifier.padding(innerPadding),
                contentPadding = PaddingValues(16.dp), //separation autour du texte
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(questionsList) { question ->
                    QuestionsRow(question)
                }

                item {
                    Spacer(modifier = Modifier.height(64.dp))
                }
            }

            if (refreshing) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }

    }
}