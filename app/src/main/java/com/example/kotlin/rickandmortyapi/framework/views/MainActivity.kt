package com.example.kotlin.rickandmortyapi.framework.views

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.kotlin.rickandmortyapi.R
import com.example.kotlin.rickandmortyapi.databinding.ActivityMainBinding
import com.example.kotlin.rickandmortyapi.framework.fragments.RickAndMortyFragment
import com.example.kotlin.rickandmortyapi.framework.fragments.SearchFragment
import com.example.kotlin.rickandmortyapi.framework.viewmodel.MainVIewModel
import com.example.kotlin.rickandmortyapi.utils.Constants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity:AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainVIewModel by viewModels()
    private lateinit var currentFragment: Fragment
    private var currentMenuOption:String?= null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initializeBinding()
        initializeObservers()
        initializeListeners()
        exchangeCurrentFragment(RickAndMortyFragment(), Constants.MENU_RICKANDMORTY)
    }
    private fun initializeBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun initializeObservers(){


    }
    private fun initializeListeners(){
        binding.appBarMain.llRickAndMorty.setOnClickListener{
            selectMenuOption(Constants.MENU_RICKANDMORTY)
        }
        binding.appBarMain.llSearch.setOnClickListener{
            selectMenuOption(Constants.MENU_SEARCH)
        }
    }
    private fun exchangeCurrentFragment(newFragment: Fragment, newMenuOption: String){
        currentFragment = newFragment

        supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment_content_main,currentFragment)
            .commit()

        currentMenuOption = newMenuOption
    }
    private fun selectMenuOption(menuOption:String){
        if(menuOption == currentMenuOption){
            return
        }
        when(menuOption){
            Constants.MENU_RICKANDMORTY -> exchangeCurrentFragment(RickAndMortyFragment(),Constants.MENU_RICKANDMORTY)
            Constants.MENU_SEARCH -> exchangeCurrentFragment(SearchFragment(),Constants.MENU_SEARCH)
        }
    }
}

