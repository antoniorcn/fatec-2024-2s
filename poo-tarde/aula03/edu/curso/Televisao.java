package edu.curso;
public class Televisao { 
    String marca;
    String resolucao;
    float polegadas;
    boolean ligada;
    int canal;
    int volume;
    int brilho;

    public void ligar() { 
        ligada = true;
    }

    public void desligar() { 
        ligada = false;
    }

    public void subirCanal() { 
        canal = canal + 1;
    }

    public void baixarCanal() { 
        canal = canal - 1;
    }

    public void aumentarVolume() { 
        volume = volume + 5;
    }

    public void baixarCanal() { 
        volume = volume - 5;
    }

    public void aumentarBrilho() { 
        brilho = brilho + 1;
    }

    public void baixarBrilho() { 
        brilho = brilho - 1;
    }    
}