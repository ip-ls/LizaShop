package com.liza.lizashop.presentation.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.liza.lizashop.R
import com.liza.lizashop.databinding.FragmentLoginBinding
import com.liza.lizashop.domain.entity.LoginUser
import com.liza.lizashop.domain.entity.Roles
import com.liza.lizashop.presentation.stateholders.viewmodels.LoginViewModel

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private val viewModel by lazy {
        ViewModelProvider(this)[LoginViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bottomNavView =
            requireActivity().findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavView.visibility = View.GONE
        binding.buttonLogin.setOnClickListener {
            if (checkErrors()) {
                viewModel.checkValid(LoginUser(
                    binding.etPhone.text.toString(),
                    binding.etPassword.text.toString()
                ))
                viewModel.checkLogin.observe(viewLifecycleOwner, Observer {
                    if (it) {
                        // write
                        val sharedPrefWrite = requireActivity().getPreferences(Context.MODE_PRIVATE)
                        val editor = sharedPrefWrite.edit()
                        editor.putString(
                            SHARED_PREF_LOGIN_ED,
                            binding.etPhone.text.toString()
                        )
                        editor.apply()

                        val action = LoginFragmentDirections.actionLoginFragmentToBottomNavGraph()
                        view.findNavController().navigate(action)
                    } else {
                        binding.etPhoneLayout.helperText = getString(R.string.incorrect_number_or_password)
                        binding.etPhone.doOnTextChanged { text, start, before, count ->
                            binding.etPhoneLayout.helperText = ""
                        }
                    }
                })
            }
        }
        binding.textRegister.setOnClickListener {
            val action = LoginFragmentDirections.actionLoginFragmentToRegistrationFragment()
            view.findNavController().navigate(action)
        }
    }

    private fun checkErrors(): Boolean {
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
        if (binding.etPassword.text.toString().isEmpty()) {
            binding.etPasswordLayout.helperText = getString(R.string.field_doesnt_be_empty)
            binding.etPassword.doOnTextChanged { text, start, before, count ->
                binding.etPasswordLayout.helperText = ""
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

        const val SHARED_PREF_LOGIN_ED = "login_ed"
    }

}
