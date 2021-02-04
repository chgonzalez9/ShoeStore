package com.chgonzalez.shoestore.detail

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.chgonzalez.shoestore.R
import com.chgonzalez.shoestore.databinding.DetailFragmentBinding
import com.chgonzalez.shoestore.utils.Shoe

class DetailFragment : Fragment() {

    private lateinit var viewModel: DetailViewModel

    private lateinit var binding: DetailFragmentBinding

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.detail_fragment, container, false)

        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.app_name)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity()).get(DetailViewModel::class.java)

        binding.lifecycleOwner = this

        setHasOptionsMenu(true)

        binding.detailView = Shoe("Set Name", "Shoe Size", "Set Company", "Set Description")

        binding.saveButton.setOnClickListener { view ->
            val shoe = binding.detailView
            viewModel.saveShoes(shoe)

            view.findNavController().navigate(DetailFragmentDirections.actionDetailFragmentToShoeFragment())
        }

        binding.cancelButton.setOnClickListener { view ->
            view.findNavController().navigate(DetailFragmentDirections.actionDetailFragmentToShoeFragment())
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController()) || super.onOptionsItemSelected(item)
    }

}