package com.example.imagenesyaudio

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.imagenesyaudio.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var mediaPlayer : MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mediaPlayer = MediaPlayer.create(this, R.raw.cry)

        binding.imgbtnIzquierdo.setOnClickListener{
            mediaPlayer.start()
            binding.imgJuego.setImageResource(R.drawable.ic_juego_rojo)
        }

        binding.imgbtnDerecho.setOnClickListener{
            binding.imgJuego.setImageResource(R.drawable.ic_juego_verde)
            mediaPlayer.stop()
        }
    }
}