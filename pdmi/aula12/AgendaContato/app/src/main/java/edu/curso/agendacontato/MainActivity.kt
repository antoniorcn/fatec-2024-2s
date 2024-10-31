package edu.curso.agendacontato

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import edu.curso.agendacontato.ui.theme.AgendaContatoTheme

data class Contato(
   var nome : String = "",
   var telefone : String = "",
   var email : String = ""
){}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val lista = remember {mutableStateListOf<Contato>()}
            AgendaContatoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TelaPrincipal(
                        titulo = "Agenda de Contato",
                        modifier = Modifier.padding(innerPadding),
                        lista = lista
                    )
                }
            }
        }
    }
}

@Composable
fun TelaPrincipal(titulo: String,
                  modifier: Modifier = Modifier,
                  lista: SnapshotStateList<Contato>) {
    val nome = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
    val telefone = remember { mutableStateOf("") }
    Column(modifier=Modifier.fillMaxSize()) {
        Text(
            text = titulo,
            modifier = modifier
        )
        Row(
            modifier=Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Nome:")
            OutlinedTextField(value = nome.value,
                onValueChange = { valor ->
                    nome.value = valor.lowercase() })
        }
        Row(
            modifier=Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Email:")
            OutlinedTextField(value = email.value, onValueChange = {
                email.value = it
            })
        }
        Row(
            modifier=Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Telefone:")
            OutlinedTextField(value = telefone.value, onValueChange = {
                telefone.value = it
            })
        }
        Row(modifier=Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround) {
            Button(onClick={
                val contato = Contato(nome=nome.value,
                    telefone=telefone.value,
                    email=email.value)
                lista.add(contato)
            }) {
                Text("Gravar")
            }
            Button(onClick={}) {
                Text("Pesquisar")
            }
        }
//        Column() {
//            for (contato in lista) {
//                Card() {
//                    Text(contato.nome)
//                    Text(contato.telefone)
//                }
//            }
//        }
        LazyColumn() {
            item {
                Text("Inicio da Lazy Column")
            }
            items(items=lista) { contato ->
                Card() {
                    Text(contato.nome)
                    Text(contato.telefone)
                }
            }
            item {
                Text("Termino da Lazy Column")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    val lista = remember { mutableStateListOf<Contato>() }
    AgendaContatoTheme {
        TelaPrincipal("Agenda de Contato", lista = lista)
    }
}