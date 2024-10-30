package edu.curso.agendacontato

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import edu.curso.agendacontato.ui.theme.AgendaContatoTheme

class ContatoActivity : ComponentActivity() {

    val viewModel : ContatoViewModel by viewModels<ContatoViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AgendaContatoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TelaPrincipal(
                        titulo = "Tela Principal",
                        viewModel = viewModel,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
@Composable
fun TelaPrincipal(
    titulo: String,
    modifier: Modifier = Modifier,
    viewModel: ContatoViewModel
) {
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
            OutlinedTextField(value = viewModel.nome.value,
                onValueChange = { valor ->
                    viewModel.nome.value = valor.lowercase() })
        }
        Row(
            modifier=Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Email:")
            OutlinedTextField(value = viewModel.email.value,
                onValueChange = { viewModel.email.value = it })
        }
        Row(
            modifier=Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Telefone:")
            OutlinedTextField(value = viewModel.telefone.value,
                onValueChange = { viewModel.telefone.value = it })
        }
        Row(modifier=Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround) {
            Button(onClick={ viewModel.gravar() }) {
                Text("Gravar")
            }
            Button(onClick={}) {
                Text("Pesquisar")
            }
        }

        LazyColumn() {
            item {
                Text("Inicio da Lazy Column")
            }
            items(items=viewModel.lista) { contato ->
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