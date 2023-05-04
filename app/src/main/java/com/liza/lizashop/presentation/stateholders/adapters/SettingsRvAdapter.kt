package com.liza.lizashop.presentation.stateholders.adapters

import android.content.Context
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.liza.lizashop.databinding.ItemParagraphSettingsListBinding
import com.liza.lizashop.databinding.ItemProductListBinding
import com.liza.lizashop.domain.entity.ProductListItem
import com.liza.lizashop.domain.entity.SettingsListItem
import com.liza.lizashop.presentation.fragments.AccountFragmentDirections
import com.liza.lizashop.presentation.fragments.CategoriesFragmentDirections
import com.liza.lizashop.presentation.fragments.LoginFragment

class SettingsRvAdapter(
    private val settingsList: List<SettingsListItem>
) :
    RecyclerView.Adapter<SettingsRvAdapter.ViewHolder>() {

    var onLeaveItemClickListener: ((SettingsListItem) -> Unit)? = null

    inner class ViewHolder(val binding: ItemParagraphSettingsListBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = ItemParagraphSettingsListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(itemBinding)
    }

    override fun getItemCount() = settingsList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = settingsList[position]
        if (item.type) {
            with(holder) {
                itemView.isClickable = true
                binding.imageSetting.visibility = View.VISIBLE
                binding.imageView6.visibility = View.VISIBLE
                binding.textNameSetting.visibility = View.VISIBLE

                binding.switchSetting.visibility = View.GONE
                binding.textHeaderSetting.visibility = View.GONE

                binding.imageSetting.setImageResource(item.imageRes)
                binding.textNameSetting.text = item.titleSetting

                if (position == 2) {
                    itemView.setOnClickListener {
                        val action =
                            AccountFragmentDirections.actionAccountFragmentToTopUpBalanceFragment()
                        it.findNavController().navigate(action)
                    }
                }
            }
        } else {
            with(holder) {
                itemView.isClickable = false
                binding.imageSetting.visibility = View.GONE
                binding.imageView6.visibility = View.GONE
                binding.textNameSetting.visibility = View.GONE

                binding.switchSetting.visibility = View.GONE
                binding.textHeaderSetting.visibility = View.VISIBLE

                binding.textHeaderSetting.text = item.titleSetting
            }
        }
        holder.binding.root.setOnClickListener {
            onLeaveItemClickListener?.invoke(item)
        }
    }

    companion object {

        private const val LEAVE_ACC = 7
    }
}