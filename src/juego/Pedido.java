package juego;

import static java.awt.AWTEventMulticaster.add;
import java.sql.*;
import java.util.*;

public class Pedido {
    
    public Statement stmt=null;
    public ResultSet data=null;
    public Connection conn;
    
    public Pedido(Connection con){
        conn = con;
    }
    

    public void CrearTabla() throws SQLException{
      stmt = conn.createStatement();
      //Preparas el String con los datos de creación  de la tabla
      String sql = "CREATE TABLE LWD " +
                   "(id INTEGER not NULL, " +
                   " primero VARCHAR(255), " +
                   " segundo  VARCHAR(255), " +
                   " edad INTEGER, " +
                   " PRIMARY KEY ( id ))";
       //Ejecutamos el Statement
      stmt.executeUpdate(sql);
    }
    
    public ArrayList SolicitarTablas() throws SQLException{
        //SELECT table_name AS nombre FROM information_schema.tables WHERE table_schema = '$nombreDeLaBaseDeDatos';
        ArrayList nombreCampos = new ArrayList<>();
        stmt = conn.createStatement();
        //Preparas el String con los datos de creación  de la tabla
        String sql = "SELECT TABLE_NAME AS nombre FROM information_schema.tables WHERE table_schema = \"javaprueba\"";
        //String sql = "SHOW COLUMNS FROM javaprueba.lwd";
        data = stmt.executeQuery(sql);
        while(data.next() == true) {
            // El campo Field es el que contiene el nombre 
            // de la columna
            nombreCampos.add(data.getString("nombre") );
        }
        
        //sql = "SELECT TABLE_NAME AS nombre FROM information_schema.tables WHERE table_schema = \"javaprueba\"";
        //Ejecutamos el Statement
        return nombreCampos;
        //String comandoCampos = "SHOW COLUMNS FROM pruebas.prueba";
        
        
        //ArrayList datos = new ArrayList<>();
        /*
        while(data.next() == true ) {
            for(String campo : nombreCampos ){
                datos.put( campo , data.getInt(campo));
            }
        }
        stmt.executeUpdate(sql);
        */
    }
    public String[] SolicitarNomColum(String tabla) throws SQLException{
        //SELECT table_name AS nombre FROM information_schema.tables WHERE table_schema = '$nombreDeLaBaseDeDatos';
        ArrayList<String> nombreCampos = new ArrayList<>();
        stmt = conn.createStatement();
        //Preparas el String con los datos de creación  de la tabla
        
        
        String sql = "SHOW COLUMNS FROM javaprueba."+tabla;
        data = stmt.executeQuery(sql);
        while(data.next() == true) {
            // El campo Field es el que contiene el nombre 
            // de la columna
            nombreCampos.add(data.getString("Field") );
        }
        String[] arrCol = new String[nombreCampos.size()];
        for (int i=0; i<nombreCampos.size(); i++){
            arrCol[i]=nombreCampos.get(i);
        }
        //sql = "SELECT TABLE_NAME AS nombre FROM information_schema.tables WHERE table_schema = \"javaprueba\"";
        //Ejecutamos el Statement
        return arrCol;
        //String comandoCampos = "SHOW COLUMNS FROM pruebas.prueba";
        
        
        //ArrayList datos = new ArrayList<>();
        /*
        while(data.next() == true ) {
            for(String campo : nombreCampos ){
                datos.put( campo , data.getInt(campo));
            }
        }
        stmt.executeUpdate(sql);
        */
    }
    
    public ArrayList<ArrayList<String>> SolicitarDatosTbl(String tabla, String[] arrCol) throws SQLException{
        //SELECT table_name AS nombre FROM information_schema.tables WHERE table_schema = '$nombreDeLaBaseDeDatos';
        stmt = conn.createStatement();
        ArrayList<ArrayList<String>> datos = new ArrayList<>();
        //Preparas el String con los datos de creación  de la tabla
        while(data.next() == true ) {
            for(int i=0; i<=arrCol.length; i++){
                //Viajaremos de columna en columna
                datos.get(i).add(data.getString(arrCol[i]));
            }
        }
        //Ejecutamos el Statement
        return datos;

    }
    
    //String sql = "SELECT TABLE_NAME AS nombre FROM information_schema.tables WHERE table_schema = \"javaprueba\"";
        //INSERT INTO lwd VALUES (2021, "Mario", "Castro", 19);
    //String comandoCampos = "SHOW COLUMNS FROM pruebas.prueba";
}

