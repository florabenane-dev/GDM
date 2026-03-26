package fr.mastersid.examflora.repository

import fr.mastersid.examflora.data.ResultsResponse
import kotlinx.coroutines.flow.Flow

interface ResultRepository {
    val resultsResponse: Flow<ResultsResponse>

    suspend fun updateResultsInfo()
}