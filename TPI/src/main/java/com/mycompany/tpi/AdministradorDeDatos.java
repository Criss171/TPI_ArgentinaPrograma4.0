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
    private ArrayList<Integer> fasesTotales;
    
    public AdministradorDeDatos(){
        conexcion.conectar();
        this.participantes = new ArrayList<Participante>();
        this.partidos = new ArrayList<Partido>();
        this.fasesTotales = new ArrayList<Integer>();
        this.puntoGano = 1;
        this.puntosPerdio = 1;
        this.puntosEmpato = 1;
         this.puntosAcertoRonda = 1;
        this.puntosAcertoFace = 1;
       
    }

    public int getPuntoGano() {
        return puntoGano;
    }

    public int getPuntosPerdio() {
        return puntosPerdio;
    }

    public int getPuntosEmpato() {
        return puntosEmpato;
    }

    public int getPuntosAcertoRonda() {
        return puntosAcertoRonda;
    }

    public int getPuntosAcertoFace() {
        return puntosAcertoFace;
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
        Participante participante = new Participante(nombre, 0, new ArrayList<>());
        if(!participanteEnLista(nombre)){
            participantes.add(participante);
        }
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
   
    public void cargarParticipantes(){
        resultado = conexcion.consulta("SELECT * FROM db_tpi.pronosticos;");
        try {
            while(resultado.next()){
                String nombre = resultado.getString("Nombre");
                agregarParticipante(nombre);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        fasesTotales();
        
    }
    public void cargarPronosticos(){
        int fase;
        int ronda;
        int nroPronostico;
        String equipo1;
        String equipo2;
        String gana1;
        String empata;
        String gana2;
        String equipoPronosticado;
        boolean gana;
        boolean pierde;
        boolean empatan;
        Pronostico pronostico;
        
        for(Participante p: participantes){
            String nombre = p.getNombre();
            resultado = conexcion.consulta("SELECT * FROM db_tpi.pronosticos WHERE Nombre ="+"'"+ nombre+"'"+";");
            try {
                while(resultado.next()){
                    fase = resultado.getInt("Fase");
                    ronda = resultado.getInt("Ronda");
                    equipo1 = resultado.getString("Equipo1");
                    equipo2 = resultado.getString("Equipo2");
                    gana1 = resultado.getString("Gana1");
                    empata = resultado.getString("Empatan");
                    gana2 = resultado.getString("Gana2");
                    nroPronostico = resultado.getInt("idPronostico");
                    
                    
                    gana = deStringAboolean(gana1);
                    pierde = deStringAboolean(gana2);
                    empatan = deStringAboolean(empata);
                    equipoPronosticado = equipoAlQueSeApuesta(gana1,empata,equipo1,equipo2);
                    pronostico = new Pronostico(nroPronostico, equipo1, equipo2, fase, ronda, equipoPronosticado, gana, pierde, empatan);
                    p.agregarPronostico(pronostico);
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(AdministradorDeDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        
    }
    private String equipoAlQueSeApuesta(String gana1, String empata, String equipo1, String equipo2){
        if("x".equals(gana1) || "x".equals(empata)){
            return equipo1;
        }else{
            return equipo2;
        }
    }       
    private boolean deStringAboolean(String x){
        return "x".equals(x);
    }
            
    public ArrayList<Participante> getParticipantes(){
        return this.participantes;
    }
    
     public void actualizarPuntaje(){
         ArrayList<Pronostico> pronosticos;
         int puntosTotales;
         int auxiliar;
        for(Participante p: participantes){
            puntosTotales = 0; 
            pronosticos = p.getPronosticos();
            for(Pronostico pron: pronosticos){
                auxiliar = puntosPorPronostico(pron);
                if(auxiliar !=this.puntosPerdio  || auxiliar > 0){
                    pron.setAcertado(true);
                }
                puntosTotales = puntosTotales+ auxiliar;

            }
            p.setPuntos(puntosTotales);
        }
    }
     
    public void cargarNroParidoAPronosticos(){
        ArrayList<Pronostico> pronosticos;
        for(Participante p : participantes){
            pronosticos = p.getPronosticos();
            for(Pronostico pron : pronosticos){
                cargarNroPartidoEnPronostico(pron);
            }
        }
            
    }
    private void cargarNroPartidoEnPronostico(Pronostico pronostico){
 
        Partido p = pronostico.getPartido();
        resultado  = conexcion.consulta("SELECT * FROM db_tpi.resultados WHERE Fase = " +
                                        p.getFase() +" AND Ronda = " + p.getRonda() +
                                        " AND Equipo1 = " + "'"+ p.getEquipo1() + "'"+ " AND Equipo2 = " +  "'"+ p.getEquipo2() + "'"+ ";");
        
        
        try {
            while(resultado.next()){
                  p.setNroPartido(resultado.getInt("idResultado"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    private int puntosPorPronostico(Pronostico p ){
        int puntos = 0;
        Partido partido = p.getPartido();
        Resultado r = null;
        int nroEquipoQuSeApuesta=0;
        resultado = conexcion.consulta("SELECT * FROM db_tpi.resultados WHERE idResultado =" + partido.getNroPartido()+ "\n");
        try {
            while(resultado.next()){
               r =  resultadoDePartido(resultado.getInt("Cant. Goles1"), resultado.getInt("Cant. Goles2")); 
               if(resultado.getString("Equipo1").equals(p.getEquipo())){
                   nroEquipoQuSeApuesta = 1;
               }else{
                   nroEquipoQuSeApuesta = 2;
               }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(r.comparar(p.getResultado())){
            if(nroEquipoQuSeApuesta == 1){
                if(r.getEquipo1Ganador()){
                    puntos  = this.puntoGano;
                }else{
                    if(r.getEmpate()){
                        puntos = this.puntosEmpato;
                    }
                }
            }else{
                if(r.getEquipo2Ganador()){
                    puntos  = this.puntoGano;
                }else{
                    if(r.getEmpate()){
                        puntos = this.puntosEmpato;
                    }
                }
            }
        }else{
            puntos  = this.puntosPerdio;
        }
        
       return puntos;
    }
    private Resultado resultadoDePartido(int equipo1, int equipo2){
        Resultado r;
        if(equipo1 == equipo2){
            r = new Resultado(false, false, true);
        }else{
            if(equipo1 > equipo2){
                r = new Resultado(true, false, false);
            }else{
                r = new Resultado(false, true, false);
            }
               
        }
       return r;
    }
    private void fasesTotales(){
        resultado = conexcion.consulta("SELECT * FROM db_tpi.resultados;");
        Integer i= null;
        try {
            while(resultado.next()){
                try {
                    i = resultado.getInt("Fase");
                } catch (SQLException ex) {
                    Logger.getLogger(AdministradorDeDatos.class.getName()).log(Level.SEVERE, null, ex);
                }
                if(!fasesTotales.contains(i)){
                    fasesTotales.add(i);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public void terminarAdministracion(){
        conexcion.desconectar();
    }
}
