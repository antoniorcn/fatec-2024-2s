import React, {useState} from "react";
import axios from "axios";

function App() {
  const [token, setToken] = useState(null);
  return token == null ? (<Login/>) : (<Formulario/>)
}

function Login() { 
  const [email, setEmail] = useState("");
  const [senha, setSenha] = useState("");
  return (
    <div style={{backgroundColor: "lightcyan", display: "flex",
      flex: 1, flexDirection: "column", height: "100vh"
    }}>
      <h1>Login</h1>
      <div style={{display: "flex", flexDirection: "column",
        backgroundColor: "lightyellow", flex: 1
      }}>
        <div style={{display: "flex", flexDirection: "row",
          justifyContent: "space-between"
        }}>
          <label style={{flex: 1}}>Email:</label>
          <input style={{flex: 3}} type="text"
            value={email} onChange={(e)=>{setEmail(e.target.value)}}/>
        </div>
        <div style={{display: "flex", flexDirection: "row",
          justifyContent: "space-between"
        }}>
          <label style={{flex: 1}}>Senha:</label>
          <input style={{flex: 3}} type="password"
            value={senha} onChange={(e)=>{setSenha(e.target.value)}}/>
        </div>
        <div style={{display: "flex", flexDirection: "row",
          justifyContent: "center"
        }}>
          <button type="button" onClick={()=>{}}>Login</button>
          <button type="button" onClick={()=>{}}>Registrar</button>          
        </div>
      </div>
    </div>
  )
}

function Formulario() { 
  const [nome, setNome] = useState("");
  const [email, setEmail] = useState("");
  const [telefone, setTelefone] = useState("");

  const [lista, setLista] = useState([]);

  const listaParaTela = [];

  for(let i = 0; i < lista.length; i++) { 
    listaParaTela.push(
    <div style={{flexDirection: "column", borderWidth: 1, borderRadius: 10,
      backgroundColor: "lightskyblue", boxShadow: "1px 1px 10px 1px grey",
      margin: 10, padding: 10
    }}>
      <p>{lista[i].nome}</p>
      <p>{lista[i].telefone}</p>
      <p>{lista[i].email}</p>
    </div>);
  }

  return (
    <div style={{backgroundColor: "lightcyan", display: "flex",
      flex: 1, flexDirection: "column", height: "100vh"
    }}>
      <h1>Agenda de Contato</h1>
      <div style={{display: "flex", flexDirection: "column",
        backgroundColor: "lightyellow", flex: 1
      }}>
        <div style={{display: "flex", flexDirection: "row",
          justifyContent: "space-between"
        }}>
          <label style={{flex: 1}}>Nome:</label>
          <input style={{flex: 3}} type="text"
            value={nome} onChange={(e)=>{setNome(e.target.value)}}/>
        </div>
        <div style={{display: "flex", flexDirection: "row",
          justifyContent: "space-between"
        }}>
          <label style={{flex: 1}}>Email:</label>
          <input style={{flex: 3}} type="text"
            value={email} onChange={(e)=>{setEmail(e.target.value)}}/>
        </div>
        <div style={{display: "flex", flexDirection: "row",
          justifyContent: "space-between"
        }}>
          <label style={{flex: 1}}>Telefone:</label>
          <input style={{flex: 3}} type="text"
            value={telefone} onChange={(e)=>{setTelefone(e.target.value)}}/>
        </div>
        <div style={{display: "flex", flexDirection: "row",
          justifyContent: "center"
        }}>
          <button type="button" onClick={()=>{
            const obj= {nome, telefone, email};
            const listaTemp = [...lista, obj]
            // lista.push( obj );

            // Operador Spread
            // const listaFrutas = ["banana", "pera", "maça"]
            // const copia = [...listaFrutas];

            setLista( listaTemp );
            console.log("Tamanho: " + lista.length);
            console.log("Conteudo da Lista: ", lista);
          }}>Gravar</button>

          <button type="button" onClick={()=>{
              const obj = {nome, telefone, email};
              axios.post(
                "https://fatec-2024-2s-les-default-rtdb.firebaseio.com/contatos.json",
                obj
              );
          }}>Salvar no Firebase</button>
          <button type="button" onClick={()=>{
              console.log("Carregando do firebase...")
              axios.get(
                "https://fatec-2024-2s-les-default-rtdb.firebaseio.com/contatos.json")
              .then(( response )=>{
                console.log("Dados recebidos: ", response.data);
                alert("Dados carregados com sucesso");
              }).catch(( erro )=>{
                alert("Erro ao carregar do firebase: " + erro.message)
              })
              console.log("Executando carregamento...")
          }}>Carregar do Firebase</button>          
        </div>
      </div>
      <div style={{display: "flex", flexDirection: "column",
        flex: 2
      }}>
        <p>Lista de Contatos</p>
        {listaParaTela}
      </div>
    </div>
  )
}

export default App;
