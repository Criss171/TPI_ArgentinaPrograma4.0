/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.tpi;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author C
 */
public class TPI {

    public static void main(String[] args) throws SQLException {
        
        int nroParticipante = 0;
        AdministradorDeDatos administrador = new AdministradorDeDatos();
        Scanner teclado = new Scanner(System.in);
        ArrayList<Participante> participantes;
        participantes = administrador.getParticipantes();
        administrador.cargarParticipantes();
        
        administrador.cargarPronosticos();
        administrador.cargarNroParidoAPronosticos();
        administrador.actualizarPuntaje();
        
        Configuracion configuracion = new Configuracion(administrador);
        
        
    
        int opciones;
        do{
            
            System.out.println("------------------------------------------------------------");
            System.out.println("-Pronosticos deportivos-");
            System.out.println("-1- Ver lista de ganadores.");
            System.out.println("-2- Cargar archivo de configuracion.");
            System.out.println(configuracion.configuracionActual());
            System.out.println("-3- Salir.");
            System.out.println("------------------------------------------------------------");
            opciones = teclado.nextInt();
            if(opciones == 1){
                administrador.actualizarPuntaje();
                System.out.println("-------------------Ganadores---------------------------");
                System.out.println("------[Gana:"+administrador.getPuntoGano()+ "]"
                        +"-[Pierde:" + administrador.getPuntosPerdio() + "]"
                        +"-[Empata:" + administrador.getPuntosEmpato()+"]"
                        +"-[BonusFase:" + administrador.getPuntosAcertoFace() + "]"
                        +"-[BonusRonda:" + administrador.getPuntosAcertoFace() + "]");
                    for(Participante p: participantes){
                        ArrayList<Pronostico> pronosticos;
                        pronosticos = p.getPronosticos();
                        System.out.println((nroParticipante +=1) + "- Participante: "  + p.getNombre()+ " Puntos: " + p.getPuntos() + " Total pronosticos: "+ pronosticos.size());     
                    }
                System.out.println("---------------------------------------------------------");
            }
            if(opciones ==2){
                configuracion.actualizarCofiguracion();
            }
        }while(opciones != 3);
        administrador.terminarAdministracion();
    }
    
}
