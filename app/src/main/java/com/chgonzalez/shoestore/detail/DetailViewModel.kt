package com.chgonzalez.shoestore.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.chgonzalez.shoestore.utils.Shoe

class DetailViewModel : ViewModel() {

    // shoe list encapsulation
    private val _shoe = MutableLiveData<MutableList<Shoe>>(mutableListOf())
    val shoe: LiveData<MutableList<Shoe>>
        get() = _shoe

    // funtion to add strings to the list using Shoe data class
    fun saveShoes(detail: Shoe?) {
        detail?.let { shoe ->
            _shoe.value?.add(shoe)
        }
    }

}