package com.chgonzalez.shoestore.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.chgonzalez.shoestore.R
import com.chgonzalez.shoestore.databinding.DetailFragmentBinding

class DetailFragment : Fragment() {

    private lateinit var viewModel: DetailViewModel

    private lateinit var viewModelFactory: DetailViewModelFactory

    private lateinit var binding: DetailFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.detail_fragment, container, false)
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)

        return binding.root
    }

}