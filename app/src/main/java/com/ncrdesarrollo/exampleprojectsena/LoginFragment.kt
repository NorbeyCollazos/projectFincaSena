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
import com.ncrdesarrollo.exampleprojectsena.db.User
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

            viewLifecycleOwner.lifecycleScope.launch {
                withContext(Dispatchers.Default) {
                    val db = Room.databaseBuilder(
                        requireContext(),
                        FincDB::class.java,
                        "usersdb"
                    ).build()
                    val users = db.userDao().getUsers()
                }
            }
        }

        return binding.root
    }

    private suspend fun getUsers() {
        val db = Room.databaseBuilder(
            requireContext(),
            FincDB::class.java,
            "usersdb"
        ).build()
        withContext(Dispatchers.IO) {
            // val register = db.userDao().registerUser(model)
            val users = db.userDao().getUsers()
            users.value?.get(0)?.let { Log.d("users: ", it.email) }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
