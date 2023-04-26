/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tpi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author C
 */
public class Configuracion {
    File archivoConfiguracion; 
    int puntoGano;
    int puntoPerdio;
    int puntoEmpato;
    int puntosPorFase;
    int puntosPorRonda;
    AdministradorDeDatos administrador;
    
    public Configuracion( AdministradorDeDatos administrador){
        this.administrador = administrador;
        this.puntoGano = administrador.getPuntoGano();
        this.puntoPerdio = administrador.getPuntosPerdio();
        this.puntoEmpato = administrador.getPuntosEmpato();
        this.puntosPorFase = administrador.getPuntosAcertoFace();
        this.puntosPorRonda = administrador.getPuntosAcertoRonda();
                
        archivoConfiguracion = new File("archivoConfiguracion.txt");
        crearArchivoSinoExiste();
    }
    
    private void crearArchivoSinoExiste(){
        if(!archivoConfiguracion.exists()){
            try {
                archivoConfiguracion.createNewFile();
                guardarConfiguracionActual();
            } catch (IOException ex) {
                Logger.getLogger(Configuracion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
           cargarConfiguracion();
           actualizarCofiguracion();
        }
    }
    private void cargarConfiguracion(){
        String configuracion; 
        String[] configuraciones = new String[5];
	FileReader f = null; 
        int i =0;
        try {
            f = new FileReader(archivoConfiguracion);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Configuracion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
	BufferedReader b = new BufferedReader(f); 
        try {
            while((configuracion = b.readLine())!=null) {
                configuraciones[i] = configuracion;
                i++;
            } 
        } catch (IOException ex) {
            Logger.getLogger(Configuracion.class.getName()).log(Level.SEVERE, null, ex);
        }
        try { 
            b.close();
        } catch (IOException ex) {
            
            Logger.getLogger(Configuracion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            this.puntoGano = Integer.parseInt(configuraciones[0]);
        } catch (NumberFormatException ex){
            System.out.println("En el archivo de configuracion solo se aceptan numeros, en Punto por ganar se ingreso ["+ configuraciones[0] + "] lo cual es incorrecto");
            System.out.println("Se usara una configuracion anterior, valida");
        }
        
        try{
            this.puntoPerdio = Integer.parseInt(configuraciones[1]);
        } catch(NumberFormatException ex){
            System.out.println("En el archivo de configuracion solo se aceptan numeros, en Punto por perder se ingreso ["+ configuraciones[1] + "] lo cual es incorrecto");
            System.out.println("Se usara una configuracion anterior, valida");
        }   
        try{
            this.puntoEmpato = Integer.parseInt(configuraciones[2]);
        } catch(NumberFormatException ex){
            System.out.println("En el archivo de configuracion solo se aceptan numeros, en Punto por empate se ingreso ["+ configuraciones[2] + "] lo cual es incorrecto");
            System.out.println("Se usara una configuracion anterior, valida");
        }  
        try{
            this.puntosPorFase = Integer.parseInt(configuraciones[3]);
        } catch(NumberFormatException ex){
            System.out.println("En el archivo de configuracion solo se aceptan numeros, en Puntos por fase se ingreso ["+ configuraciones[3] + "] lo cual es incorrecto");
            System.out.println("Se usara una configuracion anterior, valida");
        }  
        try{
            this.puntosPorRonda = Integer.parseInt(configuraciones[4]);
        } catch(NumberFormatException ex){
            System.out.println("En el archivo de configuracion solo se aceptan numeros, en el Puntos ronda se ingreso ["+ configuraciones[4] + "] lo cual es incorrecto");
            System.out.println("Se usara una configuracion anterior, valida");
        }  
        
        
        
        
        
        
    }
    private void guardarConfiguracionActual(){
        try {
            BufferedWriter ficheroSalida = new BufferedWriter(new FileWriter(archivoConfiguracion));
            ficheroSalida.write(""+puntoGano);
            ficheroSalida.newLine();
            ficheroSalida.write(""+puntoPerdio);
            ficheroSalida.newLine();
            ficheroSalida.write(""+puntoEmpato);
            ficheroSalida.newLine();
            ficheroSalida.write(""+puntosPorFase);
            ficheroSalida.newLine();
            ficheroSalida.write(""+puntosPorRonda);
            ficheroSalida.newLine();
            ficheroSalida.close();
            
        } catch (IOException ex) {
            Logger.getLogger(Configuracion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public void actualizarCofiguracion(){
        cargarConfiguracion();
        administrador.setPuntoGano(puntoGano);
        administrador.setPuntosPerdio(puntoPerdio);
        administrador.setPuntosEmpato(puntoEmpato);
        administrador.setPuntosAcertoFace(puntosPorFase);
        administrador.setPuntosAcertoRonda(puntosPorRonda);
        
    }
    public String configuracionActual(){
        return "    Configuracion actual: \n"
                + "     -Puntos por ganar: "+ this.puntoGano + "\n"
                + "     -Puntos por perder: "+ this.puntoPerdio + "\n"
                + "     -Puntos por acertar toda una fase: " + this.puntosPorFase + "\n"
                + "     -Puntos por acertar toda una ronda: "+ this.puntosPorRonda;
    }
}
