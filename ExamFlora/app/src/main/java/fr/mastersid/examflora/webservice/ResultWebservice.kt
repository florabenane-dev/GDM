package fr.mastersid.examflora.webservice

import fr.mastersid.examflora.data.Results
import retrofit2.http.GET
import retrofit2.http.Query

//records?include_app_metas=true
interface ResultWebservice {
    @GET("records?include_app_metas=true")
    suspend fun getResultsList(
       @Query("limit") limit: Int = 100
    ): List<Results>
}