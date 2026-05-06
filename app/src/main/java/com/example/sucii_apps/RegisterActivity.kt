package com.example.sucii_apps

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sucii_apps.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSubmitRegister.setOnClickListener {
            val nama = binding.etNama.text.toString()
            val phone = binding.etPhone.text.toString()
            val user = binding.etUsername.text.toString()
            val pass = binding.etPassword.text.toString()

            // Kirim data ke Activity Verifikasi lewat Intent
            val intent = Intent(this, VerificationActivity::class.java)
            intent.putExtra("EXTRA_NAMA", nama)
            intent.putExtra("EXTRA_PHONE", phone)
            intent.putExtra("EXTRA_USER", user)
            intent.putExtra("EXTRA_PASS", pass)
            startActivity(intent)
        }
    }
}