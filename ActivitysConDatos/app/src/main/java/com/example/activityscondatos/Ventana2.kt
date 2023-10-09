package com.example.activityscondatos

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.activityscondatos.databinding.ActivityMainBinding
import com.example.activityscondatos.databinding.ActivityVentana2Binding
import modelo.AlmacenPersonas
import modelo.Persona

class Ventana2 : AppCompatActivity() {
    lateinit var binding: ActivityVentana2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVentana2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        var nombre = intent.getStringExtra("Nombre")
        var edad = intent.getStringExtra("Edad")

        binding.cajaEdad.setText(nombre)
        binding.cajaEdad.setText(edad)

        binding.boton.setOnClickListener{
            finish()
        }

        val persona : Persona =Persona(nombre, edad)
        AlmacenPersonas.aniadirPersona(persona)
        var cadena: String = ""
        var i:Int = 1
        for (p in AlmacenPersonas.personas) {
            cadena += " " + i + " " + p.nombre + " " + p.edad + "\n"
            i++
            binding.multiLine.setText(cadena)
        }
    }
}