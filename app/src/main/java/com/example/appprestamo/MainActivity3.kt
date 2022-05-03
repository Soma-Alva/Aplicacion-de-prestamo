package com.example.appprestamo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        val pasarNombre: TextView = findViewById(R.id.textView22)
        val pasarCedula: TextView = findViewById(R.id.textView35)
        val pasarFechaInicio: TextView = findViewById(R.id.textView29)
        val pasarFechaFin: TextView = findViewById(R.id.textView34)
        val pasarCuotas: TextView = findViewById(R.id.textView33)
        val pasarTotalPagar: TextView = findViewById(R.id.textView37)
        val pasarApellido: TextView = findViewById(R.id.textView23)

        pasarNombre.setText(datosPublicos.nombre)
        pasarApellido.setText(datosPublicos.apellido)
        pasarCedula.setText(datosPublicos.cedula)
        pasarFechaInicio.setText(datosPublicos.FechaInicio)
        pasarFechaFin.setText(datosPublicos.FechaFin)
        pasarTotalPagar.setText(datosPublicos.MontoTotal)
        pasarCuotas.setText(datosPublicos.coutas)
    }
}