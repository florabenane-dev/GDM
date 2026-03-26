package fr.mastersid.examflora.repository

import android.util.Log
import fr.mastersid.examflora.data.ResultsResponse
import fr.mastersid.examflora.webservice.ResultWebservice
import kotlinx.coroutines.flow.MutableSharedFlow
import java.io.IOException
import javax.inject.Inject

class ResultRepositoryImpl @Inject constructor(
    private val resultWebservice: ResultWebservice
): ResultRepository {

    override val resultsResponse = MutableSharedFlow<ResultsResponse>()
    override suspend fun updateResultsInfo() {
        try {
            resultsResponse.emit(ResultsResponse.Pending)

            val list = resultWebservice.getResultsList()
            resultsResponse.emit(ResultsResponse
                .Success(list
                    .distinctBy { results ->
                        results.id
                    }
                )
            )

            Log.d("Webservice", "Response: $list")
        } catch (e: IOException) {
            Log.d("Webservice", "Exception: $e")
        }
    }

}