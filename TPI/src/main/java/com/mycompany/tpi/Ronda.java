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
public class Ronda {
    private int numero;
    private ArrayList partidos;
    
    public Ronda(){
        this.numero = 0;
        this.partidos = new ArrayList<Partido>();
    }

    public Ronda(int numero, ArrayList<Partido> partidos) {
        this.numero = numero;
        this.partidos = partidos;
    }
    public void addPartido(Partido partido){
        partidos.add(partido);
    }
}
