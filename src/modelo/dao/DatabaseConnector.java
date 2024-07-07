package modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase que gestiona la conexión a la base de datos SQL Server.
 */
public class DatabaseConnector {
 
    private final String URL = "jdbc:sqlserver://localhost:1433;databaseName=QuioscoDB;encrypt=true;trustServerCertificate=true";
    private final String USER = "UserQuiosco";
    private final String PASSWORD = "quioscoucv";
    
    private static DatabaseConnector instance;
    
    private DatabaseConnector(){
        
    }
    
    /**
     * Método estático para obtener la instancia única de la conexión aplicando Singleton.
     * 
     * @return La instancia de la conexión.
     */
    public static DatabaseConnector getConexion(){
        if(DatabaseConnector.instance == null){
            instance = new DatabaseConnector();
        }
        return instance;
    }
    
    /**
     * Método para obtener la conexión a la base de datos.
     * 
     * @return La conexión establecida.
     * @throws SQLException Si hay algún problema durante la conexión.
     */
    public Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL,USER,PASSWORD);
    }
    
}    
