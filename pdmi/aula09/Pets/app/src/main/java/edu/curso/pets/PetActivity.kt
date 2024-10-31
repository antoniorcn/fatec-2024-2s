package edu.curso.pets

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
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
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class PetActivity : Activity() {
    val URL_BASE = "https://fatec-2s-default-rtdb.firebaseio.com"
    val lista = ArrayList<Pet>()
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    lateinit var edtNome : EditText
    lateinit var edtRaca : EditText
    lateinit var edtPeso : EditText
    lateinit var edtNascimento : EditText
    val clienteHttp = OkHttpClient()
    val gson = Gson()
    override fun onCreate(bundle : Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.pet_activity_layout)
        edtNome = findViewById(R.id.edt_nome)
        edtRaca = findViewById(R.id.edt_raca)
        edtPeso = findViewById(R.id.edt_peso)
        edtNascimento = findViewById(R.id.edt_nascimento)

        carregarFirebase()

        val btnGravar = findViewById<Button>(R.id.btn_gravar)
        val btnPesquisar = findViewById<Button>(R.id.btn_pesquisar)
        btnGravar.setOnClickListener {
            val p = paraEntidade()
            salvarFirebase( p )
            carregarFirebase()
        }

        btnPesquisar.setOnClickListener {
            for (pet in lista) {
                if (pet.nome.contains( edtNome.text )) {
                    paraTela( pet )
                }
            }
        }
    }
    fun paraEntidade() : Pet {
        val p = Pet()
        p.nome = edtNome.text.toString()
        p.raca = edtRaca.text.toString()
        p.peso = edtPeso.text.toString().toFloat()
        p.nascimento = LocalDate.parse(
            edtNascimento.text.toString(), formatter)
        return p
    }
    fun paraTela(p : Pet) {
        edtNome.setText( p.nome )
        edtRaca.setText( p.raca )
        edtPeso.setText( p.peso.toString() )
        val txtNascimento : String = p.nascimento.format(formatter)
        edtNascimento.setText( txtNascimento )
    }

    fun carregarFirebase() {
        val request = Request.Builder()
            .get()
            .url("$URL_BASE/pets.json")
            .build()

        val response = object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e("PET", "Erro ao ler os dados", e)
            }
            override fun onResponse( call : Call, response : Response) {
                val textoJson = response.body?.string()
                Log.d("PET", "Carregar Firebase JSON:  $textoJson")
                if (textoJson != null && textoJson != "null") {
                    val typeToken  = object :
                            TypeToken<HashMap<String?, Pet?>>(){}.type
                    val mapa: HashMap<String?, Pet?> =
                        gson.fromJson(textoJson, typeToken)
                    lista.clear()
                    for (petItem in mapa) {
                        lista.add(petItem.value ?: Pet())
                    }
                }
            }
        }
        clienteHttp.newCall(request).enqueue(response)
    }

    fun salvarFirebase( p : Pet ) {
        val petJson = gson.toJson( p )
        val request = Request.Builder()
            .post(petJson.toRequestBody(
                "application/json".toMediaType()
            ))
            .url("$URL_BASE/pets.json")
            .build()
        val response = object : Callback {
            override fun onFailure(call : Call, e : IOException) {
                Log.e("PET", "Erro ao gravar o pet", e)
            }
            override fun onResponse( call : Call, response : Response) {
                Log.e("PET", "Pet gravado com sucesso")
            }
        }
        clienteHttp.newCall(request).enqueue(response)
    }
}