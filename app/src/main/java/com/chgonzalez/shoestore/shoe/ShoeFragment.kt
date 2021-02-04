package com.chgonzalez.shoestore.shoe

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.chgonzalez.shoestore.R
import com.chgonzalez.shoestore.databinding.ShoeFragmentBinding
import com.chgonzalez.shoestore.detail.DetailViewModel
import com.chgonzalez.shoestore.utils.Shoe
import com.chgonzalez.shoestore.utils.ShoeAdapter

class ShoeFragment : Fragment() {

    private lateinit var binding: ShoeFragmentBinding

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.shoe_fragment, container, false)

        // fragment title in the action bar
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.app_name)

        // navigation to detail screen to add elements
        binding.addItemButton.setOnClickListener { view ->
            view.findNavController().navigate(ShoeFragmentDirections.actionShoeFragmentToDetailFragment())
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val detailViewModel = ViewModelProvider(requireActivity()).get(DetailViewModel::class.java)

        // setup binding for LiveData to know to observe this LifecycleOwner
        binding.lifecycleOwner = this

        // let android know this fragment have a menu
        setHasOptionsMenu(true)

        // observe for detailviewmodel to take all the information about the shoe
        detailViewModel.shoe.observe(viewLifecycleOwner, { shoes ->
            if (shoes.isNotEmpty()) {
                newShoes(shoes)
            }
        })

    }

    // logout menu inflater
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout_menu, menu)
    }

    // back arrow
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController()) || super.onOptionsItemSelected(item)
    }

    // addView funtion to add new element to the list
    private fun newShoes(shoes: List<Shoe>) {
        context?.let { context ->
            val container = binding.shoeList
            shoes.forEach { shoe ->
                val shoeLayout = ShoeAdapter(context)
                shoeLayout.loadShoe(shoe)
                container.addView(shoeLayout)
            }
        }
    }

}