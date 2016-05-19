package accesoDeDatos;

import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Test;
import static org.junit.Assert.*;

public class ConexionTest {
    
    private final Conexion conexion;
    
    public ConexionTest() {
        conexion = new Conexion();
    }
    
    @Test
    public void pruebaConexionExitosa() throws SQLException{
        Connection connection = conexion.obtenerConexion();
        assertNotNull(connection);
    }
    
    @Test
    public void pruebaDesconectaExitoso() throws SQLException{
        Connection connection = conexion.obtenerConexion();
        conexion.desconecta();
        assertTrue(connection.isClosed());     
    }

}
