package com.chgonzalez.shoestore.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.chgonzalez.shoestore.R
import com.chgonzalez.shoestore.databinding.WelcomeFragmentBinding

class WelcomeFragment : Fragment() {

    private lateinit var viewModel: WelcomeViewModel

    private lateinit var binding: WelcomeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.welcome_fragment, container, false)

        binding.nextButton.setOnClickListener {
            view?.findNavController()
                ?.navigate(WelcomeFragmentDirections.actionWelcomeFragmentToShoeFragment())
        }

        return binding.root
    }

}