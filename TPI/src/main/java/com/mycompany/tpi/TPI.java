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
        
        AdministradorDeDatos administrador = new AdministradorDeDatos();
        Scanner teclado = new Scanner(System.in);
        ArrayList<Participante> participantes;
        participantes = administrador.getParticipantes();
        administrador.cargarParticipantes();
        
        administrador.cargarPronosticos();
        
        
        for(Participante p: participantes){
            System.out.println("Participante: "  + p.getNombre()+ " Puntos: " + p.getPuntos());
            ArrayList<Pronostico> pronosticos;
            pronosticos = p.getPronosticos();
            for(Pronostico pron: pronosticos){
                System.out.println(pron);
            }
        }
        
        
        
        
        
        /*
        resultado = conexcion.consulta("SELECT * FROM db_tpi.pronosticos;");
        
        try {
            while (resultado.next()) {
                String  equipo1 = resultado.getString("Nombre");
                System.out.println(equipo1);
            }
        } catch (SQLException ex) {
           System.out.println("error");
        }
        
        System.out.println("Para desconectar apriete 3");
        int o = teclado.nextInt();
        if(0 == 3){
            conexcion.desconectar();
        }
           */    
        
        /*
        int opciones;
        Scanner teclado = new Scanner(System.in);
        do{
            System.out.println("-Pronosticos deportivos-");
            System.out.println("-3- Salir.");
            opciones = teclado.nextInt();
            
        }while(opciones != 3);
        */
    }
    
}
