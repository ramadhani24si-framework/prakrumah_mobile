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
            val username = binding.inputUsername.text.toString()
            val password = binding.inputPassword.text.toString()

            // Logika: Username harus sama dengan Password (sesuai materi)
            if (username.isNotEmpty() && username == password) {

                // SIMPAN KE SHAREDPREFERENCES
                val editor = sharedPref.edit()
                editor.putBoolean("isLogin", true)
                editor.putString("username", username)
                editor.apply()

                // PINDAH KE MAIN ACTIVITY
                Toast.makeText(this, "Login Berhasil, Halo $username!", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, MainActivity::class.java))
                finish() // Agar user tidak bisa back ke halaman login lagi

            } else {
                Toast.makeText(this, "Username & Password harus sama!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}