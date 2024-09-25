package edu.curso.agendacontato.activity

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import edu.curso.agendacontato.R
import edu.curso.agendacontato.model.Contato

class ContatoFormActivity : Activity() {
    val lista = ArrayList<Contato>()

    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.contato_form_activity_layout)

        val edtNome = findViewById<EditText>(R.id.edt_nome)
        val edtEmail = findViewById<EditText>(R.id.edt_email)
        val edtTelefone = findViewById<EditText>(R.id.edt_telefone)

        val btnGravar = findViewById<Button>(R.id.btn_gravar)
        val btnListar = findViewById<Button>(R.id.btn_listar)

        btnGravar.setOnClickListener {
            val c1 = Contato(id = "0",
                nome = edtNome.text.toString(),
                email = edtEmail.text.toString(),
                telefone = edtTelefone.text.toString()
                )
            lista.add(c1)
        }


    }
}