/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoDeDatos.Item;

import Dominio.Item.Item;
import Dominio.Item.Revista;
import java.sql.SQLException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author MAURICIO
 */
public class ItemDaoImplRevistaTest {
    ItemDao accesoItem;
    public ItemDaoImplRevistaTest() {
        accesoItem = new ItemDaoImpl();
    }
    
    
    /**
     * Pruebas para utilizar la implementacion de DAO de item con Libros
     */

    @Test
    public void pruebaInsertarRevista() throws SQLException{
       Revista revista = new Revista();
       
       revista.setIdItem("re0001");
       revista.setEstado("Disponible");
       revista.setDiasDePrestamo(4);
       revista.setAutor("Abigail Carmona");
       revista.setEditorial("Nat geo");
       revista.setFechaDePublicacion("20/08/2002");
       revista.setNumeroDeHojas(60);
       revista.setNombreRevista("C de Ciencia");
       revista.setNumeroDeRevista("25");
       boolean resultado = accesoItem.insertarItem(revista); 
       assertTrue(resultado);
    }

    @Test (expected = SQLException.class)
    public void pruebaInsertarRevistaNoValido() throws SQLException{
        accesoItem.insertarItem(new Revista());
    }
  
    @Test
    public void pruebaBuscarPorIdRevista() throws SQLException{
        Item revista = accesoItem.buscarItemPorID("re0001");
        assertEquals("Probar que lo que se reciva sea un Periodico", Revista.class, revista.getClass());
    }
    
    
    @Test (expected = SQLException.class)
    public void pruebaBuscarRevistaInexistente() throws SQLException{
        accesoItem.buscarItemPorID("re9999");
    }
    
    
    @Test
    public void pruebaEliminarRevista() throws SQLException{
        Item revista = accesoItem.buscarItemPorID("re0001");
        boolean resultado = accesoItem.eliminarItem(revista);
        assertTrue(resultado);
    }
    
    @Test (expected = SQLException.class)
    public void pruebaEliminarRevistaInexistente() throws SQLException{
        accesoItem.eliminarItem(new Revista());
    }
}
