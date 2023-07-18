package com.ncrdesarrollo.exampleprojectsena

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.ncrdesarrollo.exampleprojectsena.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        with(binding) {
            buttonCloseSesion.setOnClickListener {
                findNavController().popBackStack()
            }
            buttonAnimalFeeding.setOnClickListener {
                findNavController().navigate(R.id.animalFeedingMenuFragment)
            }
            buttonCropTreatment.setOnClickListener {
                findNavController().navigate(R.id.cropTreatmentMenuFragment)
            }
            buttonMilkProduction.setOnClickListener {
                findNavController().navigate(R.id.milkProductionFragment)
            }
            buttonCoffeeProduction.setOnClickListener {
                findNavController().navigate(R.id.coffeProductionFragment)
            }
        }

        return binding.root
    }
}
