package fr.mastersid.stackoverflow.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import fr.mastersid.stackoverflow.data.Question

class QuestionsViewModel: ViewModel() {
    private val _questions: MutableLiveData<List<Question>> = MutableLiveData(emptyList())
    val questions: LiveData<List<Question>> = _questions

    private val _isUpdating = MutableLiveData(false)
    val isUpdating: LiveData<Boolean> = _isUpdating

    fun updateQuestions() {

    }
}