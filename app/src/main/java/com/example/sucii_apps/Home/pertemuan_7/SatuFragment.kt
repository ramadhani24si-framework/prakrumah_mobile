package com.example.sucii_apps.Home.pertemuan_7

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sucii_apps.R

class SatuFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Cukup baris ini saja yang tersisa untuk memanggil layout XML
        return inflater.inflate(R.layout.fragment_satu, container, false)
    }
}