package edu.curso.petspace

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.curso.petspace.ui.theme.PetSpaceTheme

class MainActivity : ComponentActivity() {
    val viewModel by viewModels<PetViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.lerTodos( {}, {} )
        enableEdgeToEdge()
        setContent {
            PetSpaceTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PetSpaceScreen(innerPadding)
                }
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun PetSpaceScreen(innerPadding: PaddingValues) {
        val image: Painter =
            painterResource(id = R.drawable.petspace) // Substitua pelo seu recurso de imagem

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF1B1F38)), // Cor de fundo aproximada
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Imagem do pet no espaço
            Image(
                painter = image,
                contentDescription = "Pet no espaço",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
            // Título
            Text(
                text = "Pet Space",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(8.dp),
                textAlign = TextAlign.Center
            )
            // Campos de entrada
            Column(
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .background(Color(0xFF3A3F58), shape = RoundedCornerShape(8.dp))
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextField(
                    value = viewModel.nome.value,
                    onValueChange = { it -> viewModel.nome.value = it },
                    label = { Text("Nome do Pet") },
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.White
                    )
                )
                TextField(
                    value = viewModel.raca.value,
                    onValueChange = { viewModel.raca.value = it },
                    label = { Text("Raça") },
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.White
                    )
                )
                TextField(
                    value = viewModel.peso.value.toString(),
                    onValueChange = { viewModel.peso.value = it },
                    label = { Text("Peso") },
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.White
                    )
                )
                TextField(
                    value = viewModel.idade.value.toString(),
                    onValueChange = { viewModel.idade.value = it },
                    label = { Text("Idade") },
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.White
                    )
                )
            }
            // Botões
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = {
                        viewModel.gravar(
                            onSucesso = {
                                runOnUiThread {
                                    Toast.makeText(
                                        this@MainActivity,
                                        "Pet gravado com sucesso", Toast.LENGTH_LONG
                                    ).show()
                                }
                            },
                            onErro = {
                                runOnUiThread {
                                    Toast.makeText(
                                        this@MainActivity,
                                        "Erro ao gravar o Pet", Toast.LENGTH_LONG
                                    ).show()
                                }
                            }
                        )
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4B76F7))
                ) {
                    Text("Gravar")
                }

                Button(
                    onClick = { /* Ação do botão Pesquisar */ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4B76F7))
                ) {
                    Text("Pesquisar")
                }
            }

            LazyColumn {
                items(viewModel.pets) { pet ->
                    Text(pet.nome, color = Color.White)
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        PetSpaceTheme {
            PetSpaceScreen(PaddingValues(10.dp))
        }
    }
}