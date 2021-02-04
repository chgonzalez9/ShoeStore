package com.chgonzalez.shoestore.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
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

        // fragment title in the action bar
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.app_name)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity()).get(DetailViewModel::class.java)

        // setup binding for LiveData to know to observe this LifecycleOwner
        binding.lifecycleOwner = this

        //
        binding.detailView = Shoe("Set Name", "Shoe Size", "Set Company", "Set Description")

        // navigation to shoe list adding new element to the list
        binding.saveButton.setOnClickListener { view ->
            val shoe = binding.detailView
            viewModel.saveShoes(shoe)

            view.findNavController().navigateUp()
        }

        // navigation to shoe list without adding new element to the list
        binding.cancelButton.setOnClickListener { view ->
            view.findNavController().navigateUp()
        }
    }

    // back arrow
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController()) || super.onOptionsItemSelected(item)
    }

}