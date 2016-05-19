/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoDeDatos.Item;

import Dominio.Item.Libro;
import Dominio.Item.Item;
import java.sql.SQLException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author MAURICIO
 */
public class ItemDaoImplLibroTest {
    ItemDao accesoItem;
    public ItemDaoImplLibroTest() {
        accesoItem = new ItemDaoImpl();
    }
    
    
    /**
     * Pruebas para utilizar la implementacion de DAO de item con Libros
     */

    @Test
    public void pruebaInsertarLibro() throws SQLException{
       Libro libro = new Libro();
       
       libro.setIdItem("li0001");
       libro.setEstado("Disponible");
       libro.setDiasDePrestamo(7);
       libro.setAutor("Stephen King");
       libro.setEditorial("PANINIC");
       libro.setFechaDePublicacion("12/04/2002");
       libro.setNumeroDeHojas(720);
       libro.setTitulo("IT");
       libro.setPais("New York");
       
       boolean resultado = accesoItem.insertarItem(libro); 
       assertTrue(resultado);
    }

    @Test (expected = SQLException.class)
    public void pruebaInsertarLibroNoValido() throws SQLException{
        accesoItem.insertarItem(new Libro());
    }
  
    @Test
    public void pruebaBuscarPorIdLibro() throws SQLException{
        Item libro = accesoItem.buscarItemPorID("li0002");
        assertEquals("Probar que lo que se reciva sea un Libro", Libro.class, libro.getClass());
    }
    
    
    @Test (expected = SQLException.class)
    public void pruebaBuscarLibroInexistente() throws SQLException{
        accesoItem.buscarItemPorID("li9999");
    }
    
    
    @Test
    public void pruebaEliminarLibro() throws SQLException{
        Item libro = accesoItem.buscarItemPorID("li0001");
        boolean resultado = accesoItem.eliminarItem(libro);
        assertTrue(resultado);
    }
    
    @Test (expected = SQLException.class)
    public void pruebaEliminarLibroInexistente() throws SQLException{
        accesoItem.eliminarItem(new Libro());
    }
}
