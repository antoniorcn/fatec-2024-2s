package edu.curso;
public class Fogao { 

    int numeroBocas = 4;
    boolean bocasAcesas[] = new boolean[numeroBocas];
    int temperaturaForno = 0;
    boolean luzFornoLigada = false;
    boolean fornoLigado = false;
    int anosUso = 0;

    public void acenderBoca(int numeroBoca) { 
        bocasAcesas[numeroBoca] = true;
    }

    public void apagarBoca(int numeroBoca) { 
        bocasAcesas[numeroBoca] = false;
    }

    public void ligarForno() { 
        fornoLigado = true;
    }

    public void desligarForno() { 
        fornoLigado = false;
    }

    public void aumentarTemperaturaForno() { 
        temperaturaForno = temperaturaForno + 10;
    }

    public void baixarTemperaturaForno() { 
        temperaturaForno = temperaturaForno - 10;
    }
}