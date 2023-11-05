package com.dawe.animal.midterm

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AnimalNamesAct : AppCompatActivity() {

    private val animalNamesList = mutableListOf<AnimalName>()
    private lateinit var recyclerView: RecyclerView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.list_animal)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Populate the list with animal names (you can replace this with your own data)
        animalNamesList.addAll(getAnimalNames())

        // Create an adapter and set it to the RecyclerView
        val adapter = AnimalNamesAdapter(animalNamesList)
        recyclerView.adapter = adapter
    }

    private fun getAnimalNames(): List<AnimalName> {
        // Replace this with your list of animal names sorted from A to Z
        return listOf(
            AnimalName("Aardvark"),
            AnimalName("Bear"),
            AnimalName("Cheetah"),
            AnimalName("Dodo"),
            AnimalName("Elephant"),
            AnimalName("Flamingo"),
            AnimalName("Giraffe"),
            AnimalName("Hippopotamus"),
            AnimalName("Iguana"),
            AnimalName("Jaguar"),
            AnimalName("Koala"),
            AnimalName("Lion"),
            AnimalName("Monkey"),
            AnimalName("Narwhal"),
            AnimalName("Orangutan"),
            AnimalName("Penguin"),
            AnimalName("Quokka"),
            AnimalName("Raccoon"),
            AnimalName("Sloth"),
            AnimalName("Tiger"),
            AnimalName("Uakari"),
            AnimalName("Vulture"),
            AnimalName("Walrus"),
            AnimalName("Xenopus"),
            AnimalName("Yak"),
            AnimalName("Zebra")
        )
    }
}