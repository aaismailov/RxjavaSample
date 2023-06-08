package com.example.rxjava.ui.screens.profile

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.rxjava.databinding.FragmentProfileBinding
import com.example.rxjava.domain.models.User
import com.example.rxjava.ui.screens.login.LoginFragment

class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding
    private var currentUser: User? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)

        @Suppress("DEPRECATION")
        currentUser = if (Build.VERSION.SDK_INT >= 33)
            arguments?.getSerializable(LoginFragment.KEY, User::class.java)
        else
            arguments?.getSerializable(LoginFragment.KEY) as User?

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        currentUser?.let {
            with (binding) {
                profileName.text = it.name
                profileLogin.text = it.login
                profilePassword.text = it.password
            }
        }
    }
}