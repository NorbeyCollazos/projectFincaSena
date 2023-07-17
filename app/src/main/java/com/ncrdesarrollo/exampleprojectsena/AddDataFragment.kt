package com.ncrdesarrollo.exampleprojectsena

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.ncrdesarrollo.exampleprojectsena.databinding.FragmentAddDataBinding

class AddDataFragment : Fragment() {

    private var _binding: FragmentAddDataBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddDataBinding.inflate(inflater, container, false)
        with(binding) {
            toolbar.apply {
                title = "Registrar datos"
                navigationIcon =
                    AppCompatResources.getDrawable(requireContext(), R.drawable.ic_back)
                setNavigationOnClickListener {
                    findNavController().popBackStack()
                }
            }

            buttonAdd.setOnClickListener {
                val dataOne = etDato1.text
                val dataTwo = etTwo.text
                if (dataOne.isNullOrEmpty()) {
                    textInputLayoutDatoOne.error = "Ingrese el dato 1"
                    etDato1.requestFocus()
                } else if (dataTwo.isNullOrEmpty()) {
                    textInputLayoutDatoTwo.error = "Ingrese el dato 2"
                    etTwo.requestFocus()
                } else {
                }
            }
        }
        return binding.root
    }
}
