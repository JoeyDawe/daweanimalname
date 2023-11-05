package com.dawe.animal.midterm

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class AnimalDetailsAct : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal_details)

        val animalNameTextView = findViewById<TextView>(R.id.tv_animal_name)
        val animalDescriptionTextView = findViewById<TextView>(R.id.animalDescriptionTextView)
        val addToBlockListButton = findViewById<Button>(R.id.addToBlockListButton)

        // Retrieve the selected animal's details from the previous activity or data source
        val animalName = intent.getStringExtra("animal_name")
        val animalDescription = intent.getStringExtra("animal_description")

        if (animalName != null && animalDescription != null) {
            // Display the animal's name and description
            animalNameTextView.text = animalName
            animalDescriptionTextView.text = animalDescription

            // Handle the button click to add the animal to the block list
            addToBlockListButton.setOnClickListener {
                // Implement the logic to add the animal to the block list here
                // You may want to save it to a data source (e.g., database or preferences)

                // For example, you can use SharedPreferences to store the blocked animals
                addToBlockList(animalName)

                // Provide feedback to the user about the successful addition
                showToast("Animal added to the block list.")

                // Optionally, you can finish the activity or navigate back to the previous screen
                finish()
            }
        }
    }

    private fun addToBlockList(animalName: String) {
        // You can implement your logic to add the animal to the block list
        // For example, using SharedPreferences to store blocked animals
        val sharedPreferences = getSharedPreferences("BlockListPreferences", MODE_PRIVATE)
        val blockedAnimals = sharedPreferences.getStringSet("blockedAnimals", mutableSetOf()) ?: mutableSetOf()
        blockedAnimals.add(animalName)
        sharedPreferences.edit().putStringSet("blockedAnimals", blockedAnimals).apply()
    }

    private fun showToast(message: String) {
        // You can display a toast message to the user
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}