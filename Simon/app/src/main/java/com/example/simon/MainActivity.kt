package com.example.simon

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.core.content.ContextCompat
import com.example.simon.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var nivel : Int = 1


        binding.btnStart.setOnClickListener{
            colorRandom(nivel)
        }

        binding.btnRestart.setOnClickListener{
            restart()
        }

    }

    fun colorRandom(nivel : Int) {
        val verde = ContextCompat.getColor(this, R.color.greenB)
        val verdeA = ContextCompat.getColor(this, R.color.greenA)
        val rojo = ContextCompat.getColor(this, R.color.redB)
        val rojoA = ContextCompat.getColor(this, R.color.redA)
        val azul = ContextCompat.getColor(this, R.color.blueB)
        val azulA = ContextCompat.getColor(this, R.color.blueA)
        val amarillo = ContextCompat.getColor(this, R.color.yellowB)
        val amarilloA = ContextCompat.getColor(this, R.color.yellowA)

        val color = Random.nextInt(1,5)
        val handler = Handler()
        val tiempo = 500

            for(i in 1 .. nivel){
                if (color == 1){
                    binding.txtRojo.setBackgroundColor(rojo)
                    val runnable = Runnable {
                        binding.txtRojo.setBackgroundColor(rojoA)
                    }
                    handler.postDelayed(runnable, tiempo.toLong())
                }else if (color == 2) {
                    binding.txtAzul.setBackgroundColor(azul)
                    val runnable = Runnable {
                        binding.txtAzul.setBackgroundColor(azulA)
                    }
                    handler.postDelayed(runnable, tiempo.toLong())
                }else if (color == 3){
                    binding.txtVerde.setBackgroundColor(verde)
                    val runnable = Runnable {
                        binding.txtVerde.setBackgroundColor(verdeA)
                    }
                    handler.postDelayed(runnable, tiempo.toLong())
                } else{
                    binding.txtAmarillo.setBackgroundColor(amarillo)
                    val runnable = Runnable {
                        binding.txtAmarillo.setBackgroundColor(amarilloA)
                    }
                    handler.postDelayed(runnable, tiempo.toLong())
                }
            }
    }

    fun restart(){
        val amarilloA = ContextCompat.getColor(this, R.color.yellowA)
        val verdeA = ContextCompat.getColor(this, R.color.greenA)
        val rojoA = ContextCompat.getColor(this, R.color.redA)
        val azulA = ContextCompat.getColor(this, R.color.blueA)

        binding.txtAmarillo.setBackgroundColor(amarilloA)
        binding.txtVerde.setBackgroundColor(verdeA)
        binding.txtAzul.setBackgroundColor(azulA)
        binding.txtRojo.setBackgroundColor(rojoA)
        val nivel = 1
    }
}