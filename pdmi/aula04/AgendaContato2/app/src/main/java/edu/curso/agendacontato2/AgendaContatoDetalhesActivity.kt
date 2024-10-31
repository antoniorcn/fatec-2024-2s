package edu.curso.agendacontato2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class AgendaContatoDetalhesActivity : Activity() {
    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)

        setContentView(R.layout.agenda_contato_detalhes_layout)

        val btnVoltar = findViewById<Button>(R.id.btn_voltar)
        val txtNome = findViewById<TextView>(R.id.txt_contato_nome)
        val nome = intent.extras?.getString("NOME")

        txtNome.text = nome

        btnVoltar.setOnClickListener {
            val intent = Intent(this, AgendaContatoFormActivity::class.java)
            startActivity(intent)
        }
    }
}