package com.example.challengehw5

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.challengehw5.BookMarkFragment
import com.example.challengehw5.SearchFragment

class TestAdapter(activity: FragmentActivity): FragmentStateAdapter(activity) {
    val fragmentList = listOf<Fragment>(
        SearchFragment(),
        BookMarkFragment()
    )
    override fun getItemCount(): Int {
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
       return fragmentList[position]
    }
}