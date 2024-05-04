package com.guim.filmmapp.presentation

import androidx.lifecycle.ViewModel
import com.guim.filmmapp.domain.use_case.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val useCases: UseCases
){

}