package com.example.challengehw5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.challengehw5.R
import com.example.challengehw5.databinding.FragmentBookMarkBinding
import com.example.challengehw5.model.SearchEntity

class BookMarkFragment : Fragment() {
    lateinit var binding : FragmentBookMarkBinding
    lateinit var viewModel: SearchViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBookMarkBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity(), SearchViewModel.SearchViewModelFactory())[SearchViewModel::class.java]
        viewModel._bookMarkData.observe(viewLifecycleOwner){
            binding.recyclerBookmark.adapter = SearchDataAdapter(it, object : OnItemClick{
                override fun onSwichCilick(data: SearchEntity.ImageDocumentEntity) {
                    bookMarkList.remove(data)
                    (binding.recyclerBookmark.adapter as SearchDataAdapter).notifyDataSetChanged()
                }
            })
        }
        binding.recyclerBookmark.layoutManager = LinearLayoutManager(this.context)
    }

}