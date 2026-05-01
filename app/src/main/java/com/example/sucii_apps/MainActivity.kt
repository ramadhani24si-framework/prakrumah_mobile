package com.example.sucii_apps

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.sucii_apps.databinding.ActivityMainBinding
// Import activity dari package pertemuan lain
import com.example.sucii_apps.pertemuan_2.SecondActivity
import com.example.sucii_apps.pertemuan_4.FourthActivity
import com.example.sucii_apps.pertemuan_5.WebViewActivity
import com.example.sucii_apps.pertemuan_6.SixthActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 1. Ke Hitung Bangun Ruang (Pertemuan 2)
        binding.btnBangunRuang.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }

        // 2. Ke Pendaftaran Les (Pertemuan 4)
        binding.btnLes.setOnClickListener {
            startActivity(Intent(this, FourthActivity::class.java))
        }

        // 3. Ke Web View (Pertemuan 5)
        binding.btnWebView.setOnClickListener {
            startActivity(Intent(this, WebViewActivity::class.java))
        }

        // 4. Ke Fragment (Pertemuan 6)
        binding.btnPertemuan6.setOnClickListener {
            startActivity(Intent(this, SixthActivity::class.java))
        }

        // 5. Logika Logout
        binding.btnLogout.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Logout")
                .setMessage("Yakin ingin keluar dari SuciiApps?")
                .setPositiveButton("Ya") { _, _ ->
                    val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)
                    sharedPref.edit().clear().apply()

                    // Kembali ke Login (AuthActivity)
                    val intent = Intent(this, AuthActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                .setNegativeButton("Tidak", null)
                .show()
        }
    }
}