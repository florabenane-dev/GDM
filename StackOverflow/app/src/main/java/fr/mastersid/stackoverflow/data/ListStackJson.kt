package fr.mastersid.stackoverflow.data

data class ListStackJson(
    val items: List<StackJson>
)

//A CORRIGER ICI
data class StackJson(
    val question_id: Int,
    val title: String,
    val answer_count: Int,
    val body: String
)
