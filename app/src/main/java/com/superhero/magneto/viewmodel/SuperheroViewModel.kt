package com.superhero.magneto.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.superhero.magneto.model.Superhero
import com.superhero.magneto.network.RetrofitInstance
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SuperheroViewModel : ViewModel() {

    private val _superhero = MutableLiveData<Superhero?>()
    val superhero: LiveData<Superhero?> get() = _superhero

    fun fetchSuperhero(accessToken: String, id: Int) {
        viewModelScope.launch {
            try {
                val call: Call<Superhero> = RetrofitInstance.api.getSuperhero(accessToken, id)
                call.enqueue(object : Callback<Superhero> {
                    override fun onResponse(call: Call<Superhero>, response: Response<Superhero>) {
                        if (response.isSuccessful) {
                            _superhero.postValue(response.body())
                        } else {
                            Log.e("SuperheroViewModel", "Error: ${response.errorBody()}")
                        }
                    }

                    override fun onFailure(call: Call<Superhero>, t: Throwable) {
                        Log.e("SuperheroViewModel", "Exception: ${t.message}")
                    }
                })
            } catch (e: Exception) {
                Log.e("SuperheroViewModel", "Exception: ${e.message}")
            }
        }
    }
}