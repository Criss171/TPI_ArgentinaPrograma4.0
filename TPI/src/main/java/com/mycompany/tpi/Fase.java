/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tpi;

import java.util.ArrayList;

/**
 *
 * @author C
 */
public class Fase {
    private int numero;
    private ArrayList rondas;
    
    public Fase(){
        this.numero = 0;
        this.rondas = new ArrayList<Ronda>();
    }

    public Fase(int numero, ArrayList<Ronda> rondas) {
        this.numero = numero;
        this.rondas = rondas;
    }
    public void addRonda(Partido ronda){
        rondas.add(ronda);
    }
}
