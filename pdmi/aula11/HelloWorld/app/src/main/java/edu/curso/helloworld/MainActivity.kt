package edu.curso.helloworld
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var contador = mutableIntStateOf( 0 )
        enableEdgeToEdge()
        setContent {
            Contador( contador )
        }
    }
}
// @Preview(showBackground = true)
@Composable
fun Contador( contador : MutableIntState) {
    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(onClick={
            contador.value -= 1
            Log.d("AULA11","Contador: $contador")
        }) {
            Text("-", fontSize = 48.sp)
        }
        Text("${contador.value}", fontSize=42.sp)
        Button(onClick={
            contador.value += 1
            Log.d("AULA11","Contador: $contador")
        }) {
            Text("+", fontSize = 48.sp)
        }
    }
}

//@Preview(showBackground = true)
@Composable
fun Calculadora() {
    val nomesBotoes = listOf(
// Coluna 0   1    2    3
        //0   1    2    3       Linha : 0
        "1", "2", "3", "+",
        //4   5    6    7       Linha : 1
        "4", "5", "6", "-",
        //8   9   10    11      Linha : 2
        "7", "8", "9", "*",
        //12  13  14   15       Linha : 3
        ".", "0", "=", "/"
    )
    Column() {
        Row {
            OutlinedTextField(value = "", onValueChange = {},
                placeholder = { Text("Numeros", fontSize = 12.sp) })
            Button(onClick = {}) {
                Text("CE", fontSize = 28.sp)
            }
        }
        for (linha in 0 .. 3) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                for (coluna in 0..3) {
                    Button(onClick = {}) {
                        val indice = linha * 4 + coluna
                        val texto = nomesBotoes[indice]
                        Text(texto, fontSize = 28.sp)
                    }
                }
            }
        }
    }
}


// @Preview(showBackground = true)
@Composable
fun HelloWorld() {
    Column(modifier= Modifier
        .padding(30.dp)
        .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(modifier= Modifier
            .background(Color.Yellow)
            .padding(30.dp),
            text="Hello World")
        Button(onClick={}) {
            Text("Ok")
        }
    }
}