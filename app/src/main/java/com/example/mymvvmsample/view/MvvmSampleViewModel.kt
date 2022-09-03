package com.example.mymvvmsample.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mymvvmsample.model.CatFactDTO
import com.example.mymvvmsample.service.CatFactRepository
import com.example.mymvvmsample.utils.callApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.suspendCoroutine

@HiltViewModel
class MvvmSampleViewModel @Inject constructor(
    private val catFactRepository: CatFactRepository
) : ViewModel() {
    private val _catFact = MutableLiveData<CatFactDTO>()
    val catFact: LiveData<CatFactDTO> = _catFact

    init {
        loadCatFact()
    }

    fun loadCatFact() {
        viewModelScope.launch {
            /*
            This below can be achieved in more re-usable style
            callApi(
                sourceToUpdate = _catFact,
                actionToMake = { catFactRepository.getCatFact() }
            )*/
             try {
                 _catFact.value = catFactRepository.getCatFact()
             } catch (e: Exception) {
                 // Retrofit error
                 e.printStackTrace()
             }
        }
    }
}