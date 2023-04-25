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
        
        
    
        int opciones;
        do{
            System.out.println("------------------------------------------------------------");
            System.out.println("-Pronosticos deportivos-");
            System.out.println("-1- Ver lista de ganadores.");
            System.out.println("-2- Salir.");
            System.out.println("------------------------------------------------------------");
            opciones = teclado.nextInt();
            if(opciones == 1){
                System.out.println("-------------------Ganadores---------------------------");
                    for(Participante p: participantes){
                        ArrayList<Pronostico> pronosticos;
                        pronosticos = p.getPronosticos();
                        System.out.println((nroParticipante +=1) + "- Participante: "  + p.getNombre()+ " Puntos: " + p.getPuntos() + " Total pronosticos: "+ pronosticos.size());     
                    }
                System.out.println("---------------------------------------------------------");
            }
        }while(opciones != 2);
        administrador.terminarAdministracion();
    }
    
}
