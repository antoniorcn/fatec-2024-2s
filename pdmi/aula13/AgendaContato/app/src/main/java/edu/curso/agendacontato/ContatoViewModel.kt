package edu.curso.agendacontato

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class ContatoViewModel : ViewModel() {
    val lista = mutableStateListOf<Contato>()
}