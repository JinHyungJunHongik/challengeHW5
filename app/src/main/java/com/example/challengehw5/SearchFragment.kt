package com.example.challengehw5

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.challengehw5.R
import com.example.challengehw5.databinding.FragmentSearchBinding
import com.example.challengehw5.model.SearchEntity

class SearchFragment : Fragment() {
    lateinit var binding : FragmentSearchBinding
    lateinit var data: LiveData<SearchEntity.SearchImageEntity>
    lateinit var viewModel: SearchViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(this, SearchViewModel.SearchViewModelFactory())[SearchViewModel::class.java]
        viewModel.onSearch("수영")
        data = viewModel._responseData
        data.observe(viewLifecycleOwner){
            binding.recyclerApiTest.adapter = it.documents?.let { it1 -> SearchDataAdapter(it1) }
        }
        binding.recyclerApiTest.layoutManager = LinearLayoutManager(this.context)
        super.onViewCreated(view, savedInstanceState)
    }

}