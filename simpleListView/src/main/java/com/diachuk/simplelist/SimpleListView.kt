package com.diachuk.simplelist

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

class SimpleListView(context: Context, attrs: AttributeSet? = null) : RecyclerView(context, attrs) {
	fun <DataType, BindingType : ViewBinding> createWithData(
		data: List<DataType>,
		createBinding: (LayoutInflater) -> BindingType,
		bind: BindingType.(pos: Int) -> Unit
	) {
		adapter = SimpleAdapter(data, createBinding, bind)
	}
}