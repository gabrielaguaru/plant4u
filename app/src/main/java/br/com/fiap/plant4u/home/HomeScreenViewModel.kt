package br.com.fiap.plant4u.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.fiap.plant4u.model.Plant
import br.com.fiap.plant4u.service.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeScreenViewModel: ViewModel() {
    private val _watering = MutableLiveData<Boolean>()
    val watering: LiveData<Boolean> = _watering

    private val _carouselCurrentIndex = MutableLiveData<Int>()
    val carouselCurrentIndex = _carouselCurrentIndex

    private val _plantList = MutableLiveData<List<Plant>>(emptyList())
    val plantList = _plantList

    private val _noPlants = MutableLiveData<Boolean>()
    val noPlants  = _noPlants

    fun onWateringChanged(newWatering: Boolean) {
        _watering.value = newWatering
    }

    fun onCarouselCurrentIndexChanged(newIndex: Int) {
        carouselCurrentIndex.value = newIndex
    }

    fun onPlantListChanged(newPlantList: List<Plant>) {
        plantList.value = newPlantList
    }

    fun onNoPlantsChanged(newNoPlants: Boolean) {
        _noPlants.value = newNoPlants
    }

    fun fetchPlantList(userId: Long) {
        val call = RetrofitFactory().getPlantService().getPlantsByUserId(userId)

        call.enqueue(object : Callback<List<Plant>>{
            override fun onResponse(call: Call<List<Plant>>, response: Response<List<Plant>>) {
                Log.i("GABS HOME", "onResponse: ${response.body()?.take(3)}")
                if(response.body().isNullOrEmpty()) {
                    onNoPlantsChanged(true)
                } else {
                    onPlantListChanged(response.body()!!.take(3))
                    onNoPlantsChanged(false)
                }
            }

            override fun onFailure(call: Call<List<Plant>>, t: Throwable) {
                Log.i("APP ERROR", "onFailure: ${t.message}")
            }

        })
    }
}