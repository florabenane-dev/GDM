package fr.mastersid.examflora.webservice

import com.squareup.moshi.FromJson
import fr.mastersid.examflora.data.ListResultsJson
import fr.mastersid.examflora.data.Results

class ResultMoshiAdapter {
    @FromJson //Pour que moshi puisse l'utiliser
    fun fromJson(listResultsJson: ListResultsJson): List<Results> {
        return listResultsJson.results.map { resultsJson -> Results(
            id = resultsJson._id,
            libelleAcademique = resultsJson.libelle_region_academique,
            discipline = resultsJson.discipline,
            competence = resultsJson.competence,
            taux = resultsJson.taux_de_maitrise
        ) }
    }
}