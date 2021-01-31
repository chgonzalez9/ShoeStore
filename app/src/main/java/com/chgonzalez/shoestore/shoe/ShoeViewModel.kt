package com.chgonzalez.shoestore.shoe

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.chgonzalez.shoestore.utils.Shoe

class ShoeViewModel(shoe: Shoe) : ViewModel() {

    private val _shoe = MutableLiveData<ArrayList<Shoe>>()
    val shoe: LiveData<ArrayList<Shoe>>
        get() = _shoe

    init {
        _shoe.value = shoeList()
    }

    private fun shoeList(): ArrayList<Shoe> {
        val shoesList = ArrayList<Shoe>()
        shoesList.add(Shoe("air jordan", "44", "Nike", "Last air jordan"))
        shoesList.add(Shoe("air jordan", "44", "Nike", "Last air jordan"))
        shoesList.add(Shoe("air jordan", "44", "Nike", "Last air jordan"))
        shoesList.add(Shoe("air jordan", "44", "Nike", "Last air jordan"))
        shoesList.add(Shoe("air jordan", "44", "Nike", "Last air jordan"))
        shoesList.add(Shoe("air jordan", "44", "Nike", "Last air jordan"))
        shoesList.add(Shoe("air jordan", "44", "Nike", "Last air jordan"))
        return shoesList
    }

}