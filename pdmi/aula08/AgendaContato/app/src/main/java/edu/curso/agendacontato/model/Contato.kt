package edu.curso.agendacontato.model

import java.io.Serializable

data class Contato(
    var id : String = "",
    var nome : String = "",
    var email : String = "",
    var telefone : String = ""
) : Serializable