package accesoDeDatos.Item;

import Dominio.Item.Ensayo;
import Dominio.Item.Item;
import java.sql.SQLException;
import org.junit.Test;
import static org.junit.Assert.*;

public class ItemDaoImplEnsayoTest {
    ItemDao accesoItem;
    public ItemDaoImplEnsayoTest() {
        accesoItem = new ItemDaoImpl();
    }
    
    
    /**
     * Pruebas para utilizar la implementacion de DAO de item con Ensayos
     */

    @Test
    public void pruebaInsertarEnsayo() throws SQLException{
       Ensayo ensayo = new Ensayo();
       
       ensayo.setIdItem("en0001");
       ensayo.setEstado("Disponible");
       ensayo.setDiasDePrestamo(7);
       ensayo.setAutor("Itzel Gonzales");
       ensayo.setEditorial("Uv");
       ensayo.setFechaDePublicacion("23/08/2014");
       ensayo.setNumeroDeHojas(20);
       ensayo.setTitulo("Grafos no dirigidos");
       ensayo.setLugarDePublicacion("Veracruz");
       
       boolean resultado = accesoItem.insertarItem(ensayo); 
       assertTrue(resultado);
    }

    @Test (expected = SQLException.class)
    public void pruebaInsertarEnsayoNoValido() throws SQLException{
        accesoItem.insertarItem(new Ensayo());
    }
  
    @Test
    public void pruebaBuscarPorIdEnsayo() throws SQLException{
        Item ensayo = accesoItem.buscarItemPorID("en0002");
        assertEquals("Probar que lo que se reciva sea un Ensayo", Ensayo.class, ensayo.getClass());
    }
    
    
    @Test (expected = SQLException.class)
    public void pruebaBuscarEnsayoInexistente() throws SQLException{
        accesoItem.buscarItemPorID("en9999");
    }
    
    
    @Test
    public void pruebaEliminarEnsayo() throws SQLException{
        Item ensayo = accesoItem.buscarItemPorID("en0001");
        boolean resultado = accesoItem.eliminarItem(ensayo);
        assertTrue(resultado);
    }
    
    @Test (expected = SQLException.class)
    public void pruebaEliminarEnsayoInexistente() throws SQLException{
        accesoItem.eliminarItem(new Ensayo());
    }
}
    
