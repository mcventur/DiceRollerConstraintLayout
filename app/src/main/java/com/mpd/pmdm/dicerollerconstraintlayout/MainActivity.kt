package com.mpd.pmdm.dicerollerconstraintlayout

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.mpd.pmdm.dicerollerconstraintlayout.databinding.ActivityMainBinding
import com.mpd.pmdm.dicerollerconstraintlayout.viewmodel.TwoDicesViewModel

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}