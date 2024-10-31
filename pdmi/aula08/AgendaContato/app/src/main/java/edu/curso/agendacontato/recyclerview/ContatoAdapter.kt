package edu.curso.agendacontato.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import edu.curso.agendacontato.R
import edu.curso.agendacontato.model.Contato

class ContatoAdapter(
    val contexto : Context,
    val lista : ArrayList<Contato>
) :
    RecyclerView.Adapter<ContatoViewHolder>() {
        val inflater = LayoutInflater.from(contexto)
    override fun getItemCount(): Int {
        return lista.size
    }
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): ContatoViewHolder {
        val view = inflater.inflate(R.layout.contato_item_layout, parent,
            false)
        val vh = ContatoViewHolder(view)
        return vh
    }
    override fun onBindViewHolder(holder: ContatoViewHolder, position: Int) {
        val contato = lista[position]
        holder.txtNome.text = contato.nome
        holder.txtEmail.text = contato.email
        holder.txtTelefone.text = contato.telefone
    }
}