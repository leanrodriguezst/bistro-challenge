package com.example.bistrochallenge.public_api.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bistrochallenge.public_api.presentation.interfaces.GetImageUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PublicApiScreenViewModel @Inject constructor(
    private val getImageUseCase: GetImageUseCase
) : ViewModel() {

    private var _imageUrl: MutableLiveData<String> = MutableLiveData()
    val imageUrl: LiveData<String>
        get() = _imageUrl

    fun fetchImage() {
        viewModelScope.launch {
            val imageUrl = getImageUseCase.invoke()
            _imageUrl.value = imageUrl
        }
    }


}