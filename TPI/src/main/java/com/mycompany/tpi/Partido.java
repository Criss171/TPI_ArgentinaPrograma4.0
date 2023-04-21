/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tpi;

/**
 *
 * @author C
 */
public class Partido {
    private int nroPartido;
    private String equipo1;
    private String equipo2;
    private int golesEquipo1;
    private int golesEquipo2;
    private int fase;
    private int ronda;
    
    
    public Partido(){
        this.nroPartido = 0;
        this.equipo1 = "";
        this.equipo2 = "";
        this.golesEquipo1 = 0;
        this.golesEquipo2 = 0;
        this.fase =0;
        this.ronda = 0;
    }
    public Partido(int nroPartido, String equipo1, String equipo2, int golesEquipo1, int golesEquipo2, int fase, int ronda) {
        this.nroPartido = nroPartido;
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.golesEquipo1 = golesEquipo1;
        this.golesEquipo2 = golesEquipo2;
        this.fase = fase;
        this.ronda = ronda;
    }

    public void setNroPartido(int nroPartido) {
        this.nroPartido = nroPartido;
    }

    public int getNroPartido() {
        return nroPartido;
    }

    public String getEquipo1() {
        return equipo1;
    }

    public String getEquipo2() {
        return equipo2;
    }

    public int getGolesEquipo1() {
        return golesEquipo1;
    }

    public int getGolesEquipo2() {
        return golesEquipo2;
    }
    public int getFase(){
        return fase;
    }
    public int getRonda(){
        return ronda;
    }

    public void setEquipo1(String equipo1) {
        this.equipo1 = equipo1;
    }

    public void setEquipo2(String equipo2) {
        this.equipo2 = equipo2;
    }

    public void setGolesEquipo1(int golesEquipo1) {
        this.golesEquipo1 = golesEquipo1;
    }

    public void setGolesEquipo2(int golesEquipo2) {
        this.golesEquipo2 = golesEquipo2;
    }
    public void setFase(int fase){
        this.fase = fase;
    }
    public void setRonda(int ronda){
        this.ronda = ronda;
    }
    public Resultado resultado(){
        Resultado resultado;
        if(this.golesEquipo1 > this.golesEquipo2){
            resultado = new Resultado(true,false,false);
        }else{
            resultado = new Resultado(false,true,false);
        }
        if(this.golesEquipo1 == this.golesEquipo2){
            resultado = new Resultado(false,false,true);
        }
        return resultado;
    }
    
    @Override
    public String toString(){
        return "Partido: " + this.equipo1 +" goles: "+this.golesEquipo1+ " vs " + this.equipo2+ " goles: "+this.golesEquipo2 + " Fase: " + this.fase + " Ronda: " + this.ronda ;
    }
    
    
    
}
