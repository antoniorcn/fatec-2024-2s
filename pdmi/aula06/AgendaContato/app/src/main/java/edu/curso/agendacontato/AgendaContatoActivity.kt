package edu.curso.agendacontato

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.Call
import okhttp3.Callback
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import java.io.IOException

class AgendaContatoActivity : Activity() {
    val URL_BASE = "https://fatec-2s-default-rtdb.firebaseio.com"
    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.agenda_contato_form_layout)

        val edtNome = findViewById<EditText>(R.id.edt_nome)
        val edtEmail = findViewById<EditText>(R.id.edt_email)
        val edtTelefone = findViewById<EditText>(R.id.edt_telefone)

        val btnGravar = findViewById<Button>(R.id.btn_gravar)
        val btnPesquisar = findViewById<Button>(R.id.btn_pesquisar)

        val gson = Gson()
        val cliente = OkHttpClient()

        btnGravar.setOnClickListener {
            val contato = Contato(
                nome=edtNome.text.toString(),
                email=edtEmail.text.toString(),
                telefone=edtTelefone.text.toString()
            )
            val contatoJson = gson.toJson( contato )
            Log.d("AGENDA", "JSON criado: $contatoJson")

            val request = Request.Builder()
                .post( contatoJson.toRequestBody(
                    "application/json".toMediaType()
                ))
                .url("$URL_BASE/contatos.json")
                .build()

            val response = object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    runOnUiThread {
                        Toast.makeText(
                            this@AgendaContatoActivity,
                            "Erro ${e.message} ao gravar o contato",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
                override fun onResponse(call: Call, response: Response) {
                    runOnUiThread {
                        Toast.makeText(
                            this@AgendaContatoActivity,
                            "Contato gravado com sucesso",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            }

            cliente.newCall(request).enqueue(response)
        }

        btnPesquisar.setOnClickListener {
            val request = Request.Builder()
                .url("$URL_BASE/contatos.json")
                .get()
                .build()

            val response = object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    runOnUiThread {
                        Toast.makeText(
                            this@AgendaContatoActivity,
                            "Erro ${e.message} ao ler os contatos",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
                override fun onResponse(call: Call, response: Response) {
                    val contatosJson = response.body?.string()
                    Log.d("AGENDA", "Resposta: $contatosJson")
                    val tipo = object : TypeToken<HashMap<String?, Contato?>>() {}.type
                    val contatos : HashMap<String?, Contato?> =
                        gson.fromJson(contatosJson, tipo)

                    for (contato in contatos.values) {
                        Log.d("AGENDA", "Contato: $contato")
                        if (contato != null) {
                            runOnUiThread {
                                if (contato.nome.contains(edtNome.text)) {
                                    edtNome.setText(contato.nome)
                                    edtEmail.setText(contato.email)
                                    edtTelefone.setText(contato.telefone)
                                }
                            }
                        }
                    }
                }
            }
            cliente.newCall(request).enqueue(response)
        }
    }
}