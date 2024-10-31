import React, {useState} from "react";

function App() {
  return(
    <Formulario/>
  );
}
function Campo() { 
  return (
    <div>
      <label>Nome: </label>
      <input type="text" />
    </div>
  )
}
function Formulario() { 
  let [titulo, setTitulo] = useState("Agenda de Contato");

  return (
    <div className="app">
      <h1>{titulo}</h1>
      <form>
        <Campo/>
        <Campo/>
        <Campo/>
        <div>
          <button type="button" name="cmd" value="titulo" 
          onClick={()=>{
            console.log("Titulo antigo: ", titulo)
            console.log("Trocando o titulo")
            setTitulo("Nova Agenda de Contato")
            console.log("Novo titulo: ", titulo)
          }}>Alterar Titulo</button>
          <button type="button" name="cmd" value="gravar">Gravar</button>
          <button type="button" name="cmd" value="pesquisar">Pesquisar</button>
        </div>
      </form>
    </div>
  );
}

export default App;
