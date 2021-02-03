package com.chgonzalez.shoestore.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.chgonzalez.shoestore.utils.Shoe

class DetailViewModel : ViewModel() {

    private val _shoe = MutableLiveData<MutableList<Shoe>>(mutableListOf())
    val shoe: LiveData<MutableList<Shoe>>
        get() = _shoe

    fun saveShoes(detail: Shoe?) {
        detail?.let { shoe ->
            _shoe.value?.add(shoe)
        }
    }

}