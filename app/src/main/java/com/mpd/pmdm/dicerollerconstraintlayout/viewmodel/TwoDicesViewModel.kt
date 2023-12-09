package com.mpd.pmdm.dicerollerconstraintlayout.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mpd.pmdm.dicerollerconstraintlayout.model.Dice

class TwoDicesViewModel(carasDados: Int) : ViewModel() {
    private val dice1 = Dice(carasDados)
    private val dice2 = Dice(carasDados)
    val caraDice1 get() = dice1.caraActual
    val caraDice2 get() = dice2.caraActual

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
        dice2.roll()
    }

    override fun onCleared() {
        super.onCleared()
        Log.d(TAG, "Borrando el ViewModel")
    }


    companion object{
        private const val TAG = "TwoDicesViewModel"
    }

}