package com.example.sucii_apps.Home.pertemuan_3

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.sucii_apps.databinding.ActivityThirdBinding
import com.example.sucii_apps.Home.pertemuan_2.SecondActivity
import com.example.sucii_apps.Home.pertemuan_4.FourthActivity
import com.google.android.material.snackbar.Snackbar

class ThirdActivity : AppCompatActivity() {

    private lateinit var binding: ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // KLIK LOGIN
        binding.btnLogin.setOnClickListener {
            val username = binding.inputUsername.text.toString()
            if (username.isNotEmpty()) {
                // Sembunyikan form login, tampilkan menu dashboard
                binding.layoutLogin.visibility = View.GONE
                binding.layoutDashboard.visibility = View.VISIBLE
                binding.tvTitle.text = "Selamat Datang, $username!"
            } else {
                Toast.makeText(this, "Isi username dulu ya!", Toast.LENGTH_SHORT).show()
            }
        }

        // --- 4 TOMBOL MENU ---

        // 1. Tombol Rumus (P2)
        binding.btnRumus.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }

        // 2. Tombol Les IT (P4 - Kirim data sesuai materi)
        binding.btnLesIT.setOnClickListener {
            val intent = Intent(this, FourthActivity::class.java)
            intent.putExtra("name", "Les IT Suci")
            intent.putExtra("from", "Pekanbaru")
            intent.putExtra("age", 20)
            intent.putExtra("EXTRA_JUDUL", "Program Les IT")
            intent.putExtra("EXTRA_DESC", "Belajar Android Studio dari nol!")
            startActivity(intent)
        }

        // 3. Tombol Pendaftaran
        binding.btnPendaftaran.setOnClickListener {
            val intent = Intent(this, FourthActivity::class.java)
            intent.putExtra("name", "Admin Suci")
            intent.putExtra("from", "Online")
            intent.putExtra("age", 19)
            intent.putExtra("EXTRA_JUDUL", "Info Pendaftaran")
            intent.putExtra("EXTRA_DESC", "Daftar sekarang untuk kelas bulan depan!")
            startActivity(intent)
        }

        // 4. Tombol Logout
        binding.btnLogout.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Konfirmasi Logout")
                .setMessage("Yakin ingin keluar?")
                .setPositiveButton("Ya") { _, _ ->
                    // Kembalikan tampilan ke form login
                    binding.layoutLogin.visibility = View.VISIBLE
                    binding.layoutDashboard.visibility = View.GONE
                    binding.tvTitle.text = "Login"
                    binding.inputUsername.text.clear()
                    binding.inputPassword.text.clear()
                }
                .setNegativeButton("Tidak") { _, _ ->
                    Snackbar.make(binding.root, "Logout dibatalkan",
                        Snackbar.LENGTH_SHORT).show()
                }
                .show()
        }
    }
}