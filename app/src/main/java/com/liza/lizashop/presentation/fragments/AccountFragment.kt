package com.liza.lizashop.presentation.fragments

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.liza.lizashop.databinding.FragmentAccountBinding
import com.liza.lizashop.presentation.MainActivity
import com.liza.lizashop.presentation.fragments.LoginFragment.Companion.SHARED_PREF_LOGIN_ED
import com.liza.lizashop.presentation.stateholders.adapters.SettingsRvAdapter
import com.liza.lizashop.presentation.stateholders.viewmodels.AccountViewModel
import com.liza.lizashop.presentation.stateholders.viewmodels.AccountViewModelFactory

class AccountFragment : Fragment() {

    private var _binding: FragmentAccountBinding? = null
    private val binding get() = _binding!!

    private val phone by lazy {
        val sharedPrefRead: SharedPreferences =
            requireActivity().getPreferences(AppCompatActivity.MODE_PRIVATE)
        sharedPrefRead.getString(SHARED_PREF_LOGIN_ED, "")
    }

    private val viewModelFactory by lazy {
        AccountViewModelFactory(
            requireActivity().application,
            phone ?: ""
        )
    }

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[AccountViewModel::class.java]
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
        viewModel.userName.observe(viewLifecycleOwner) {
            if (it != "")
                binding.textUserName.text = it
        }

        viewModel.settingsListLd.observe(viewLifecycleOwner, Observer {
            it?.let {
                val adapter = SettingsRvAdapter(it)
                adapter.onLeaveItemClickListener = {
                    // write
                    val sharedPrefWrite = requireActivity().getPreferences(Context.MODE_PRIVATE)
                    val editor = sharedPrefWrite.edit()
                    editor.putString(
                        SHARED_PREF_LOGIN_ED,
                        ""
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
