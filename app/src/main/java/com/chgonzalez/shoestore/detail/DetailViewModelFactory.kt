package com.chgonzalez.shoestore.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.chgonzalez.shoestore.utils.Shoe

class DetailViewModelFactory(private val shoes: Shoe) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailViewModel(shoes) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}