package com.ncrdesarrollo.exampleprojectsena

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.room.Room
import com.ncrdesarrollo.exampleprojectsena.databinding.FragmentLoginBinding
import com.ncrdesarrollo.exampleprojectsena.db.FincDB
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)

        with(binding) {
            buttonLogin.setOnClickListener {
                val email = etEmail.text
                val password = etPassword.text
                if (email.isNullOrEmpty()) {
                    etEmail.error = "Por favor ingrese el correo"
                    etEmail.requestFocus()
                } else if (password.isNullOrEmpty()) {
                    etPassword.error = "Por favor ingrese la contraseña"
                    etPassword.requestFocus()
                } else {
                    findNavController().navigate(R.id.homeFragment)
                }
            }

            buttonForgotPassword.setOnClickListener {
                Toast.makeText(requireContext(), "En proceso", Toast.LENGTH_SHORT).show()
            }

            buttonCreateAccount.setOnClickListener {
                findNavController().navigate(R.id.createAccountFragment)
            }

            val db = Room.databaseBuilder(
                requireContext(),
                FincDB::class.java,
                "usersdb"
            ).build()

            viewLifecycleOwner.lifecycleScope.launch {
                withContext(Dispatchers.IO) {
                    val users = db.userDao().getUsers()
                    users.value?.forEach { value ->
                        Log.d("users: ", value.email)
                    }
                }
            }
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
