package fr.mastersid.examflora.data

sealed interface ResultsResponse {
    data object Pending: ResultsResponse //en attente de réponse

    @JvmInline
    value class Success(val list: List<Results>): ResultsResponse //liste de resultat
}