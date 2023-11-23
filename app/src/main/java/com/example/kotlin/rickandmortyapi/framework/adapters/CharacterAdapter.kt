package com.example.kotlin.rickandmortyapi.framework.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.rickandmortyapi.data.model.CharacterBase
import com.example.kotlin.rickandmortyapi.framework.adapters.viewholders.CharacterViewHolder
import com.example.kotlin.rickandmortyapi.databinding.ItemCharacterBinding

class CharacterAdapter: RecyclerView.Adapter<CharacterViewHolder>() {
    var data:ArrayList<CharacterBase> = ArrayList()
    lateinit var context: Context
    fun CharacterAdapter(basicData : ArrayList<CharacterBase>, context: Context){
        this.data = basicData
        this.context = context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding = ItemCharacterBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CharacterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item, context)
    }

    override fun getItemCount(): Int {
        return data.size
    }

}