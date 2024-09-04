package edu.curso.agendacontato

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import okhttp3.Call
import okhttp3.Callback
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import java.io.IOException

class AgendaContatoAPIActivity : Activity() {
    val URL_BASE = "https://fatec-2s-default-rtdb.firebaseio.com"
    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.agenda_contato_form_layout)

        val edtNome = findViewById<EditText>(R.id.edt_nome)
        val edtEmail = findViewById<EditText>(R.id.edt_email)
        val edtTelefone = findViewById<EditText>(R.id.edt_telefone)
        val btnGravar = findViewById<Button>(R.id.btn_gravar)
        val client = OkHttpClient()
        btnGravar.setOnClickListener {
            val contatoJson = """
                {
                    "nome":"${edtNome.text}",
                    "email": "${edtEmail.text}",
                    "telefone": "${edtTelefone.text}"
                }
            """.trimIndent()

            val request = Request.Builder()
                .url("$URL_BASE/contatos.json")
                .post( contatoJson.toRequestBody(
                    "application/json".toMediaType())
                )
                .build()

            val response = object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    Log.v("AGENDA",
                        "Erro: ${e.message} ao cadastrar o contato")
                }
                override fun onResponse(call: Call, response: Response) {
                    Log.v("AGENDA", "Contato cadastrado com sucesso")
                    Log.v("AGENDA", "Resposta: ${response.body?.string()}")
                }
            }

            client.newCall( request ).enqueue( response )
        }
    }
}