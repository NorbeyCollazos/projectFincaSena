package com.ncrdesarrollo.exampleprojectsena

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ncrdesarrollo.exampleprojectsena.databinding.FragmentLoginBinding

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
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
