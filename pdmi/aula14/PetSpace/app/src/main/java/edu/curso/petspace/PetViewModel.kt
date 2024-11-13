package edu.curso.petspace

import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.MutableFloatState
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
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

class PetViewModel : ViewModel() {
    var pets : MutableList<Pet> = mutableStateListOf()
    var nome : MutableState<String> = mutableStateOf("")
    var raca : MutableState<String> = mutableStateOf("")
    var peso : MutableState<String> = mutableStateOf("")
    var idade : MutableState<String> = mutableStateOf("")

    val httpClient = OkHttpClient()
    val gson = Gson()
    val URL_BASE = "https://fatec-2024-2s-pdmi-default-rtdb.firebaseio.com"

    fun gravar(onSucesso : () -> Unit, onErro : () -> Unit) {
        val p = Pet(
            nome = nome.value, raca = raca.value )
        try {
            p.peso = peso.value.toFloat()
            p.idade = idade.value.toUInt()
        } catch (e : NumberFormatException) {
            Log.i("PET", "Erro ao converter o numero")
        }
        val petJson = gson.toJson( p );
        val request = Request.Builder()
            .post( petJson.toRequestBody( "application/json".toMediaType() ) )
            .url("$URL_BASE/pets.json")
            .build()
        val response = object : Callback {
            override fun onFailure(call : Call, erro : IOException) { onErro() }
            override fun onResponse(call : Call, response : Response) {
                lerTodos( {}, {} )
                onSucesso()
            }
        }
        httpClient.newCall(request).enqueue(response)
    }

    fun lerTodos( onSucesso: () -> Unit, onErro: () -> Unit) {
        val request = Request.Builder()
            .url("$URL_BASE/pets.json")
            .get()
            .build()

        val response = object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                onErro()
            }
            override fun onResponse(call: Call, response: Response) {
                val corpo = response.body?.string() ?: "{}"
                if (corpo != "null" && corpo != "{}") {
                    val typeToken = object : TypeToken<HashMap<String?, Pet?>>(){}.type
                    val mapTemp : HashMap<String?, Pet?> = gson.fromJson( corpo, typeToken)
                    pets.clear()
                    for (entry in mapTemp) {
                        val p = entry.value
                        if (p != null) {
                            pets.add( p )
                        }
                    }
                    onSucesso()
                }
            }
        }
        httpClient.newCall(request).enqueue(response)
    }

}