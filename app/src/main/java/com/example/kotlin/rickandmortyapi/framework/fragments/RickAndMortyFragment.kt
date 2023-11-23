package com.example.kotlin.rickandmortyapi.framework.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.rickandmortyapi.R
import com.example.kotlin.rickandmortyapi.data.model.CharacterBase
import com.example.kotlin.rickandmortyapi.databinding.FragmentRickandmortyBinding
import com.example.kotlin.rickandmortyapi.framework.adapters.CharacterAdapter
import com.example.kotlin.rickandmortyapi.framework.viewmodel.CharacterViewModel

class RickAndMortyFragment: Fragment() {
    private var _binding: FragmentRickandmortyBinding? = null

    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!

    private lateinit var viewModel: CharacterViewModel

    private lateinit var recyclerView: RecyclerView
    private val adapter : CharacterAdapter = CharacterAdapter()
    private lateinit var data:ArrayList<CharacterBase>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this)[CharacterViewModel::class.java]

        _binding = FragmentRickandmortyBinding.inflate(inflater, container, false)
        val root: View = binding.root

        data = ArrayList()

        initializeComponents(root)
        initializeObservers()
        viewModel.getCharacterList()

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    private fun initializeComponents(root:View){
        recyclerView = root.findViewById(R.id.RVRickAndMorty)
    }
    private fun initializeObservers() {
        viewModel.rickAndMortyObjectLiveData.observe(viewLifecycleOwner) { rickAndMortyObject ->
            if (rickAndMortyObject != null) {
                setUpRecyclerView(rickAndMortyObject.results)
            }
        }
    }
    private fun setUpRecyclerView(dataForList:ArrayList<CharacterBase>){
        recyclerView.setHasFixedSize(true)
       /* val linearLayoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.VERTICAL,
            false)*/
        val gridLayoutManager = GridLayoutManager(
            requireContext(),
            3,
            GridLayoutManager.VERTICAL,
            false    )
        recyclerView.layoutManager = gridLayoutManager
        adapter.CharacterAdapter(dataForList,requireContext())
        recyclerView.adapter = adapter
    }

}