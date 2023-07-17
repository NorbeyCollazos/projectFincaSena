package com.ncrdesarrollo.exampleprojectsena

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.ncrdesarrollo.exampleprojectsena.databinding.FragmentAnimalFeedingMenuBinding

class AnimalFeedingMenuFragment : Fragment() {

    private var _binding: FragmentAnimalFeedingMenuBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAnimalFeedingMenuBinding.inflate(inflater, container, false)
        with(binding) {
            toolbar.apply {
                title = "Alimentación de animales"
                navigationIcon =
                    AppCompatResources.getDrawable(requireContext(), R.drawable.ic_back)
                setNavigationOnClickListener {
                    findNavController().popBackStack()
                }
            }

            buttonHome.setOnClickListener {
                findNavController().popBackStack(R.id.homeFragment, false)
            }

            buttonGanado.setOnClickListener {
                findNavController().navigate(R.id.ganadoFragment)
            }
            buttonGallinas.setOnClickListener {
                findNavController().navigate(R.id.gallinasFragment)
            }
        }

        return binding.root
    }
}
