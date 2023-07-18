package com.ncrdesarrollo.exampleprojectsena

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.room.Room
import com.ncrdesarrollo.exampleprojectsena.databinding.FragmentCreateAccountBinding
import com.ncrdesarrollo.exampleprojectsena.db.FincDB
import com.ncrdesarrollo.exampleprojectsena.db.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CreateAccountFragment : Fragment() {

    private var _binding: FragmentCreateAccountBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCreateAccountBinding.inflate(inflater, container, false)

        val db = Room.databaseBuilder(
            requireContext().applicationContext,
            FincDB::class.java,
            "usersdb"
        ).build()

        with(binding) {
            toolbar.apply {
                title = "Crear cuenta"
                navigationIcon =
                    AppCompatResources.getDrawable(requireContext(), R.drawable.ic_back)
                setNavigationOnClickListener {
                    findNavController().popBackStack()
                }
            }

            button.setOnClickListener {
                val model = User(
                    name = etName.text.toString(),
                    lastName = etLastName.text.toString(),
                    phone = etPhone.text.toString(),
                    documentId = etDocument.text.toString(),
                    email = etEmail.text.toString(),
                    password = etPassword.text.toString()
                )
                lifecycleScope.launch {
                    withContext(Dispatchers.Default) {
                        val register = db.userDao().registerUser(model)
                    }
                }

                findNavController().popBackStack()
                Toast.makeText(requireContext(), "Se ha registrado el usuario", Toast.LENGTH_SHORT).show()
            }
        }
        return binding.root
    }
}
