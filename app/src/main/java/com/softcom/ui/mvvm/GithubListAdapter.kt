package com.softcom.ui.mvvm

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.softcom.R
import com.softcom.databinding.ItemListViewBinding
import com.softcom.model.Items

class GithubListAdapter() : RecyclerView.Adapter<GithubListAdapter.DataViewHolder>() {

    private lateinit var itemList: List<Items>

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DataViewHolder {
        val binding: ItemListViewBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            R.layout.item_list_view, parent, false)
        return DataViewHolder(binding);
    }

    override fun getItemCount(): Int {
        return if (::itemList.isInitialized)
            itemList.size
        else
            0
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    fun updateGithubUserList(items: List<Items>) {
        this.itemList = items;
        notifyDataSetChanged()
    }

    class DataViewHolder(private val binding: ItemListViewBinding) : RecyclerView.ViewHolder(binding.root) {
        private val viewModel = GithubViewModel()
        fun bind(items: Items) {
            viewModel.bind(items)
            binding.viewModel = viewModel
        }
    }
}