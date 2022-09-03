package com.example.mymvvmsample.view.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.mymvvmsample.databinding.ActivityMvvmSampleBinding
import com.example.mymvvmsample.model.CatFactDTO
import com.example.mymvvmsample.view.MvvmSampleViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MvvmSampleActivity : AppCompatActivity() {

    private val viewModel: MvvmSampleViewModel by viewModels()

    private lateinit var binding: ActivityMvvmSampleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMvvmSampleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setup load new fact button
        binding.btnCatFactLoadNew.setOnClickListener {
            viewModel.loadCatFact()
        }

        // Setup view model cat fact observer
        val catFactObserver = Observer<CatFactDTO> { newCatFact ->
            // New cat fact received from API
            binding.txtViewCatFact.text = newCatFact.fact
        }
        viewModel.catFact.observe(this, catFactObserver)

        // Load data at start
        viewModel.loadCatFact()
    }
}