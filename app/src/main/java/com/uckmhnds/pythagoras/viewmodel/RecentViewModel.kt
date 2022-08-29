package com.uckmhnds.pythagoras.viewmodel

import androidx.lifecycle.*
import com.uckmhnds.pythagoras.model.database.RecentActionRepository
import com.uckmhnds.pythagoras.model.entities.RecentAction
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class RecentViewModel(private val repository: RecentActionRepository): ViewModel() {

    fun insert(recentAction: RecentAction)   = viewModelScope.launch {
        repository.insert(recentAction)
    }

    fun delete(recentAction: RecentAction)  = viewModelScope.launch {
        repository.delete(recentAction)
    }

    fun deleteAll()                         = viewModelScope.launch {
        repository.deleteAll()
    }

    val recentActions: LiveData<List<RecentAction>> = repository.recentActions.asLiveData()


}

class RecentViewModelFactory(private val repository: RecentActionRepository): ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(RecentViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return RecentViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }

}