package com.mpd.pmdm.dicerollerconstraintlayout

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Código añadido
        val rollButton: Button = findViewById(R.id.btnRoll);
        rollButton.setOnClickListener { rollDice() }

        //Mostramos una cara aleatoria cuando la aplicación arranca
        rollDice()
    }

    /**
     * Función que crea un dado, lo tira, y muestra su valor en la IU
     */
    private fun rollDice() {
        //Creamos el dado con 6 caras
        val dice = Dice(6)
        val diceValue = dice.roll()

        //Apuntamos con una variable inmutable al ImageView con la imagen del dado
        val diceImage:ImageView = findViewById(R.id.ivDice)

        val imgDiceResource = when(diceValue){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            //Esto no se debería dar, pero me obliga al usar when como expresión
            else -> R.drawable.dice_6
        }

        diceImage.setImageResource(imgDiceResource)
        //Le damos una descripción a la imagen para aportar accesibilidad
        diceImage.contentDescription = diceValue.toString()
    }
}

/**
 * Clase que modela un dado con un número de caras configurable
 */
class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}