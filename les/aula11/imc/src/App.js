import React, {useState} from "react";

const Formulario = () => { 
  let [resultado, setResultado] = useState(0);
  let [peso, setPeso] = useState("");
  let [altura, setAltura] = useState("");
  return (
    <div style={{display: "flex",
      flexDirection: "column",
      alignItems: "center",
      justifyContent: "center",
      backgroundColor: "yellow",
      height: "100vw"
    }}>
      <h1>Calculadora</h1>
      <h2>I.M.C.</h2>
      <div>
        <label>Peso: </label>
        <input type="text" value={peso} onChange={(e)=>{
          // if (e.target.value in ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', ',']) { 
          setPeso(e.target.value);
          // }
        }}/>
      </div>
      <div>
        <label>Altura: </label>
        <input type="text" value={altura} onChange={(e)=>{
          setAltura(e.target.value);
        }}/>
      </div>
      <button type="button" onClick={()=>{
        const numPeso = parseFloat(peso);
        const numAltura = parseFloat(altura) / 100;
        setResultado(`${numPeso / (numAltura * numAltura)}`)
      }}>Calcular</button>
      <h3>Resultado: {resultado}</h3>
    </div>
  )
}

export default Formulario;