package com.chgonzalez.shoestore.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.chgonzalez.shoestore.R
import com.chgonzalez.shoestore.databinding.LoginFragmentBinding
import com.chgonzalez.shoestore.utils.User

class LoginFragment : Fragment() {

    private lateinit var binding: LoginFragmentBinding

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.login_fragment, container, false)

        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.app_name)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lifecycleOwner = this

        binding.loginButton.setOnClickListener {
            setUser()

            if (authenticated()) {
                view.findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
            } else {
                Toast.makeText(context, getString(R.string.toastText), Toast.LENGTH_LONG).show()
            }
        }

        binding.registerText.setOnClickListener {
            setUser()

            if (authenticated()) {
                view.findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
            } else {
                Toast.makeText(context, getString(R.string.toastText), Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun authenticated(): Boolean {

        // Note: only validating email/password are not empty
        return !binding.user?.email?.isEmpty()!! &&
                !binding.user?.password?.isEmpty()!!
    }

    private fun setUser() {
        binding.user = User(
                binding.emailAddressText.text.toString(),
                binding.passwordText.text.toString()
        )
    }

}