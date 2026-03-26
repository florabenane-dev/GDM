package fr.mastersid.stackoverflow.Repository

import android.util.Log
import fr.mastersid.stackoverflow.data.QuestionsResponse
import fr.mastersid.stackoverflow.webservice.StackWebService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import java.io.IOException
import java.text.Normalizer
import javax.inject.Inject

class SlackOverflowRepositoryImpl @Inject constructor(
    private val stackWebService: StackWebService,
): SlackOverflowRepository {
    override val questionsResponse = MutableSharedFlow<QuestionsResponse>()
    override suspend fun updateQuestionsInfo() {
        try {
            questionsResponse.emit(QuestionsResponse.Pending)

            val list = stackWebService.getQuestionsList()
            questionsResponse.emit(QuestionsResponse
                .Success(list
                    .distinctBy { question ->
                        question.id
                    }
                )
            )

            Log.d("Webservice", "Response: $list")
        } catch (e: IOException) {
            Log.d("Webservice", "Exception: $e")
        }
    }

}