package com.example.rxjava.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rxjava.databinding.ActivityMainBinding
import com.example.rxjava.ui.screens.login.LoginFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if(savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                .add(binding.fragmentContainerView.id,LoginFragment())
                .commit()
        }
    }
}