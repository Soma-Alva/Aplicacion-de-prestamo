package com.example.appprestamo

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle;
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nombre: EditText = findViewById(R.id.editTextTextPersonName)
        val apellido: EditText = findViewById(R.id.editTextTextPersonName2)
        val telefono: EditText = findViewById(R.id.editTextNumber)
        val cedula: EditText = findViewById(R.id.editTextTextPersonName5)
        val direccion: EditText = findViewById(R.id.editTextTextPersonName6)


        val spinner: Spinner = findViewById(R.id.spinner)
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            this,
            R.array.sexo,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }

        val siguiente: Button = findViewById(R.id.button)
        siguiente.setOnClickListener {
            if (nombre.text.toString().isEmpty()) {
                Toast.makeText(this, "Campo nombre vacio", Toast.LENGTH_LONG).show()
            } else {
                if (apellido.text.toString().isEmpty()) {
                    Toast.makeText(this, "Campo apellido vacio", Toast.LENGTH_LONG).show()
                } else {
                    if (telefono.text.toString().isEmpty()) {
                        Toast.makeText(this, "Campo telefono vacio", Toast.LENGTH_LONG).show()
                    } else {
                        if (cedula.text.toString().isEmpty()) {
                            Toast.makeText(this, "Campo cedula vacio", Toast.LENGTH_LONG).show()
                        } else {
                            if (direccion.text.toString().isEmpty()) {
                                Toast.makeText(this, "Campo direccion vacio", Toast.LENGTH_LONG)
                                    .show()
                            } else {
                                datosPublicos.nombre = nombre.text.toString()
                                datosPublicos.cedula = cedula.text.toString()
                                datosPublicos.apellido = apellido.text.toString()

                                val lanzar = Intent(this, MainActivity2::class.java)
                                startActivity(lanzar)
                            }

                        }
                    }
                }
            }
        }
    }

    class SpinnerActivity : Activity(), AdapterView.OnItemSelectedListener {

        override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long) {
            val spinner: Spinner = findViewById(R.id.spinner)
            spinner.onItemSelectedListener = this
        }

        override fun onNothingSelected(parent: AdapterView<*>) {
            // Another interface callback
        }
    }
}
