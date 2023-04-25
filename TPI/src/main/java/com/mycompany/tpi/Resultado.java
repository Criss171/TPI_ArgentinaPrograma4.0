/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tpi;

/**
 *
 * @author C
 */
public class Resultado {
    private boolean equipo1Ganador;
    private boolean equipo2Ganador;
    private boolean empate;

    public Resultado(){
        this.equipo1Ganador = false;
        this.equipo2Ganador = false;
        this.empate = false;
    }
    public Resultado( boolean equipo1Ganador, boolean equipo2Ganador, boolean empate) {
        this.equipo1Ganador = equipo1Ganador;
        this.equipo2Ganador = equipo2Ganador;
        this.empate = empate;
    }
    public boolean getEquipo1Ganador() {
        return equipo1Ganador;
    }

    public boolean getEquipo2Ganador() {
        return equipo2Ganador;
    }

    public boolean getEmpate() {
        return empate;
    }

    public void setEquipo1Ganador(boolean equipo1Ganador) {
        this.equipo1Ganador = equipo1Ganador;
    }

    public void setEquipo2Ganador(boolean equipo2Ganador) {
        this.equipo2Ganador = equipo2Ganador;
    }

    public void setEmpate(boolean empate) {
        this.empate = empate;
    }

    

    
    public boolean comparar(Resultado r) {
        if(this.empate == r.empate && this.equipo1Ganador == r.equipo1Ganador && this.equipo2Ganador == r.equipo2Ganador){
            return true;
        }
        return false;
    }
    
}
