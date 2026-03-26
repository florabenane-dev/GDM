package fr.mastersid.stackoverflow.data

sealed interface QuestionsResponse {
    data object Pending: QuestionsResponse //en attente de réponse

    @JvmInline
    value class Success(val list: List<Question>): QuestionsResponse //liste de questions
}