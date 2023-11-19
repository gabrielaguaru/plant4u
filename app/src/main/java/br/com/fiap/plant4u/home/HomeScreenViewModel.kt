package br.com.fiap.plant4u.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeScreenViewModel: ViewModel() {
    private val _watering = MutableLiveData<Boolean>()
    val watering: LiveData<Boolean> = _watering

    private val _carouselCurrentIndex = MutableLiveData<Int>()
    val carouselCurrentIndex = _carouselCurrentIndex

    fun onWateringChanged(newWatering: Boolean) {
        _watering.value = newWatering
    }

    fun onCarouselCurrentIndexChanged(newIndex: Int) {
        carouselCurrentIndex.value = newIndex
    }
}