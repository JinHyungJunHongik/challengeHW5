package com.example.challengehw5

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.challengehw5.data.SearchRepositoryImpl
import com.example.challengehw5.model.SearchEntity
import com.example.challengehw5.network.RetrofitClient
import com.example.challengehw5.repository.SearchRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.http.Query

class SearchViewModel(
    private val searchRepository: SearchRepository
): ViewModel() {
    private val responseData : MutableLiveData<SearchEntity.SearchImageEntity> = MutableLiveData()
    val _responseData : LiveData<SearchEntity.SearchImageEntity> get() = responseData
    fun onSearch(query: String)  {
        CoroutineScope(Dispatchers.IO).launch {
            val response = searchRepository.getSearchImage(query)
            responseData.postValue(response)
            Log.d("확인", "${_responseData.value.toString()}")
        }
    }

    class SearchViewModelFactory : ViewModelProvider.Factory {

        override fun <T : ViewModel> create(
            modelClass: Class<T>,
            extras: CreationExtras
        ): T {

            return SearchViewModel(
                SearchRepositoryImpl(RetrofitClient.search)
            ) as T
        }
    }
}