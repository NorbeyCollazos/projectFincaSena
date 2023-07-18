package com.ncrdesarrollo.exampleprojectsena

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.ncrdesarrollo.exampleprojectsena.databinding.FragmentMilkProductionBinding

class MilkProductionFragment : Fragment() {

    private var _binding: FragmentMilkProductionBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMilkProductionBinding.inflate(inflater, container, false)
        with(binding) {
            toolbar.apply {
                title = "Producción de leche"
                navigationIcon =
                    AppCompatResources.getDrawable(requireContext(), R.drawable.ic_back)
                setNavigationOnClickListener {
                    findNavController().popBackStack()
                }
            }
        }

        return binding.root
    }
}
