package com.example.sucii_apps

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sucii_apps.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Dibiarkan kosong karena Dashboard pindah ke ThirdActivity
    }
}