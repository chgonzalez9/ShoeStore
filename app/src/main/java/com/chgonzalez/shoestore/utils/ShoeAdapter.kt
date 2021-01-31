package com.chgonzalez.shoestore.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.chgonzalez.shoestore.R
import com.chgonzalez.shoestore.databinding.ListItemsBinding

class ShoeAdapter(private var shoes: MutableList<Shoe>) :
    RecyclerView.Adapter<ShoeAdapter.ViewHolder>() {

    var data = listOf<Shoe>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    private lateinit var binding: ListItemsBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoeAdapter.ViewHolder {
        binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.list_items,
                parent,
                false
        )

        return ViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ShoeAdapter.ViewHolder, position: Int) {
        val shoe = shoes[position]

        holder.name.text = shoe.name
        holder.company.text = shoe.company
    }

    override fun getItemCount(): Int {
        return shoes.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.nameAnswer)
        val company: TextView = view.findViewById(R.id.companyAnswer)
    }
}