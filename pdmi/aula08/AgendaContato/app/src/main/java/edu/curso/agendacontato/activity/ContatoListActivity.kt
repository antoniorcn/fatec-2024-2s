package edu.curso.agendacontato.activity

import android.app.Activity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.curso.agendacontato.R
import edu.curso.agendacontato.model.Contato
import edu.curso.agendacontato.recyclerview.ContatoAdapter

class ContatoListActivity : Activity() {
    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.contato_lista_activity_layout)

        val recyclerView = findViewById<RecyclerView>(R.id.rcv_contato_lista)
        val lista = ArrayList<Contato>()
        lista.add(Contato("0", "Joao Silva", "joao@teste.com", "(11) 1111"))
        lista.add(Contato("0", "Maria Silva", "maria@teste.com", "(11) 2222"))
        lista.add(Contato("0", "Jose  Santos", "jose@teste.com", "(11) 3333"))
        val adapter = ContatoAdapter(this, lista)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}