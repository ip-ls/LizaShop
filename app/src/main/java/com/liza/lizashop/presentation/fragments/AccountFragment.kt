package com.liza.lizashop.presentation.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.liza.lizashop.databinding.FragmentAccountBinding
import com.liza.lizashop.presentation.MainActivity
import com.liza.lizashop.presentation.fragments.LoginFragment.Companion.SHARED_PREF_LOGIN_ED
import com.liza.lizashop.presentation.stateholders.adapters.SettingsRvAdapter
import com.liza.lizashop.presentation.stateholders.viewmodels.AccountViewModel

class AccountFragment : Fragment() {

    private var _binding: FragmentAccountBinding? = null
    private val binding get() = _binding!!

    private val viewModel by lazy {
        ViewModelProvider(this)[AccountViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAccountBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.settingsListLd.observe(viewLifecycleOwner, Observer {
            it?.let {
                val adapter = SettingsRvAdapter(it)
                adapter.onLeaveItemClickListener = {
                    // write
                    val sharedPrefWrite = requireActivity().getPreferences(Context.MODE_PRIVATE)
                    val editor = sharedPrefWrite.edit()
                    editor.putBoolean(
                        SHARED_PREF_LOGIN_ED,
                        false
                    )
                    editor.apply()

                    val intent = Intent(requireContext(), MainActivity::class.java)
                    intent.flags = intent.flags or Intent.FLAG_ACTIVITY_NO_HISTORY
                    startActivity(intent)
                    requireActivity().finish()
                }
                binding.settingsList.adapter = adapter
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}