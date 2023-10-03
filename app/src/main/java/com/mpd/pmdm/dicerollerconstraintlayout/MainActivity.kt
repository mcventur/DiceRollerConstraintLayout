package com.mpd.pmdm.dicerollerconstraintlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Código añadido
        val rollButton: Button = findViewById(R.id.btnRoll);
        rollButton.setOnClickListener {
            //Tira el dado
            rollDice()
        }
    }

    private fun rollDice() {
        //Creamos el dado con 6 caras
        val dice = Dice(6)
        //Apuntamos con una variable inmutable al textView que mostrará el valor
        val resultTextView:TextView = findViewById(R.id.tvDiceValue)
        resultTextView.text = dice.roll().toString()
    }
}

/**
 * Clase que modela un dado con un número de caras configurable
 */
class Dice(private val numSides:Int){
    fun roll():Int{
        return (1..numSides).random()
    }
}