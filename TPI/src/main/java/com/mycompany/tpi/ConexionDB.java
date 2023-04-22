/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tpi;

import com.mysql.cj.protocol.Resultset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author C
 */
public class ConexionDB {
    private String db = "db_tpi";
    private String url = "jdbc:mysql://localhost:3306/"; //servidor local en la pc en el que se ejecuta la base de datos
    private String user= "root";
    private String password = "CMysqklBasesDatos";
    private String driver = "com.mysql.cj.jdbc.Driver";
    private Connection cx;
    private Statement consulta;
    private String sqlConsulta;
    private ResultSet resultado;
    
    public ConexionDB(){
    
    }
    
    public void conectar(){
        try{
            Class.forName(driver);
            cx = DriverManager.getConnection(url+db, user, password);
            System.out.println("Se conecto a la Base de datos: "+ db);
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println("No se conecto a la Base de datos: "+ db);
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void desconectar(){
        try {
            cx.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ResultSet consulta(String sqlConsulta){
        
        try {
            consulta = cx.createStatement();       
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
         this.sqlConsulta = sqlConsulta;
         
        try {
            resultado = consulta.executeQuery(sqlConsulta);        
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return resultado;
    }
 
}
