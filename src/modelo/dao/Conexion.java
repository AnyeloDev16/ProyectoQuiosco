package modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
 
    private final String URL = "jdbc:sqlserver://localhost:1433;databaseName=QuioscoDB;encrypt=true;trustServerCertificate=true";
    private final String USER = "UserQuiosco";
    private final String PASSWORD = "quioscoUCV";
    
    private static Conexion instance;
    
    private Conexion(){
        
    }
    
    public static Conexion getConexion(){
        if(Conexion.instance == null){
            instance = new Conexion();
        }
        return instance;
    }
    
    public Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL,USER,PASSWORD);
    }
    
}    
