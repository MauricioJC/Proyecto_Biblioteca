/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoDeDatos.Item;

import Dominio.Item.Item;
import Dominio.Item.Tesis;
import java.sql.SQLException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author MAURICIO
 */
public class ItemDaoImplTesisTest {
    
    ItemDao accesoItem;
    public ItemDaoImplTesisTest() {
        accesoItem = new ItemDaoImpl();
    }
    
    
    /**
     * Pruebas para utilizar la implementacion de DAO de item con Libros
     */

    @Test
    public void pruebaInsertarTesis() throws SQLException{
       Tesis tesis = new Tesis();
       
       tesis.setIdItem("te0001");
       tesis.setEstado("Disponible");
       tesis.setDiasDePrestamo(4);
       tesis.setAutor("Andrea rios");
       tesis.setEditorial("Editorial uv");
       tesis.setFechaDePublicacion("16/06/2012");
       tesis.setNumeroDeHojas(120);
       tesis.setTitulo("Redes");
       tesis.setGradoAcademico("Maestria");
       tesis.setUniversidad("UV");
   
       boolean resultado = accesoItem.insertarItem(tesis); 
       assertTrue(resultado);
    }

    @Test (expected = SQLException.class)
    public void pruebaInsertarTesisNoValido() throws SQLException{
        accesoItem.insertarItem(new Tesis());
    }
  
    @Test
    public void pruebaBuscarPorIdTesis() throws SQLException{
        Item tesis = accesoItem.buscarItemPorID("te0001");
        assertEquals("Probar que lo que se reciva sea un Periodico", Tesis.class, tesis.getClass());
    }
    
    
    @Test (expected = SQLException.class)
    public void pruebaBuscarTesisInexistente() throws SQLException{
        accesoItem.buscarItemPorID("te9999");
    }
    
    
    @Test
    public void pruebaEliminarTesis() throws SQLException{
        Item tesis = accesoItem.buscarItemPorID("te0001");
        boolean resultado = accesoItem.eliminarItem(tesis);
        assertTrue(resultado);
    }
    
    @Test (expected = SQLException.class)
    public void pruebaEliminarTesisInexistente() throws SQLException{
        accesoItem.eliminarItem(new Tesis());
    }
}
