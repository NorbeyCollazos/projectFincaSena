package com.ncrdesarrollo.exampleprojectsena

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ncrdesarrollo.exampleprojectsena.adapter.DataAdapter
import com.ncrdesarrollo.exampleprojectsena.databinding.FragmentDataListBinding
import com.ncrdesarrollo.exampleprojectsena.model.DataModel

class DataListFragment : Fragment() {

    private var _binding: FragmentDataListBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapterData: DataAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDataListBinding.inflate(inflater, container, false)
        with(binding) {
            toolbar.apply {
                title = "Listado de datos"
                navigationIcon =
                    AppCompatResources.getDrawable(requireContext(), R.drawable.ic_back)
                setNavigationOnClickListener {
                    findNavController().popBackStack()
                }
            }

            buttonAdd.setOnClickListener {

            }
        }
        setAdapter()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val list = DataModel.getListData()
        adapterData.setList(list)
        adapterData.notifyDataSetChanged()
    }

    private fun setAdapter() {
        adapterData = DataAdapter {
            Toast.makeText(requireContext(), it.title, Toast.LENGTH_SHORT).show()
        }

        binding.recyclerData.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = adapterData
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
