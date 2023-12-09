package com.mpd.pmdm.dicerollerconstraintlayout.model

data class Dice(val numSides: Int) {
    private var _caraActual: Int? = null
    val caraActual get() = _caraActual!!

    init{
        roll()
    }

    fun roll() {
        _caraActual = (1..numSides).random()
    }
}