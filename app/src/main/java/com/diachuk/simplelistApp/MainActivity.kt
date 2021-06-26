package com.diachuk.simplelistApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import by.kirich1409.viewbindingdelegate.viewBinding
import com.diachuk.simplelistApp.databinding.ActivityMainBinding
import com.diachuk.simplelistApp.databinding.ItemBinding

class MainActivity : AppCompatActivity(R.layout.activity_main) {

	private val binding by viewBinding(ActivityMainBinding::bind)

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		val data = listOf("qwe", "asd", "zxc")

		binding.listView.createWithData(
			data,
			ItemBinding::inflate,
		) { pos ->
			root.text = data[pos]
		}
	}
}