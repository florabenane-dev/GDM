package fr.mastersid.stackoverflow.webservice

import fr.mastersid.stackoverflow.data.ListStackJson
import fr.mastersid.stackoverflow.data.Question
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface StackWebService {

    @GET("questions?site=stackoverflow")
    suspend fun getQuestionsList(
        @Query("pagesize") pageSize: Int = 20,
        @Query("order") order: String = "desc",
        @Query("sort") sort: String = "activity",
        @Query("filter") filter: String = "withbody"
    ): List<Question>
}