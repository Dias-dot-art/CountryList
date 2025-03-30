package com.example.countrylist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val imageDetails = getListData()
        val adapter = CountryAdapter(this, imageDetails)
        recyclerView.adapter = adapter
    }

    private fun getListData(): List<Country> {
        val list = mutableListOf<Country>()
        list.add(Country("Vietnam", "vn", 98000000))
        list.add(Country("United States", "us", 332000000))
        list.add(Country("Russia", "ru", 142000000))
        return list
    }
}