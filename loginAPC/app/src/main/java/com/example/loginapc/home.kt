package com.example.loginapc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.loginapc.databinding.ActivityHomeBinding
import com.google.android.gms.auth.api.identity.Identity
import com.google.firebase.auth.FirebaseAuth

class home : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    private lateinit var firebaseauth: FirebaseAuth
    val TAG = "ACSCO"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_home)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Para la autenticación, de cualquier tipo.
        firebaseauth = FirebaseAuth.getInstance()

        //Recuperamos los datos del login.
        binding.txtEmail.text = intent.getStringExtra("email").toString()
        binding.txtProveedor.text = intent.getStringExtra("provider").toString()
        binding.txtNombre.text = intent.getStringExtra("nombre").toString()

        binding.btCerrarSesion.setOnClickListener {
            Log.e(TAG, firebaseauth.currentUser.toString())
            // Olvidar al usuario, limpiando cualquier referencia persistente
            //comprobadlo en Firebase, como ha desaparecido.
//           firebaseauth.currentUser?.delete()?.addOnCompleteListener { task ->
//               if (task.isSuccessful) {
//                   firebaseauth.signOut()
//                   Log.e(TAG,"Cerrada sesión completamente")
//               } else {
//                   Log.e(TAG,"Hubo algún error al cerrar la sesión")
//               }
//           }
            firebaseauth.signOut()
            val signInClient = Identity.getSignInClient(this)
            signInClient.signOut()
            finish()
        }
    }
}
