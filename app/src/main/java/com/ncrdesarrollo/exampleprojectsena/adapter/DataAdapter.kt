package com.ncrdesarrollo.exampleprojectsena.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.ncrdesarrollo.exampleprojectsena.databinding.DataListItemBinding
import com.ncrdesarrollo.exampleprojectsena.model.DataModel

class DataAdapter(private val onClick: (DataModel) -> Unit) :
    RecyclerView.Adapter<DataAdapter.ViewHolder>() {

    private var list: List<DataModel> = listOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding = DataListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding, onClick)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        val item = list[position]
        holder.bind(item)
    }

    override fun getItemCount() = list.size

    fun setList(list: List<DataModel>) {
        this.list = list
    }

    class ViewHolder(
        private val binding: DataListItemBinding,
        private val onClick: (DataModel) -> Unit
    ) :
        RecyclerView.ViewHolder(binding.root) {
        private var item: DataModel? = null
        init {
            binding.cardViewContent.setOnClickListener {
                item?.let { it1 -> onClick(it1) }
            }
        }
        fun bind(item: DataModel) {
            this.item = item

            with(binding) {
                textViewTitle.text = item.title
            }
        }
    }
}
