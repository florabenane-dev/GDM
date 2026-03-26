package fr.mastersid.examflora.data

data class ResultsJson(
    val _id: String,
    val libelle_region_academique: String,
    val discipline: String,
    val competence: String,
    val taux_de_maitrise : Int
)

data class ListResultsJson(
    val results: List<ResultsJson>
)