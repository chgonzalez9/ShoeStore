package com.chgonzalez.shoestore.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
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

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)

        binding.lifecycleOwner = this

        binding.saveButton.setOnClickListener { view ->

            viewModel.saveCurrentDetail(binding.detailView)

            view.findNavController()
                .navigate(DetailFragmentDirections.actionDetailFragmentToShoeFragment())
        }

        binding.cancelButton.setOnClickListener { view ->
            view.findNavController()
                .navigate(DetailFragmentDirections.actionDetailFragmentToShoeFragment())
        }
    }
}