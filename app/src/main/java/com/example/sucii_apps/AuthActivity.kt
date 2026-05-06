package com.example.sucii_apps

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.sucii_apps.databinding.ActivityAuthBinding

class AuthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPref = getSharedPreferences("user_pref", Context.MODE_PRIVATE)

        binding.btnLogin.setOnClickListener {
            val usernameInput = binding.inputUsername.text.toString()
            val passwordInput = binding.inputPassword.text.toString()

            // SOAL 3: Ambil data username & password yang tersimpan saat Registrasi
            val registeredUser = sharedPref.getString("reg_user", null)
            val registeredPass = sharedPref.getString("reg_pass", null)

            // SOAL 3: Terapkan 2 Rule Login
            // Rule 1: Jika username = password (sesuai praktikum)
            val isRuleDefault = (usernameInput.isNotEmpty() && usernameInput == passwordInput)

            // Rule 2: Jika cocok dengan data di SharedPreferences
            val isRuleRegistered = (registeredUser != null && registeredPass != null &&
                    usernameInput == registeredUser && passwordInput == registeredPass)

            if (isRuleDefault || isRuleRegistered) {
                // Simpan status login
                val editor = sharedPref.edit()
                editor.putBoolean("isLogin", true)
                editor.putString("username", usernameInput)
                editor.apply()

                Toast.makeText(this, "Login Berhasil, Halo $usernameInput!", Toast.LENGTH_SHORT).show()

                // Pindah ke BaseActivity
                startActivity(Intent(this, BaseActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Login Gagal! Cek kembali username & password", Toast.LENGTH_SHORT).show()
            }
        }

        // Jangan lupa tambahkan tombol navigasi ke RegisterActivity di sini
        binding.btnToRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}