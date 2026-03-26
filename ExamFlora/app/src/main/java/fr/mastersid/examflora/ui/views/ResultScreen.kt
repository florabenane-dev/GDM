package fr.mastersid.examflora.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Icon
import androidx.compose.material3.MultiChoiceSegmentedButtonRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import fr.mastersid.examflora.R
import androidx.lifecycle.viewmodel.compose.viewModel
import fr.mastersid.examflora.viewmodel.ResultViewModel

@Composable
fun ResultScreen(
    modifier: Modifier,
    resultResultViewModel: ResultViewModel = viewModel()
) {
    val resultList by resultResultViewModel.results.observeAsState(emptyList())

    Scaffold(
    modifier = modifier,
    floatingActionButton = {
        FloatingActionButton(
            onClick = resultResultViewModel::updateResults
        ) {
            Icon(
                painterResource(R.drawable.baseline_autorenew_24),
                stringResource(R.string.refresh_button_content_description)
            )
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
                items(resultList) { results ->
                    ResultRow(results)
                }

                item {
                    Spacer(modifier = Modifier.height(64.dp))
                }
            }
        }

    }
    
}