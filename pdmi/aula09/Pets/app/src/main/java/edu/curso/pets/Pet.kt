package edu.curso.pets

import java.time.LocalDate

data class Pet(
    var nome : String = "",
    var raca : String = "",
    var peso : Float = 0.0f,
    var nascimento : LocalDate = LocalDate.now()
)
