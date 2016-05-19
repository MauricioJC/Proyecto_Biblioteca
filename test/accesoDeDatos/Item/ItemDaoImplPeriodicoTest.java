/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoDeDatos.Item;

import Dominio.Item.Item;
import Dominio.Item.Periodico;
import java.sql.SQLException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author MAURICIO
 */
public class ItemDaoImplPeriodicoTest {
    ItemDao accesoItem;
    public ItemDaoImplPeriodicoTest() {
        accesoItem = new ItemDaoImpl();
    }
    
    
    /**
     * Pruebas para utilizar la implementacion de DAO de item con Libros
     */

    @Test
    public void pruebaInsertarPeriodico() throws SQLException{
       Periodico periodico = new Periodico();
       
       periodico.setIdItem("pd0001");
       periodico.setEstado("Disponible");
       periodico.setDiasDePrestamo(4);
       periodico.setAutor("Luis Enrique");
       periodico.setEditorial("Diario Xalapa");
       periodico.setFechaDePublicacion("16/01/2015");
       periodico.setNumeroDeHojas(40);
       periodico.setNombrePeriodico("Diario de Xalapa");
       
       boolean resultado = accesoItem.insertarItem(periodico); 
       assertTrue(resultado);
    }

    @Test (expected = SQLException.class)
    public void pruebaInsertarPeriodicoNoValido() throws SQLException{
        accesoItem.insertarItem(new Periodico());
    }
  
    @Test
    public void pruebaBuscarPorIdPeriodico() throws SQLException{
        Item periodico = accesoItem.buscarItemPorID("pd0001");
        assertEquals("Probar que lo que se reciva sea un Periodico", Periodico.class, periodico.getClass());
    }
    
    
    @Test (expected = SQLException.class)
    public void pruebaBuscarPeriodicoInexistente() throws SQLException{
        accesoItem.buscarItemPorID("pd9999");
    }
    
    
    @Test
    public void pruebaEliminarPeriodico() throws SQLException{
        Item periodico = accesoItem.buscarItemPorID("pd0001");
        boolean resultado = accesoItem.eliminarItem(periodico);
        assertTrue(resultado);
    }
    
    @Test (expected = SQLException.class)
    public void pruebaEliminarPeriodicoInexistente() throws SQLException{
        accesoItem.eliminarItem(new Periodico());
    }
}
