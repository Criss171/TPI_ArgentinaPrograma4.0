/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tpi;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author C
 */
public class AdministradorDeDatos {
    private ArrayList<Participante> participantes;
    private ArrayList<Partido> partidos;
    private ConexionDB conexcion = new ConexionDB();
    private ResultSet resultado;  
    private int puntoGano;
    private int puntosPerdio;
    private int puntosEmpato;
    private int puntosAcertoRonda;
    private int puntosAcertoFace;
    
    public AdministradorDeDatos(){
        conexcion.conectar();
        this.participantes = new ArrayList<Participante>();
        this.partidos = new ArrayList<Partido>();
        this.puntoGano = 1;
        this.puntosPerdio = 1;
        this.puntosEmpato = 1;
         this.puntosAcertoRonda = 1;
        this.puntosAcertoFace = 1;
       
    }

    public void setPuntoGano(int puntoGano) {
        this.puntoGano = puntoGano;
    }

    public void setPuntosPerdio(int puntosPerdio) {
        this.puntosPerdio = puntosPerdio;
    }

    public void setPuntosEmpato(int puntosEmpato) {
        this.puntosEmpato = puntosEmpato;
    }

    public void setPuntosAcertoRonda(int puntosAcertoRonda) {
        this.puntosAcertoRonda = puntosAcertoRonda;
    }

    public void setPuntosAcertoFace(int puntosAcertoFace) {
        this.puntosAcertoFace = puntosAcertoFace;
    }
    
    private void agregarPartido(int nroPartido, String equipo1, String equipo2, int golesEquipo1, int golesEquipo2, int fase, int ronda ){
        Partido partido = new Partido(nroPartido, equipo1, equipo2, golesEquipo1, golesEquipo2, fase, ronda);
        this.partidos.add(partido);
    }
    private void agregarParticipante(String nombre){
        Participante participante = new Participante(nombre, 0, null);
        if(!participanteEnLista(nombre)){
            participantes.add(participante);
        }
    }
    
    private void agregarPronosticoAparticipante(String nombreParticipante,int nroPartido, String equipo1,String equipo, String equipo2, int ronda, int fase, boolean equipo1Gana, boolean equipo2Gana, boolean empate){
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
    
    public void cargarParticipantes(){
        resultado = conexcion.consulta("SELECT * FROM db_tpi.pronosticos");
        try {
            while(resultado.next()){
                String nombre = resultado.getString("Nombre");
                agregarParticipante(nombre);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void cargarPronosticos(){
        String fase;
        String ronda;
        String equipo1;
        String equipo2;
        String gana1;
        String empata;
        String gana2;
        
        for(Participante p: participantes){
            String nombre = p.getNombre();
            resultado = conexcion.consulta("SELECT * FROM db_tpi.pronosticos WHERE nombre = " + nombre + ";");
            try {
                while(resultado.next()){
                    fase = resultado.getString("Fase");
                    ronda = resultado.getString("Ronda");
                    equipo1 = resultado.getString("Equipo1");
                    equipo2 = resultado.getString("Equipo2");
                    gana1 = resultado.getString("Gana1");
                    empata = resultado.getString("Empata");
                    gana2 = resultado.getString("Gana2");
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(AdministradorDeDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    private String equipoAlQueSeApuesta(String gana1, String empata, String gana2, String equipo1, String equipo2){
        if(gana1.equals("x") || empata.equals("x")){
            return equipo1;
        }else{
            return equipo2;
        }
    }       
    public ArrayList<Participante> getParticipantes(){
        return this.participantes;
    }
           
    
}
