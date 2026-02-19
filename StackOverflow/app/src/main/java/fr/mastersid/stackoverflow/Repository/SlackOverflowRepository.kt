package fr.mastersid.stackoverflow.Repository

import fr.mastersid.stackoverflow.data.QuestionsResponse
import kotlinx.coroutines.flow.Flow

interface SlackOverflowRepository {

    val questionsResponse: Flow<QuestionsResponse>

    suspend fun updateQuestionsInfo()
}