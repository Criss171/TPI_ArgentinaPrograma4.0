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
    private int nroPronostico;
    
    public Pronostico(){
        this.partido = null;
        this.resultado = null;
        this.equipo =  "";
    }
    public Pronostico(int nroPronostico, Partido partido,String equipo, Resultado resultado){
        this.equipo = equipo;
        this.partido = partido;
        this.resultado = resultado;
        this.nroPronostico = nroPronostico;
    }
    public Pronostico(int nroPronostico,  String equipo1, String equipo2, int fase, int ronda,String equipo, boolean equipo1Ganador, boolean equipo2Ganador, boolean empate){
        this.partido = new Partido(0, equipo1, equipo2, 0, 0, fase, ronda);
        this.resultado = new Resultado(equipo1Ganador, equipo2Ganador, empate);
        this.equipo = equipo;
        this.nroPronostico = nroPronostico;
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

    @Override
    public String toString() {
        return "    Pronostico \n"
                +"      NroPronostico: "+ nroPronostico + "\n"
                +"      NroPartido: " + partido.getNroPartido() + "\n"
                +"      EquipoAlQuseApuesta: " + equipo + "\n"
                +"      Partido: "+ partido.getEquipo1() +" vs " + partido.getEquipo2()+ "\n"
                +"      Resultado: "+ " GanaEqupo1: "+ resultado.getEquipo1Ganador() +" ganaEquipo2 "+ resultado.getEquipo2Ganador()+ " Empatan " +resultado.getEmpate()+   "\n";
    }

    
    
}
