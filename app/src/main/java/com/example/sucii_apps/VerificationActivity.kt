package com.example.sucii_apps

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.example.sucii_apps.databinding.ActivityVerificationBinding

class VerificationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityVerificationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVerificationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Ambil data dari Activity sebelumnya
        val nama = intent.getStringExtra("EXTRA_NAMA")
        val phone = intent.getStringExtra("EXTRA_PHONE")
        val user = intent.getStringExtra("EXTRA_USER")
        val pass = intent.getStringExtra("EXTRA_PASS")

        binding.btnVerify.setOnClickListener {
            val otpInput = binding.etOtp.text.toString()

            // SOAL 2: Cek OTP (OTP harus sama dengan No HP)
            if (otpInput.isNotEmpty() && otpInput == phone) {

                // SOAL 3: Simpan ke SharedPreferences jika berhasil
                val sharedPref = getSharedPreferences("user_pref", Context.MODE_PRIVATE)
                val editor = sharedPref.edit()
                editor.putString("reg_user", user)
                editor.putString("reg_pass", pass)
                editor.apply()

                // Lanjut ke Login
                startActivity(Intent(this, AuthActivity::class.java))
                finish()
            } else {
                // SOAL 2: Error dengan MaterialAlertDialog
                MaterialAlertDialogBuilder(this)
                    .setTitle("Verifikasi Gagal")
                    .setMessage("Kode OTP salah atau kosong!")
                    .setPositiveButton("OK", null)
                    .show()
            }
        }
    }
}