package Objetos

import android.graphics.drawable.Drawable
import com.example.fireemblemrecycleview.R
import java.io.Serializable
import java.util.ArrayList

class Protagonista (var nombre:String, var juego:String, var imagen:Int){
    fun crearPersonaje():Protagonista{
        val roy : Int = R.drawable.roy
        val corrin : Int = R.drawable.corrin
        val daraen : Int = R.drawable.daraen
        val byleth : Int = R.drawable.byleth
        var nombre = listOf<String>("Roy", "Byleth", "Corrin", "Daraen")
        var juego = listOf<String>("3 Houses","Awekening","Fates","Espada de los sellos")
        var imagen = listOf<Int>(roy, corrin, daraen, byleth)

        var p= Protagonista(nombre.random(), juego.random(), imagen.random())
        return p
    }

    fun generarPersonajes(cant : Int):ArrayList<Protagonista>{
        var lista = ArrayList<Protagonista>(1)
        for (i in 1 .. cant){
            lista.add(crearPersonaje())
        }
        return lista
    }

}