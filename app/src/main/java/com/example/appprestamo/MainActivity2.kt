package com.example.appprestamo

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import java.text.SimpleDateFormat
import java.util.*


class MainActivity2 : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        // MIS VARAIBLES
       // val temp = plazoTXT.setText("12")
        //val plazoTexto = plazoTXT.text
       // val plazo = plazoTexto.toInt()
        val plazoTXT: EditText = findViewById(R.id.editTextPlazo)
        val spinner: Spinner = findViewById(R.id.spinner2) // interes
        val montoTXT: EditText = findViewById(R.id.editTextMonto)
        val siguiente: Button = findViewById(R.id.button2)

        val textFechaActual: EditText = findViewById(R.id.editTextDate)
        val textFechaFin: EditText = findViewById(R.id.editTextDate2)

        //calcularMonto(10000, 20, 10)

        plazoTXT.addTextChangedListener {
            if(plazoTXT.text.toString().isEmpty() || montoTXT.text.toString().isEmpty()){

            }else{
                val plazoTexto = plazoTXT.text.toString()
                val plazo = plazoTexto.toInt()

                val spinnerTexto = spinner.selectedItem.toString()
                val interes = spinnerTexto.toFloat() / 100

                val montoTexto = montoTXT.text.toString()
                val monto = montoTexto.toInt()

                val sdf = SimpleDateFormat("dd/M/yyyy")
                val currentDate = sdf.format(Date())
                val fecha: Date = sdf.parse(currentDate)
                sumarMes(fecha, plazo)
                calcularMonto(monto, interes, plazo)
            }
        }
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                if(plazoTXT.text.toString().isEmpty() || montoTXT.text.toString().isEmpty()){

                }else{
                    val plazoTexto = plazoTXT.text.toString()
                    val plazo = plazoTexto.toInt()

                    val spinnerTexto = spinner.selectedItem.toString()
                    val interes = spinnerTexto.toFloat() / 100

                    val montoTexto = montoTXT.text.toString()
                    val monto = montoTexto.toInt()

                    val sdf = SimpleDateFormat("dd/M/yyyy")
                    val currentDate = sdf.format(Date())
                    val fecha: Date = sdf.parse(currentDate)
                    sumarMes(fecha, plazo)
                    calcularMonto(monto, interes, plazo)
                }

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

        val sdf = SimpleDateFormat("dd/M/yyyy")
        val currentDate = sdf.format(Date())

        textFechaActual.setText(currentDate)

        //textFechaFinal.setText(fecha.toString())
        //========fin fecha============
        //val spinner: Spinner = findViewById(R.id.spinner2)

// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            this,
            R.array.interes,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }

        siguiente.setOnClickListener {
            val cuotas: TextView = findViewById(R.id.textView20)
            val montoTotal: TextView = findViewById(R.id.textView19)

            datosPublicos.MontoTotal = montoTotal.text.toString()
            datosPublicos.coutas = cuotas.text.toString()
            datosPublicos.FechaInicio = textFechaActual.text.toString()
            datosPublicos.FechaFin = textFechaFin.text.toString()

            val lanzar = Intent(this, MainActivity3::class.java)
            startActivity(lanzar)
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
    fun sumarMes(fecha: Date?, meses: Int): Date? {
        val calendar = Calendar.getInstance()
        calendar.time = fecha // Configuramos la fecha que se recibe
        calendar.add(Calendar.MONTH, meses) // numero de horas a añadir, o restar en caso de horas<0
        val textFechaFinal: EditText = findViewById(R.id.editTextDate2)


        val sdf = SimpleDateFormat("dd/M/yyyy")
        val currentDate = sdf.format(calendar.getTime())
        textFechaFinal.setText(currentDate)

        return calendar.getTime()
    }

    fun calcularMonto(monto: Int, interes: Float, plazo: Int){
        /*
        formula
        (10000 * 0.20) + monto = cuanto va pagar de mas
        cuanto va pagar de mas / plazo = esto saca la cuota
        */
        val imprimirMonto: TextView = findViewById(R.id.textView19)
        val imprimirCuota: TextView = findViewById(R.id.textView20)

        val ganancia = monto * interes
        val pago = ganancia + monto
        val cuota = pago / plazo

        imprimirMonto.setText(pago.toString())
        imprimirCuota.setText(cuota.toInt().toString())
    }
}





