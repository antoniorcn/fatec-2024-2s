package edu.curso.agendacontato.recyclerview

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import edu.curso.agendacontato.R

class ContatoViewHolder(itemView : View) :
    RecyclerView.ViewHolder(itemView) {
    var txtNome : TextView = itemView.findViewById(R.id.txt_item_nome)
    var txtEmail : TextView = itemView.findViewById(R.id.txt_item_email)
    var txtTelefone : TextView = itemView.findViewById(R.id.txt_item_telefone)
}