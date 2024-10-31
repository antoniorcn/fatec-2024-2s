package edu.curso.calculadorasoma

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

class CalculadoraSomaActivity : Activity() {
    override fun onCreate(bundle : Bundle?) {
        super.onCreate(bundle)
        Log.v("CALCULADORA", "Activity criada onCreate()" )
        setContentView(R.layout.calculadora_layout)

        val edtNum1 = findViewById<EditText>(R.id.edtNumero1)
        val edtNum2 = findViewById<EditText>(R.id.edtNumero2)
        val btnSomar = findViewById<Button>(R.id.btnSomar)

        btnSomar.setOnClickListener {
            var num1 = edtNum1.text.toString().toDoubleOrNull()
            var num2 = edtNum2.text.toString().toDoubleOrNull()
            if (num1 == null) {
                num1 = 0.0
            }
            if (num2 == null) {
                num2 = 0.0
            }
            Log.v("CALCULADORA", "Resultado: ${num1 + num2}")
        }

    }

    override fun onStart() {
        super.onStart()
        Log.v("CALCULADORA", "Activity iniciada onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.v("CALCULADORA", "Activity visivel onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.v("CALCULADORA", "Activity invisivel onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.v("CALCULADORA", "Activity parada onStop()")
    }

    override fun onDestroy() {
        Log.v("CALCULADORA", "Activity destruida onDestroy()")
        super.onDestroy()
    }

}