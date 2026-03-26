package fr.mastersid.examflora.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.mastersid.examflora.data.Results
import fr.mastersid.examflora.data.ResultsResponse
import fr.mastersid.examflora.repository.ResultRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ResultViewModel @Inject constructor(
        private val resultRepository: ResultRepository
): ViewModel() {
    private val _results: MutableLiveData<List<Results>> = MutableLiveData(emptyList())
    val results: LiveData<List<Results>> = _results

    private val _isUpdating = MutableLiveData(false)
    val isUpdating: LiveData<Boolean> = _isUpdating

    init {
        viewModelScope.launch(Dispatchers.IO) {
            //collect est bloquante et agit cm une boucle infinie en attente d'une new reponse
            resultRepository.resultsResponse.collect { response ->
                when (response) {
                    is ResultsResponse.Pending -> _isUpdating.postValue(true)
                    is ResultsResponse.Success -> {
                        _results.postValue(response.list)
                        _isUpdating.postValue(false)
                    }
                }
            }
        }
    }

    fun updateResults() {
        viewModelScope.launch(Dispatchers.IO) {
            resultRepository.updateResultsInfo()
        }

    }
}