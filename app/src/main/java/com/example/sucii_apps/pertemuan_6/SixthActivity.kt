package com.example.sucii_apps.pertemuan_6

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.sucii_apps.R // Import R dari package utama
import com.example.sucii_apps.databinding.ActivitySixthBinding

class SixthActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySixthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySixthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 1. Terapkan Toolbar & Tombol Back sesuai materi
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.toolbar.setNavigationOnClickListener { onBackPressed() }

        // 2. Menampilkan fragment pertama secara default
        replaceFragment(SatuFragment())

        // 3. Setup klik tombol untuk ganti fragment
        binding.btnFragment1.setOnClickListener { replaceFragment(SatuFragment()) }
        binding.btnFragment2.setOnClickListener { replaceFragment(DuaFragment()) }
        binding.btnFragment3.setOnClickListener { replaceFragment(TigaFragment()) }
    }

    // Function replaceFragment sesuai materi Pertemuan 6
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment) // ID container di XML
            .addToBackStack(null) // Agar bisa di-back
            .commit()
    }
}