package fr.mastersid.examflora.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import fr.mastersid.examflora.R
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fr.mastersid.examflora.data.Results
import fr.mastersid.examflora.ui.theme.ExamFloraTheme

@Composable
fun ResultRow(
    result: Results
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp) //espace entre les elts
    ) {
        //nom
        Text(
            text = result.libelleAcademique,
            maxLines = 1, //pas de retour à la ligne
            overflow = TextOverflow.Ellipsis, //pointillés finaux si text trop long
            style = MaterialTheme.typography.titleLarge //style
        )

        //discipline
        Text(
            text = result.discipline,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.titleLarge
        )

        //capacite
        Text(
//            text = stringResource(id = R.string.competences, result.competence.first()),
            text = result.competence,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            fontSize = 16.sp
        )

        //taux
        Text(
            text = stringResource(id = R.string.taux, result.taux),
            style = MaterialTheme.typography.displaySmall
        )
    }

}

@Preview(showBackground = true)
@Composable
fun ResultRowPreview() {
    ExamFloraTheme {
        ResultRow(
            Results(
                "absced",
                "REUNION",
                "Français",
                "Manipuler les syllabes",
                80))
    }
}