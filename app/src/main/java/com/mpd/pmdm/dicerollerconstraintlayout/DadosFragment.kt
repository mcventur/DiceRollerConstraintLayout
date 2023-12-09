package com.mpd.pmdm.dicerollerconstraintlayout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.mpd.pmdm.dicerollerconstraintlayout.databinding.FragmentDadosBinding
import com.mpd.pmdm.dicerollerconstraintlayout.viewmodel.TwoDicesViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DadosFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DadosFragment : Fragment() {
    private var _binding: FragmentDadosBinding? = null
    private val binding get() = _binding!!

    private val dices: TwoDicesViewModel by activityViewModels{
        TwoDicesViewModel.DiceViewModelFactory(6)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDadosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        updateDicesImages()
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun updateDicesImages() {
        dices.caraDice1.observe(viewLifecycleOwner){
            updateOneDiceImage(binding.ivDice1, it)
        }

        dices.caraDice2.observe(viewLifecycleOwner){
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