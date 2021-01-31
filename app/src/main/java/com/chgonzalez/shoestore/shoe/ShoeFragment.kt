package com.chgonzalez.shoestore.shoe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.chgonzalez.shoestore.R
import com.chgonzalez.shoestore.databinding.ShoeFragmentBinding
import com.chgonzalez.shoestore.utils.ShoeAdapter

class ShoeFragment : Fragment() {

    private lateinit var viewModel: ShoeViewModel

    private lateinit var binding: ShoeFragmentBinding

    private lateinit var adapter: ShoeAdapter

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.shoe_fragment, container, false)

        viewModel = ViewModelProvider(this).get(ShoeViewModel::class.java)

        binding.lifecycleOwner = this

        binding.shoeList.adapter = adapter

        viewModel.shoe.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.data = it
            }
        })


        return binding.root
    }
}