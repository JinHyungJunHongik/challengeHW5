package com.example.challengehw5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.challengehw5.databinding.ActivityMainBinding
import com.example.challengehw5.model.SearchEntity
import com.google.android.material.tabs.TabLayoutMediator

val bookMarkList = mutableListOf<SearchEntity.ImageDocumentEntity>()
class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
        setContentView(binding.root)
    }


    private fun init(){
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.viewPager.adapter = TestAdapter(this)
        TabLayoutMediator(binding.tabs, binding.viewPager){tab, position ->
            when(position){
                0 -> tab.text = "Search"
                else -> tab.text = "BookMark"
            }
        }.attach()
    }
}