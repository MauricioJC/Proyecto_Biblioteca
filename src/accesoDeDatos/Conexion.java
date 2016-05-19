package accesoDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
     private Connection conexion;
    private final String DB="jdbc:mysql://127.0.0.1/biblioteca";
    private final String USUARIO = "AdministradorDeBiblioteca";
    private final String CONTRASEÑA = "3612";
        
    public Connection obtenerConexion() throws SQLException{
        conecta();
        return this.conexion;
    }
    
    private void conecta() throws SQLException{
        this.conexion = DriverManager.getConnection(DB, USUARIO, CONTRASEÑA);
    }
    
    public void desconecta() throws SQLException{
        if(this.conexion != null){
            try {
                if(!this.conexion.isClosed()){
                    this.conexion.close();
                }
            } catch (SQLException ex) {
                throw new SQLException("Error al Desconectar");
            }
        }
    }   
}
