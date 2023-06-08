package com.example.rxjava.ui.screens.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.rxjava.R
import com.example.rxjava.data.SingleResult
import com.example.rxjava.databinding.FragmentLoginBinding
import com.example.rxjava.ui.screens.profile.ProfileFragment
import com.jakewharton.rxbinding3.view.clicks
import com.jakewharton.rxbinding3.widget.textChanges
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import java.util.concurrent.TimeUnit

class LoginFragment : Fragment() {

    private lateinit var viewModel: LoginViewModel
    private lateinit var binding: FragmentLoginBinding
    private val compositeDisposables = CompositeDisposable()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        compositeDisposables.add(
            Observable.combineLatest(
                binding.textLogin.textChanges(),
                binding.textPassword.textChanges()
            ) { login, password -> login.isNotEmpty() && password.isNotEmpty() }
                .debounce(DEBOUNCE, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { binding.enterBtn.isEnabled = it }
        )

        compositeDisposables.add(
            binding.enterBtn.clicks()
                .switchMapSingle {
                    viewModel.login(
                        binding.textLogin.text.toString(),
                        binding.textPassword.text.toString()
                    )
                }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(::btnClickResult)
        )
    }

    private fun btnClickResult(userResult: SingleResult ) {
        when (userResult) {
            is SingleResult.Success -> {
                val profileFragment = ProfileFragment().apply {
                    arguments = bundleOf(KEY to userResult.data)
                }

                parentFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragmentContainerView, profileFragment)
                    .commit()
            }
            is SingleResult.Error -> {
                Toast.makeText(requireActivity(), userResult.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        compositeDisposables.clear()
    }

    companion object {
        const val KEY = "user_key"
        private const val DEBOUNCE = 400L
    }
}