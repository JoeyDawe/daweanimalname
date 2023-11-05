package com.dawe.animal.midterm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AnimalNamesAdapter(private val animalNames: List<AnimalName>) :
    RecyclerView.Adapter<AnimalNamesAdapter.AnimalNameViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalNameViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.tvanimalname, parent, false)
        return AnimalNameViewHolder(view)
    }

    override fun onBindViewHolder(holder: AnimalNameViewHolder, position: Int) {
        val animalName = animalNames[position]
        holder.bind(animalName)
    }

    override fun getItemCount(): Int {
        return animalNames.size
    }

    class AnimalNameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.animal_name)

        fun bind(animalName: AnimalName) {
            nameTextView.text = animalName.name
        }
    }
}