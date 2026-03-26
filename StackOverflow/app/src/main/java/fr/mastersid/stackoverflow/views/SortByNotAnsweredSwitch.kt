package fr.mastersid.stackoverflow.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.mastersid.stackoverflow.R
import fr.mastersid.stackoverflow.ui.theme.StackOverflowTheme

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