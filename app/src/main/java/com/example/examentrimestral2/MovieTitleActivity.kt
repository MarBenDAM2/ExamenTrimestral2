package com.example.examentrimestral2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import com.example.examentrimestral2.databinding.ActivityMainBinding

class MovieTitleActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var nom_peli = ""
        var dur_peli = ""
        var peli_rellena = false
        var dur_rellena = false

        binding.editTextPeli.addTextChangedListener{
            if (!it.isNullOrEmpty() && it.isNotBlank()) {
                nom_peli = it.toString()

                peli_rellena = true
            } else {
                peli_rellena = false
            }
            compBoton(peli_rellena, dur_rellena)
        }

        binding.editTextNumber.addTextChangedListener {
            if (!it.isNullOrEmpty() && it.isNotBlank() && it.toString().toInt() > 0) {
                dur_peli = it.toString()

                dur_rellena = true
            } else {
                dur_rellena = false
            }
            compBoton(peli_rellena, dur_rellena)
        }


        binding.ContinuarButton.setOnClickListener{
            val intent = Intent(this, MovieDetailsActivity::class.java)
            intent.putExtra("nombrepeli", nom_peli)
            intent.putExtra("durpeli", dur_peli)
            startActivity(intent)
        }
    }

    fun compBoton(peli_rellena : Boolean, dur_rellena : Boolean){
        binding.ContinuarButton.isEnabled = peli_rellena && dur_rellena
    }
}