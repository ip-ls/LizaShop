package com.liza.lizashop.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.liza.lizashop.R
import com.liza.lizashop.databinding.FragmentRegistrationBinding
import com.liza.lizashop.domain.entity.RegistrationUser
import com.liza.lizashop.domain.entity.Roles
import com.liza.lizashop.presentation.stateholders.viewmodels.RegistrationViewModel

class RegistrationFragment : Fragment() {

    private var _binding: FragmentRegistrationBinding? = null
    private val binding get() = _binding!!

    private val viewModel by lazy {
        ViewModelProvider(this)[RegistrationViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegistrationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bottomNavView =
            requireActivity().findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavView.visibility = View.GONE
        binding.buttonRegister.setOnClickListener {
            if (binding.etPassword.text.toString() ==
                binding.etConfirmPassword.text.toString() &&
                binding.etPassword.text.toString().isNotEmpty() &&
                binding.etConfirmPassword.text.toString().isNotEmpty()
            ) {
                if (checkErrors()) {
                    viewModel.register(
                        RegistrationUser(
                            name = binding.etName.text.toString(),
                            phone = binding.etPhone.text.toString(),
                            password = binding.etPassword.text.toString(),
                            role = Roles.USER
                        )
                    )
                    val action =
                        RegistrationFragmentDirections.actionRegistrationFragmentToLoginFragment()
                    view.findNavController().navigate(action)
                }
            } else {
                binding.etPasswordLayout.helperText = getString(R.string.passwords_mismatch)
                binding.etPassword.doOnTextChanged { text, start, before, count ->
                    binding.etPasswordLayout.helperText = ""
                }
            }

        }
        binding.textLogin.setOnClickListener {
            val action = RegistrationFragmentDirections.actionRegistrationFragmentToLoginFragment()
            view.findNavController().navigate(action)
        }
    }

    private fun checkErrors(): Boolean {
        if (binding.etName.text.toString().isEmpty()) {
            binding.etNameLayout.helperText = getString(R.string.field_doesnt_be_empty)
            binding.etName.doOnTextChanged { text, start, before, count ->
                binding.etNameLayout.helperText = ""
            }
            return false;
        }
        if (binding.etPhone.text.toString().length != 10) {
            binding.etPhoneLayout.helperText = getString(R.string.incorrect_number_format)
            binding.etPhone.doOnTextChanged { text, start, before, count ->
                binding.etPhoneLayout.helperText = ""
            }
            return false;
        }
        if (binding.etPhone.text.toString().isEmpty()) {
            binding.etPhoneLayout.helperText = getString(R.string.field_doesnt_be_empty)
            binding.etPhone.doOnTextChanged { text, start, before, count ->
                binding.etPhoneLayout.helperText = ""
            }
            return false;
        }
        return true
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        public const val KEY_NUMBER = "key_number"
        public const val KEY_PASS = "key_pass"
    }

}