/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.tpi;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author C
 */
public class TPI {

    public static void main(String[] args) throws SQLException {
         ConexionDB conexcion = new ConexionDB();
        conexcion.conectar();
        ResultSet resultado;
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Para desconectar apriete 3");
        int o = teclado.nextInt();
        
        conexcion.consulta();
        
          
        if(0 == 3){
            conexcion.desconectar();
        }
               
        
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
