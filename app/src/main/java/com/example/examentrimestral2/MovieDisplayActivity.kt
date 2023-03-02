package com.example.examentrimestral2

import Movie
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.examentrimestral2.databinding.ActivityMovieDisplayBinding

class MovieDisplayActivity : AppCompatActivity() {
    lateinit var binding : ActivityMovieDisplayBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_display)
        binding = ActivityMovieDisplayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nom_peli = intent.getStringExtra("nombrepeli")
        val dur_peli = intent.getStringExtra("durpeli")
        val nom_direc = intent.getStringExtra("nomdirec")
        val fecha = intent.getStringExtra("fecha")
        var boton_pulsado = false


        binding.buttonVolver.setOnClickListener{
            val intent = Intent(this, MovieTitleActivity::class.java)
            startActivity(intent)
        }

        //Pelicula de tipo Movie
        val peli : Movie = Movie(
                nom_peli.toString(),
                dur_peli.toString(),
                nom_direc.toString(),
                fecha.toString()
        )

        binding.button2.setOnClickListener{

            if (!boton_pulsado) {
                //Datos de pelicula
                binding.textViewPeli.text = peli.nombre
                binding.textViewPeli.visibility = View.VISIBLE

                //Datos de Duracion
                binding.textViewDuracion.text = peli.duracion
                binding.textViewDuracion.visibility = View.VISIBLE

                //Datos de Director
                binding.textViewDirector.text = peli.director
                binding.textViewDirector.visibility = View.VISIBLE

                //Datos de lanzamiento
                binding.textViewLanzamiento.text = peli.lanzamiento
                binding.textViewLanzamiento.visibility = View.VISIBLE

                boton_pulsado = true
            } else {
                binding.textViewPeli.text = "No hay pelicula favorita"

                binding.textViewDuracion.visibility = View.GONE

                binding.textViewDirector.visibility = View.GONE

                binding.textViewLanzamiento.visibility = View.GONE

                boton_pulsado = false
            }

        }

    }
}