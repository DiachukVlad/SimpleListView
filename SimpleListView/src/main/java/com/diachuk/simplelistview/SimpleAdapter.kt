package com.diachuk.simplelistview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

internal class SimpleAdapter<DataType, BindingType : ViewBinding>(
	val data: List<DataType>, val createBinding: (LayoutInflater) -> BindingType, val bind: BindingType.(pos: Int) -> Unit
) : RecyclerView.Adapter<SimpleAdapter.SimpleHolder<BindingType>>() {

	class SimpleHolder<BindingType : ViewBinding>(val binding: BindingType) :
		RecyclerView.ViewHolder(binding.root)


	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleHolder<BindingType> {
		return SimpleHolder(createBinding(LayoutInflater.from(parent.context)))
	}

	override fun onBindViewHolder(holder: SimpleHolder<BindingType>, position: Int) {
		holder.binding.bind(position)
	}

	override fun getItemCount() = data.size
}