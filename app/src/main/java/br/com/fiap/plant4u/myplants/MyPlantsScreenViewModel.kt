package br.com.fiap.plant4u.myplants

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.fiap.plant4u.model.Plant

class MyPlantsScreenViewModel {
    private val _watering = MutableLiveData<Boolean>()
    val watering: LiveData<Boolean> = _watering

    private val _plantList = MutableLiveData<List<Plant>>(emptyList())
    val plantList = _plantList

    fun onWateringChanged(newWatering: Boolean) {
        _watering.value = newWatering
    }

    fun onPlantListChanged(newPlantList: List<Plant>) {
        plantList.value = newPlantList
    }
}