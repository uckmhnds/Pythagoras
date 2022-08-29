package com.uckmhnds.pythagoras.viewmodel

import androidx.lifecycle.*
import com.uckmhnds.pythagoras.model.database.RecentActionRepository
import com.uckmhnds.pythagoras.model.entities.RecentAction
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class ScientificCalculatorViewModel(private val repository: RecentActionRepository): ViewModel() {

    fun insert(recentAction: RecentAction)   = viewModelScope.launch {
        repository.insert(recentAction)
    }

}


class ScientificCalculatorViewModelFactory(private val repository: RecentActionRepository): ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ScientificCalculatorViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return ScientificCalculatorViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }

}