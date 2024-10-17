import React, {useState} from 'react';


const App = () => { 
  let [contador, setContador] = useState(0);
  return ( 
    <div>
      <h1>Contador</h1>
      <div style={{display: "flex", 
        flexDirection: "row",
        justifyContent: "space-around",
        backgroundColor: "yellow",
        padding: "10px"
      }}>
        <button type="button" 
          style={{width: "20%", fontSize: "4em" }}
          onClick={()=>{ setContador(contador - 1); }}>-</button>
        <h2 style={{fontSize: "3em"}}>{contador}</h2>
        <button type="button" 
          style={{width: "20%",fontSize: "4em" }}
          onClick={()=>{ setContador(contador + 1); }}>+</button>
      </div>
    </div>
  )
}

export default App;