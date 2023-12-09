package com.mpd.pmdm.dicerollerconstraintlayout.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mpd.pmdm.dicerollerconstraintlayout.model.Dice

class TwoDicesViewModel(carasDados: Int) : ViewModel() {
    private val dice1 = Dice(carasDados)
    private val dice2 = Dice(carasDados)

    private val _caraDice1 = MutableLiveData<Int>(dice1.caraActual)
    val caraDice1: LiveData<Int> = _caraDice1

    private val _caraDice2 = MutableLiveData<Int>(dice2.caraActual)
    val caraDice2: LiveData<Int> = _caraDice2

    init {
        Log.d(TAG, "Inicializando ViewModel con dados: $dice1 y $dice2")
    }

    //Necesitamios un ViewModelProvider.Factory si queremos instanciar nuestro ViewModel recibiendo argumentos
    //En este caso, numCaras
    @Suppress("UNCHECKED_CAST")
    class DiceViewModelFactory(private val numCaras: Int) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(TwoDicesViewModel::class.java)) {
                return TwoDicesViewModel(numCaras) as T
            }
            throw IllegalArgumentException("Unkown ViewModel Class")
        }
    }

    fun roll() {
        dice1.roll()
        _caraDice1.value = dice1.caraActual
        dice2.roll()
        _caraDice2.value = dice2.caraActual
    }

    override fun onCleared() {
        super.onCleared()
        Log.d(TAG, "Borrando el ViewModel")
    }


    companion object{
        private const val TAG = "TwoDicesViewModel"
    }

}