package com.example.kotlin.rickandmortyapi.framework.adapters.viewholders

import android.content.Context
import android.content.Intent
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.kotlin.rickandmortyapi.data.model.character.Character
import com.example.kotlin.rickandmortyapi.databinding.ItemCharacterBinding
import com.example.kotlin.rickandmortyapi.data.model.CharacterBase
import com.example.kotlin.rickandmortyapi.data.CharacterRepository
import com.example.kotlin.rickandmortyapi.domain.CharacterInfoRequirement
import com.example.kotlin.rickandmortyapi.framework.views.CharacterDetailActivity
import com.example.kotlin.rickandmortyapi.utils.Constants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CharacterViewHolder (private val binding: ItemCharacterBinding):RecyclerView.ViewHolder(binding.root){
    fun bind(item: CharacterBase, context: Context){
        binding.TVName.text = item.name
        getCharacterInfo(item.url,binding.IVPhoto,context)
        binding.llCharacter.setOnClickListener {
            passViewGoToPokemonDetail(item.url,context)
        }
    }
    private fun getCharacterInfo(url:String, imageView: ImageView, context: Context){
        var CharacterStringNumber:String = url.replace("https://rickandmortyapi.com/api/character/","")
        CharacterStringNumber = CharacterStringNumber.replace("/","")
        val characterNumber:Int = Integer.parseInt(CharacterStringNumber)

        CoroutineScope(Dispatchers.IO).launch {
            val characterInfoRequirement = CharacterInfoRequirement()
            val result: Character? = characterInfoRequirement(characterNumber)
            CoroutineScope(Dispatchers.Main).launch {
                val urlImage = result?.image.toString()

                val requestOptions =  RequestOptions()
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .fitCenter()
                    .priority(Priority.HIGH)

                Glide.with(context).load(urlImage)
                    .apply(requestOptions)
                    .into(imageView)
            }
        }
    }
    private fun passViewGoToPokemonDetail(url: String,context:Context){
        var intent: Intent = Intent(context, CharacterDetailActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
        context.startActivity(intent)
        intent.putExtra(Constants.URL_POKEMON,url)
    }
}