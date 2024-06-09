package modelo;

import com.sun.jdi.connect.spi.Connection;

public class Conexion {
    
    Connection con;    
    public static Conexion instance;
    
    private Conexion(){};
    
    public Conexion getConexion(){
        if(instance == null){
            instance = new Conexion();
        }
        return instance;
    }
    
    public Connection getConnection(){
        
    }
    
}
