/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tpi;

/**
 *
 * @author C
 */
public class Pronostico {
    private Partido partido;
    private Resultado resultado;
    
    public Pronostico(){
        this.partido = null;
        this.resultado = null;
    }
    public Pronostico(Partido partido, Resultado resultado){
        this.partido = partido;
        this.resultado = resultado;
    }

    public Partido getPartido() {
        return partido;
    }

    public Resultado getResultado() {
        return resultado;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public void setResultado(Resultado resultado) {
        this.resultado = resultado;
    }
    
    
}
