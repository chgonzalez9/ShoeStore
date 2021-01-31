package com.chgonzalez.shoestore.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.chgonzalez.shoestore.utils.Shoe

class DetailViewModel(shoes: Shoe) : ViewModel() {

    private val _shoe = MutableLiveData<Shoe>()
    val shoe: LiveData<Shoe>
        get() = _shoe

    init {
        _shoe.value = shoes
    }
}