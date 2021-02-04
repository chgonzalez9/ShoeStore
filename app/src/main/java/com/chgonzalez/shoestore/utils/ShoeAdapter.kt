package com.chgonzalez.shoestore.utils

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import com.chgonzalez.shoestore.R
import com.chgonzalez.shoestore.databinding.ListItemsBinding

// adapter to addViews to the shoe list
class ShoeAdapter : LinearLayout {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    private val binding: ListItemsBinding = DataBindingUtil.inflate(
            LayoutInflater.from(context), R.layout.list_items, this, false)

    fun loadShoe(shoe: Shoe) {
        binding.apply {
            addView(this.root)
            nameAnswer.text = shoe.name
            companyAnswer.text = shoe.company
            sizeAnswer.text = shoe.size
            descriptionAnswer.text = shoe.description
        }
    }
}