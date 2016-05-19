/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoDeDatos.Item;

import Dominio.Item.Pelicula;
import Dominio.Item.Item;
import java.sql.SQLException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author MAURICIO
 */
public class ItemDaoImplPeliculaTest {
    
    ItemDao accesoItem;
    public ItemDaoImplPeliculaTest() {
        accesoItem = new ItemDaoImpl();
    }
    
    
    /**
     * Pruebas para utilizar la implementacion de DAO de item con Audios
     */

    @Test
    public void pruebaInsertarPelicula() throws SQLException{
       Pelicula pelicula = new Pelicula();
       
       pelicula.setIdItem("pe0001");
       pelicula.setEstado("Disponible");
       pelicula.setDiasDePrestamo(4);
       pelicula.setNombre("Star wars");
       pelicula.setAño("2007");
       pelicula.setDirector("George Lucas");
       pelicula.setPais("USA");
       pelicula.setDuracion("2:30:00");
       
       boolean resultado = accesoItem.insertarItem(pelicula); 
       assertTrue(resultado);
    }

    @Test (expected = SQLException.class)
    public void pruebaInsertarPeliculaNoValido() throws SQLException{
        accesoItem.insertarItem(new Pelicula());
    }
    
    @Test
    public void pruebaBuscarPorIdPelicula() throws SQLException{
        Item pelicula = accesoItem.buscarItemPorID("pe0001");
        assertEquals("Probar que lo que se reciva sea un pelicula", Pelicula.class, pelicula.getClass());
    }
    
    
    @Test (expected = SQLException.class)
    public void pruebaBuscarPeliculaInexistente() throws SQLException{
        accesoItem.buscarItemPorID("pe9999");
    }
    
    
    @Test
    public void pruebaEliminarPelicula() throws SQLException{
        Item pelicula = accesoItem.buscarItemPorID("pe0001");
        boolean resultado = accesoItem.eliminarItem(pelicula);
        assertTrue(resultado);
    }
    
    @Test (expected = SQLException.class)
    public void pruebaEliminarPeliculaInexistente() throws SQLException{
        accesoItem.eliminarItem(new Pelicula());
    }
    
}
