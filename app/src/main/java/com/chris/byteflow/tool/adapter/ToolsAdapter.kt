package com.chris.byteflow.tool.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.chris.byteflow.tool.base.clicksFlow
import com.chris.byteflow.tool.databinding.ItemStarterBinding
import com.chris.byteflow.tool.enums.ToolsEntry
import kotlinx.coroutines.CoroutineScope

class ToolsAdapter(private val scope: CoroutineScope, val block: ToolsEntry.() -> Unit) :
    ListAdapter<ToolsEntry, ToolsAdapter.ToolViewHolder>(Callback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToolViewHolder =
        ToolViewHolder(
            ItemStarterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ToolViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ToolViewHolder(
        private val binding: ItemStarterBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.clicksFlow(scope) {
                block(binding.entry!!)
            }
        }

        fun bind(entry: ToolsEntry) {
            binding.apply {
                this.entry = entry
                executePendingBindings()
            }
        }
    }

    private class Callback : DiffUtil.ItemCallback<ToolsEntry>() {
        override fun areItemsTheSame(oldItem: ToolsEntry, newItem: ToolsEntry): Boolean =
            newItem == oldItem

        override fun areContentsTheSame(oldItem: ToolsEntry, newItem: ToolsEntry): Boolean =
            newItem == oldItem
    }
}