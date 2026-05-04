package com.example.sucii_apps.Home.pertemuan_4

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.sucii_apps.R
import com.example.sucii_apps.databinding.ActivityFourthBinding

class FourthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFourthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFourthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra("name")
        val from = intent.getStringExtra("from")
        val age = intent.getIntExtra("age", 0)
        val judul = intent.getStringExtra("judul")
        val desc = intent.getStringExtra("desc")

        // Wajib Logcat buat Tugas
        Log.e("DataIntent", "Membuka Halaman: $judul")
        Log.e("DataIntent", "Data: $name, $from, $age tahun")

        binding.tvJudul.text = judul
        binding.tvDesc.text = desc
        binding.tvDetail.text = "🏢 $name | 📍 $from | 🎂 $age Tahun"

        // Ganti gambar header
        if (judul == "Program Les IT") {
            binding.ivHeader.setImageResource(R.drawable.img_les)
        } else {
            binding.ivHeader.setImageResource(R.drawable.img_daftar)
        }

        binding.btnBack.setOnClickListener { finish() }
    }
}