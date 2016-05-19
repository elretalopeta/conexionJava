/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import com.mysql.jdbc.Connection;
import formularios.cliente;
import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;
import javax.swing.JOptionPane;

public class ConexionMySQL {
    
            public String db = "Java";
	    public String url = "jdbc:mysql://localhost/"+db;
	    public String user = "root";
	    public String pass = "";
            Statement stmt = null;
            
            cliente cliente = new cliente();
            
public Connection Conectar(){
    
    Connection link = null;
        try{
            //carga el driver que nos descargamos
            Class.forName("org.gjt.mm.mysql.Driver");          
            link = (Connection) DriverManager.getConnection(this.url, this.user, this.pass);
            
        }catch(ClassNotFoundException | SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        return link;
    }

public void Insertar(String nombre, String apellido, String dni, String poblacion, String cp, String telefono) throws SQLException{

    //creo la query
    String SQL = "INSERT INTO cliente (nombre, apellido, DNI, poblacion, codigo_postal, telefono) VALUES ('"+nombre+"','"+apellido+"','"+dni+"','"+poblacion+"','"+cp+"','"+telefono+"');";
    
    //creo la conexion
    java.sql.Connection connect = Conectar();
    
    //fusion conexion y query
    stmt = connect.createStatement();
    
    //ejecuto query (error)
    stmt.executeUpdate(SQL);
    
  
    
}

}
