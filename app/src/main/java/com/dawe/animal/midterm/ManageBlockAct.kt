package com.dawe.animal.midterm

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import android.content.SharedPreferences

class ManageBlockActivity : AppCompatActivity() {

    private lateinit var blockedAnimalsListView: ListView
    private lateinit var blockedAnimalsAdapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manage_block)

        blockedAnimalsListView = findViewById(R.id.blockedAnimalsListView)
        blockedAnimalsAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1)

        // Load the list of blocked animals from SharedPreferences
        loadBlockedAnimals()

        blockedAnimalsListView.adapter = blockedAnimalsAdapter

        blockedAnimalsListView.setOnItemClickListener { parent: AdapterView<*>?, view: View?, position: Int, id: Long ->
            // Handle item click, e.g., unblocking the selected animal
            val animalName = blockedAnimalsAdapter.getItem(position)
            if (animalName != null) {
                unblockAnimal(animalName)
            }
        }
    }

    private fun loadBlockedAnimals() {
        val sharedPreferences = getSharedPreferences("BlockListPreferences", MODE_PRIVATE)
        val blockedAnimals = sharedPreferences.getStringSet("blockedAnimals", mutableSetOf()) ?: mutableSetOf()
        blockedAnimalsAdapter.clear()
        blockedAnimalsAdapter.addAll(blockedAnimals)
    }

    private fun unblockAnimal(animalName: String) {
        // Remove the unblocked animal from the list and update SharedPreferences
        val sharedPreferences = getSharedPreferences("BlockListPreferences", MODE_PRIVATE)
        val blockedAnimals = sharedPreferences.getStringSet("blockedAnimals", mutableSetOf()) ?: mutableSetOf()
        blockedAnimals.remove(animalName)
        sharedPreferences.edit().putStringSet("blockedAnimals", blockedAnimals).apply()

        // Refresh the list view
        loadBlockedAnimals()
    }
}