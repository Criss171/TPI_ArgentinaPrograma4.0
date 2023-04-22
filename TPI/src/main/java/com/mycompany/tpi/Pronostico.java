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
    private String equipo;
    private Resultado resultado;
    
    public Pronostico(){
        this.partido = null;
        this.resultado = null;
    }
    public Pronostico(Partido partido,String equipo, Resultado resultado){
        this.equipo = equipo;
        this.partido = partido;
        this.resultado = resultado;
    }
    public Pronostico(int nroPartido,  String equipo1, String equipo2, int fase, int ronda,String equipo, boolean equipo1Ganador, boolean equipo2Ganador, boolean empate){
        this.partido = new Partido(nroPartido, equipo1, equipo2, 0, 0, fase, ronda);
        this.resultado = new Resultado(equipo1Ganador, equipo2Ganador, empate);
        this.equipo = equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getEquipo() {
        return equipo;
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
