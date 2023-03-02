package com.example.examentrimestral2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import com.example.examentrimestral2.databinding.ActivityMovieDetailsBinding

class MovieDetailsActivity : AppCompatActivity() {
    lateinit var binding : ActivityMovieDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)
        binding = ActivityMovieDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var nom_direc = ""
        var direc_relleno = false
        var fecha = ""
        var fecha_rellena = false

        val nom_peli = intent.getStringExtra("nombrepeli")
        val dur_peli = intent.getStringExtra("durpeli")

        binding.editTextNomDirec.addTextChangedListener{
            if (!it.isNullOrEmpty() && it.isNotBlank()) {
                nom_direc = it.toString()

                direc_relleno = true
            } else {
                direc_relleno = false
            }
            compBoton(direc_relleno, fecha_rellena)
        }

        binding.editTextLanzamiento.addTextChangedListener {
            if (!it.isNullOrEmpty() && it.isNotBlank() && it.toString().toInt() >= 1900) {
                fecha = it.toString()

                fecha_rellena = true
            } else {
                fecha_rellena = false
            }
            compBoton(direc_relleno, fecha_rellena)
        }

        binding.botonFinalizar.setOnClickListener {

            val intent = Intent(this, MovieDisplayActivity::class.java)
            //PutExtra de MovieTitle
            intent.putExtra("nombrepeli", nom_peli)
            intent.putExtra("durpeli", dur_peli)
            //PutExtra de MovieDetails
            intent.putExtra("nomdirec", nom_direc)
            intent.putExtra("fecha",fecha)
            startActivity(intent)

        }

        binding.buttonVolverInicio.setOnClickListener {
            val intent = Intent(this, MovieTitleActivity::class.java)
            startActivity(intent)
        }
    }
    fun compBoton(direc_relleno : Boolean, fecha_rellena : Boolean){
        binding.botonFinalizar.isEnabled = direc_relleno && fecha_rellena
    }
}