package edu.curso.agendacontato.activity

import android.app.Activity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.curso.agendacontato.R
import edu.curso.agendacontato.model.Contato
import edu.curso.agendacontato.recyclerview.ContatoAdapter

class ContatoListaActivity : Activity() {

    val lista = ArrayList<Contato>()
    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.contato_lista_activity)

        lista.add(Contato("Joao Silva", "(11) 1111", "joao@teste.com"))
        lista.add(Contato("Maria Silva", "(11) 2222", "maria@teste.com"))
        lista.add(Contato("Jose Santos", "(11) 3333", "jose@teste.com"))

        val adapter = ContatoAdapter(this, lista)
        val recycler = findViewById<RecyclerView>(R.id.rcv_contato_lista)
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(this)
    }
}