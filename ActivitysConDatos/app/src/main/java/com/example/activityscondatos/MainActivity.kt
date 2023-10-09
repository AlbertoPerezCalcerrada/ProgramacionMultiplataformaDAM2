package com.example.activityscondatos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Telephony.Mms.Intents
import com.example.activityscondatos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.boton.setOnClickListener{
            IrVentana2()
        }
    }

    private fun IrVentana2() {
        var miIntent: Intent = Intent(this, Ventana2::class.java)
        miIntent.putExtra("Nombre", binding.cajaNombre.text.toString())
        miIntent.putExtra("Edad", binding.cajaEdad.text.toString())
        startActivity(miIntent)
    }
}