/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoDeDatos.Item;

import Dominio.Item.Item;
import Dominio.Item.Video;
import java.sql.SQLException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author MAURICIO
 */
public class ItemDaoImplVideoTest {
    
    
    
    ItemDao accesoItem;
    public ItemDaoImplVideoTest() {
        accesoItem = new ItemDaoImpl();
    }
    
    
    /**
     * Pruebas para utilizar la implementacion de DAO de item con Audios
     */

    @Test
    public void pruebaInsertarVideo() throws SQLException{
       Video video = new Video();
       
       video.setIdItem("vi0001");
       video.setEstado("Disponible");
       video.setDiasDePrestamo(5);
       video.setNombre("Aprende a Programar");
       video.setAreaEducativa("Programacion");
       video.setTitulo("Aprende C");
       boolean resultado = accesoItem.insertarItem(video); 
       assertTrue(resultado);
    }

    @Test (expected = SQLException.class)
    public void pruebaInsertarVideoNoValido() throws SQLException{
        accesoItem.insertarItem(new Video());
    }
    
    @Test
    public void pruebaBuscarPorIdVideo() throws SQLException{
        Item video = accesoItem.buscarItemPorID("vi0001");
        assertEquals("Probar que lo que se reciva sea un software", Video.class, video.getClass());
    }
    
    
    @Test (expected = SQLException.class)
    public void pruebaBuscarVideoInexistente() throws SQLException{
        accesoItem.buscarItemPorID("vi9999");
    }
    
    
    @Test
    public void pruebaEliminarVideo() throws SQLException{
        Item video = accesoItem.buscarItemPorID("vi0001");
        boolean resultado = accesoItem.eliminarItem(video);
        assertTrue(resultado);
    }
    
    @Test (expected = SQLException.class)
    public void pruebaEliminarVideoInexistente() throws SQLException{
        accesoItem.eliminarItem(new Video());
    }
}
