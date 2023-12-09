package com.mpd.pmdm.dicerollerconstraintlayout

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.mpd.pmdm.dicerollerconstraintlayout.databinding.ActivityMainBinding
import com.mpd.pmdm.dicerollerconstraintlayout.viewmodel.TwoDicesViewModel

class MainActivity : AppCompatActivity() {
    private val dices: TwoDicesViewModel by viewModels{TwoDicesViewModel.DiceViewModelFactory(6)}

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d("MainActivity", "Caras dados creado: ${dices.caraDice1} , ${dices.caraDice2}")
        updateDicesImages()

        binding.btnRoll.setOnClickListener {
            dices.roll()
            //Ya no sería necesario llamar manualmente a la función de actualización con LiveData
            //updateDicesImages()
        }
    }

    private fun updateDicesImages() {
        dices.caraDice1.observe(this){
            updateOneDiceImage(binding.ivDice1, it)
        }

        dices.caraDice2.observe(this){
            updateOneDiceImage(binding.ivDice2, it)
        }
    }

    private fun updateOneDiceImage(ivDice: ImageView, cara: Int) {
        ivDice.setImageResource(
            when(cara){
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> R.drawable.dice_6
            }
        )
    }
}