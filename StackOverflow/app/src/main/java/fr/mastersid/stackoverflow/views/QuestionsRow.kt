package fr.mastersid.stackoverflow.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fr.mastersid.stackoverflow.R
import fr.mastersid.stackoverflow.data.Question

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