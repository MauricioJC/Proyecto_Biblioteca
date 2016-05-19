package accesoDeDatos;

import accesoDeDatos.Prestatario.PrestatarioDaoImpl;
import accesoDeDatos.Prestatario.PrestatarioDao;
import java.sql.SQLException;
import java.util.List;
import junit.framework.Assert;
import Dominio.Prestatario;
import org.junit.Test;
import static org.junit.Assert.*;

public class PrestatarioDaoImplTest {
    
    public PrestatarioDaoImplTest() {
    }
   
    @Test
    public void pruebaInsertarPrestatario() throws SQLException {
        Prestatario prestatario = new Prestatario(1,"Aby","Huesca","Sanch",3,"aby@gmail.com");
        PrestatarioDao prestatarioDao = new PrestatarioDaoImpl();
        boolean resultado = prestatarioDao.insertarPrestatario(prestatario);
        assertTrue("Prueba Insertar Prestatario", resultado);
    } 
    
    @Test(expected = SQLException.class)
    public void pruebaInsertarPrestatarioErroneo() throws SQLException{
        Prestatario prestatario = new Prestatario();
        PrestatarioDao prestatarioDao = new PrestatarioDaoImpl();
        prestatarioDao.insertarPrestatario(prestatario);
    }
    
    @Test
    public void pruebaBuscarPrestatarioPorId() throws SQLException{
        PrestatarioDao prestatarioDao = new PrestatarioDaoImpl();
        Prestatario prestatario = prestatarioDao.buscarPrestatarioPorId(2);
        assertEquals("Prueba buscar prestatario con ID 2", 2, prestatario.getIdPrestatario());
    }
    
    @Test
    public void pruebaObtenerCoincidenciasDeContactoPorNombreParcial()throws SQLException{
        PrestatarioDao prestatarioDao = new PrestatarioDaoImpl();
        List<Prestatario> prestatarios = prestatarioDao.buscarCoincidenciasDePrestatariosPorNombreYApellido("Eli", "Perez");
        assertEquals("Obtener coincidencias por nombre y primer apellido",1,prestatarios.size());
    }
    
    @Test
    public void pruebaEliminarPrestatario() throws SQLException{
        Prestatario prestatario = new Prestatario(1,"Aby","Huesca","Sanch",3,"aby@gmail.com");
        PrestatarioDao prestatarioDao = new PrestatarioDaoImpl();
        boolean resultado = prestatarioDao.eliminarPrestatario(prestatario);
        assertTrue("Prueba Eliminar Prestatario", resultado);
    }
    
    @Test(expected = SQLException.class)
    public void pruebaEliminarPrestatarioInexistente() throws SQLException{
        Prestatario prestatario = new Prestatario(20,"Miguel","De la","Cruz",3,"migue@gmail.com");
        PrestatarioDao prestatarioDao = new PrestatarioDaoImpl();
        prestatarioDao.eliminarPrestatario(prestatario);
    }

}
