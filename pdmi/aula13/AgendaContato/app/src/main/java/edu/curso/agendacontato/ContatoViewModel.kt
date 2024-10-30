package edu.curso.agendacontato

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import okhttp3.Call
import okhttp3.Callback
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import java.io.IOException

class ContatoViewModel : ViewModel() {
    val lista = mutableStateListOf<Contato>()
    val nome = mutableStateOf("")
    val email = mutableStateOf("")
    val telefone = mutableStateOf("")

    val URL_BASE = "https://fatec-2024-2s-pdmi-default-rtdb.firebaseio.com"
    val gson = Gson()
    val httpClient = OkHttpClient()
    fun gravar() {
        val contato = Contato(nome=nome.value,
            telefone=telefone.value,
            email=email.value)
        val contatoJson = gson.toJson( contato )
        val request = Request.Builder()
            .url("$URL_BASE/contatos.json")
            .post(contatoJson.toRequestBody(
                "application/json".toMediaType()
            ))
            .build()
        val response = object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e("AGENDA",
                    "Erro ao gravar o contato ${e.message}", e)
            }
            override fun onResponse(call: Call, response: Response) {
                Log.i("AGENDA", "Contato gravado com sucesso")
            }
        }
        httpClient.newCall( request ).enqueue( response )
    }

}