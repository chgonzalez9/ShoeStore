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
        holder.size.text = shoe.size.toString()
        holder.company.text = shoe.company
        holder.description.text = shoe.description
    }

    override fun getItemCount(): Int {
        return shoes.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.nameAnswer)
        val size: TextView = view.findViewById(R.id.sizeAnswer)
        val company: TextView = view.findViewById(R.id.companyAnswer)
        val description: TextView = view.findViewById(R.id.descriptionAnswer)
    }

}