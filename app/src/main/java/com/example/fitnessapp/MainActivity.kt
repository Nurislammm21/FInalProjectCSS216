package com.example.fitnessapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.activityViewModels
import com.example.fitnessapp.databinding.ActivityMainBinding
import com.example.fitnessapp.fragments.DaysFragment
import com.example.fitnessapp.utils.FragmentManager
import com.example.fitnessapp.utils.MainViewModel

class MainActivity : AppCompatActivity() {
    private val model : MainViewModel by viewModels()
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        model.pref = getSharedPreferences("main", MODE_PRIVATE)
        FragmentManager.setFragment(DaysFragment.newInstance(),this)
    }

    override fun onBackPressed() {
        if(FragmentManager.currentFragment is DaysFragment) super.onBackPressed()
        else FragmentManager.setFragment(DaysFragment.newInstance(), this)



    }
}