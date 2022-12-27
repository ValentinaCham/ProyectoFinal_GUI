
package juego;

import java.sql.*;

public class Conectar {
    
    public static final String URL = "jdbc:mysql://localhost:3306/juegodedos";
    public static final String USER = "root";
    public static final String CLAVE = "valCHAM2002";
    
    public Connection getConexion(){	
        Connection con = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(URL, USER, CLAVE);
         }
        catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        return con;
    }
}
