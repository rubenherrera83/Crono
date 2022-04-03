/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author ruben
 */
//import com.mysql.cj.xdevapi.Statement;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class Database {
    
    //Librería Mysql
    public String driver="com.mysql.cj.jdbc.Driver";
    
    //Nombre de la base de datos
    public String database="crono";
    
    //Host
    public String hostname="localhost";
    
    //puerto
    public String port ="3306";
    
    //ruta
    public String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useSSL=false";
    
    //Nombre de usuario
    public String user= "crono";
    
    //Contraseña
    public String pass="";
    
    public Connection conectarMySQL(){
        
        Connection conn = null;
        try{
            Class.forName(driver);
            conn=DriverManager.getConnection(url, user, pass);
            System.out.println("Conectado");
        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        return conn;
    }
    
    public void consulta(String query){
         Connection conn = null;
         
         try{
             conn=DriverManager.getConnection(url, user, pass);
             Statement s = conn.createStatement();
             ResultSet rs = s.executeQuery(query);
             
             while(rs.next()){
                 System.out.println("Usuario logueado");
             }
         }catch (SQLException e){
            e.printStackTrace();
        }
    }
    
        
        
    }
    
    

