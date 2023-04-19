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
    private Equipo equipo1;
    private Equipo equipo2;
    private int golesEquipo1;
    private int golesEquipo2;
    
    
    public Partido(){
        this.equipo1 = new Equipo();
        this.equipo2 = new Equipo();
        this.golesEquipo1 = 0;
        this.golesEquipo2 = 0;
    }
    public Partido(Equipo equipo1, Equipo equipo2, int golesEquipo1, int golesEquipo2) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.golesEquipo1 = golesEquipo1;
        this.golesEquipo2 = golesEquipo2;
    }

    public Equipo getEquipo1() {
        return equipo1;
    }

    public Equipo getEquipo2() {
        return equipo2;
    }

    public int getGolesEquipo1() {
        return golesEquipo1;
    }

    public int getGolesEquipo2() {
        return golesEquipo2;
    }

    public void setEquipo1(Equipo equipo1) {
        this.equipo1 = equipo1;
    }

    public void setEquipo2(Equipo equipo2) {
        this.equipo2 = equipo2;
    }

    public void setGolesEquipo1(int golesEquipo1) {
        this.golesEquipo1 = golesEquipo1;
    }

    public void setGolesEquipo2(int golesEquipo2) {
        this.golesEquipo2 = golesEquipo2;
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
        return "Partido: " + this.equipo1.getNombre() +" goles: "+this.golesEquipo1+ " vs " + this.equipo2.getNombre()+ " goles: "+this.golesEquipo2 ;
    }
    
    
    
}
