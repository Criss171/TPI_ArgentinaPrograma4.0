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
public class AdministradorDeDatos {
    private ArrayList<Participante> participantes;
    private ArrayList<Partido> partidos;
    private int puntoGano;
    private int puntoPerdio;
    private int puntoEmpato;
    private int puntosAcertoRonda;
    private int puntosAcertoFace;
    
    public AdministradorDeDatos(){
        this.participantes = new ArrayList<Participante>();
        this.partidos = new ArrayList<Partido>();
    }
    
    public void agregarPartido(int nroPartido, String equipo1, String equipo2, int golesEquipo1, int golesEquipo2, int fase, int ronda ){
        Partido partido = new Partido(nroPartido, equipo1, equipo2, golesEquipo1, golesEquipo2, fase, ronda);
        this.partidos.add(partido);
    }
    public void agregarParticipante(String nombre){
        Participante participante = new Participante(nombre, 0, null);
        if(!participanteEnLista(nombre)){
            participantes.add(participante);
        }
    }
    
    public void agregarPronosticoAparticipante(String nombreParticipante,int nroPartido, String equipo1,String equipo, String equipo2, int ronda, int fase, boolean equipo1Gana, boolean equipo2Gana, boolean empate){
        Participante participante  = buscarParticipante(nombreParticipante); 
        Pronostico pronostico = new Pronostico(nroPartido, equipo1, equipo2, ronda, fase,equipo, equipo1Gana, equipo2Gana, empate);
        participante.agregarPronostico(pronostico);
        
    }
    private Participante buscarParticipante(String nombre){
        Participante participante = null; 
        for(Participante p : participantes){
            if(p.getNombre().equals(nombre)){
                participante = p; 
            }
        }
        return participante; 
    } 
    private boolean participanteEnLista(String nombre){
        for(Participante p : participantes){
            if(p.getNombre().equals(nombre)){
                 return true;
            }
        }
        return false;
    }
    public void actualizarPuntaje(){
        
    }
           
    
}
