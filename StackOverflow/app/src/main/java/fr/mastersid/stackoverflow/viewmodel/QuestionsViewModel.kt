package fr.mastersid.stackoverflow.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.mastersid.stackoverflow.Repository.SlackOverflowRepository
import fr.mastersid.stackoverflow.data.Question
import fr.mastersid.stackoverflow.data.QuestionsResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuestionsViewModel @Inject constructor(
    private val stackOverflowRepository: SlackOverflowRepository
): ViewModel() {
    private val _questions: MutableLiveData<List<Question>> = MutableLiveData(emptyList())
    val questions: LiveData<List<Question>> = _questions

    private val _isUpdating = MutableLiveData(false)
    val isUpdating: LiveData<Boolean> = _isUpdating

    init {
        viewModelScope.launch(Dispatchers.IO) {
            //collect est bloquante et agit cm une boucle infinie en attente d'une new reponse
            stackOverflowRepository.questionsResponse.collect { response ->
                when (response) {
                    is QuestionsResponse.Pending -> _isUpdating.postValue(true)
                    is QuestionsResponse.Succes -> {
                        _questions.postValue(response.list)
                        _isUpdating.postValue(false)
                    }
                }
            }
        }
    }

    fun updateQuestions() {
        viewModelScope.launch(Dispatchers.IO) {
            stackOverflowRepository.updateQuestionsInfo()
        }

    }
}