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
public class Participante {
    private String nombre;
    private int puntos; 
    private ArrayList<Pronostico> pronosticos;

    public Participante() {
    }

    public Participante(String nombre, int puntos, ArrayList<Pronostico> pronosticos) {
        this.nombre = nombre;
        this.puntos = puntos;
        this.pronosticos = pronosticos;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntos() {
        return puntos;
    }

    public ArrayList<Pronostico> getPronosticos() {
        return pronosticos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public void setPronosticos(ArrayList<Pronostico> pronosticos) {
        this.pronosticos = pronosticos;
    }
    public void agregarPronostico(Pronostico pronostico){
        pronosticos.add(pronostico);
    }

    @Override
    public String toString() {
        return "Participante{" + "nombre=" + nombre + ", puntos=" + puntos + '}';
    }
    
    
}
