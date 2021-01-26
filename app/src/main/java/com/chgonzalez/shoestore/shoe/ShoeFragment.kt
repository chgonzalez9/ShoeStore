package com.chgonzalez.shoestore.shoe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.chgonzalez.shoestore.R
import com.chgonzalez.shoestore.databinding.ShoeFragmentBinding
import com.chgonzalez.shoestore.detail.DetailViewModel
import com.chgonzalez.shoestore.utils.ShoeAdapter

class ShoeFragment : Fragment() {

    private lateinit var viewModel: DetailViewModel

    private lateinit var binding: ShoeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.shoe_fragment, container, false)

        binding.addItemButton.setOnClickListener { view ->
            view.findNavController()
                .navigate(ShoeFragmentDirections.actionShoeFragmentToDetailFragment())
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(DetailViewModel::class.java)
        binding.lifecycleOwner = this

        viewModel.shoe.observe(viewLifecycleOwner, { shoes ->
            if (shoes.isNotEmpty()) {
                val recyclerView: RecyclerView = binding.shoeList
                recyclerView.adapter = ShoeAdapter(shoes)
            }
        })

    }

}