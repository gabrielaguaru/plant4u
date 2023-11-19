package br.com.fiap.plant4u.myplants

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class MyPlantsScreenViewModel {
    private val _watering = MutableLiveData<Boolean>()
    val watering: LiveData<Boolean> = _watering

    fun onWateringChanged(newWatering: Boolean) {
        _watering.value = newWatering
    }
}