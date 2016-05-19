/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoDeDatos.Item;

import Dominio.Item.Item;
import Dominio.Item.Software;
import java.sql.SQLException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author MAURICIO
 */
public class ItemDaoImplSoftwareTest {
    
    
    ItemDao accesoItem;
    public ItemDaoImplSoftwareTest() {
        accesoItem = new ItemDaoImpl();
    }
    
    
    /**
     * Pruebas para utilizar la implementacion de DAO de item con Audios
     */

    @Test
    public void pruebaInsertarSoftware() throws SQLException{
       Software software = new Software();
       
       software.setIdItem("so0001");
       software.setEstado("Disponible");
       software.setDiasDePrestamo(7);
       software.setNombre("NetBeans");
       software.setPlataforma("Windows");
       software.setVersion("8.1");
       boolean resultado = accesoItem.insertarItem(software); 
       assertTrue(resultado);
    }

    @Test (expected = SQLException.class)
    public void pruebaInsertarSoftwareNoValido() throws SQLException{
        accesoItem.insertarItem(new Software());
    }
    
    @Test
    public void pruebaBuscarPorIdSoftware() throws SQLException{
        Item software = accesoItem.buscarItemPorID("so0001");
        assertEquals("Probar que lo que se reciva sea un software", Software.class, software.getClass());
    }
    
    
    @Test (expected = SQLException.class)
    public void pruebaBuscarSoftwareInexistente() throws SQLException{
        accesoItem.buscarItemPorID("so9999");
    }
    
    
    @Test
    public void pruebaEliminarSoftware() throws SQLException{
        Item software = accesoItem.buscarItemPorID("so0001");
        boolean resultado = accesoItem.eliminarItem(software);
        assertTrue(resultado);
    }
    
    @Test (expected = SQLException.class)
    public void pruebaEliminarSoftwareInexistente() throws SQLException{
        accesoItem.eliminarItem(new Software());
    }
}
