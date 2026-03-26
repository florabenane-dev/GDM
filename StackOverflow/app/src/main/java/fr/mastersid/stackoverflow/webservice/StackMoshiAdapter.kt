package fr.mastersid.stackoverflow.webservice

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import fr.mastersid.stackoverflow.data.ListStackJson
import fr.mastersid.stackoverflow.data.Question
import fr.mastersid.stackoverflow.data.StackJson

//A CORRIGER ICI AUSSI
class StackMoshiAdapter {
    @FromJson
    fun fromJson(lisStackJson: ListStackJson): List<Question> {
        return lisStackJson.items.map { stackJson->
            Question(
                stackJson.question_id,
                stackJson.title,
                stackJson.answer_count,
                stackJson.body
            )
        }
    }

    @ToJson
    fun toJson(listQuestions: List<Question>): ListStackJson {
        return ListStackJson(
            listQuestions.map { question ->
                StackJson(
                    question_id = question.id,
                    title = question.title,
                    answer_count = question.answerCount,
                    body = question.body
                )
            }
        )
    }

}