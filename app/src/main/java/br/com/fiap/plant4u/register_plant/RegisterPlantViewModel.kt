package br.com.fiap.plant4u.register_plant

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class RegisterPlantViewModel {

    private val _name = MutableLiveData<String>()
    val name: LiveData<String> = _name

    private val _image = MutableLiveData<String>()
    val image: LiveData<String> = _image

    private val _imageUri = MutableLiveData<Uri?>()
    val imageUri: LiveData<Uri?> = _imageUri

    private val _frequency = MutableLiveData<String>()
    val frequency: LiveData<String> = _frequency

    private val _interval = MutableLiveData<String>()
    val interval: LiveData<String> = _interval

    private val _showError = MutableLiveData<Boolean>()
    val showError: LiveData<Boolean> = _showError


    fun onNameChange(newName: String) {
        _name.value = newName
    }

    fun onImageChange(newImage: String) {
        _image.value = newImage
    }

    fun onFrequencyChange(newFrequency: String) {
        _frequency.value = newFrequency
    }

    fun onIntervalChange(newInterval: String) {
        _interval.value = newInterval
    }

    fun onShowErrorChange(newShowError: Boolean) {
        _showError.value = newShowError
    }

}