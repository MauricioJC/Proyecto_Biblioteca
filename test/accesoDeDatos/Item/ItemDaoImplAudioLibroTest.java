package accesoDeDatos.Item;

import Dominio.Item.AudioLibro;
import Dominio.Item.Item;
import java.sql.SQLException;
import org.junit.Test;
import static org.junit.Assert.*;

public class ItemDaoImplAudioLibroTest {
    ItemDao accesoItem;
    public ItemDaoImplAudioLibroTest() {
        accesoItem = new ItemDaoImpl();
    }
    
     /**
     * Pruebas para utilizar la implementacion de DAO de item con AudioLibros
     */

    @Test
    public void pruebaInsertarAudioLibro() throws SQLException{
       AudioLibro audioLibro = new AudioLibro();
       
       audioLibro.setIdItem("al0001");
       audioLibro.setEstado("Disponible");
       audioLibro.setDiasDePrestamo(7);
       audioLibro.setNombre("Aprende C");
       audioLibro.setNarrador("Alejando Hernandez");
       audioLibro.setDuracion("5:20:00");
       
       boolean resultado = accesoItem.insertarItem(audioLibro); 
       assertTrue(resultado);
    }

    @Test (expected = SQLException.class)
    public void pruebaInsertarAudioLibroNoValido() throws SQLException{
        accesoItem.insertarItem(new AudioLibro());
    }
    
    @Test
    public void pruebaBuscarPorIdAudio() throws SQLException{
        Item audioLibro = accesoItem.buscarItemPorID("al0001");
        assertEquals("Probar que lo que se reciva sea un audio libro", AudioLibro.class, audioLibro.getClass());
    }
    
    
    @Test (expected = SQLException.class)
    public void pruebaBuscarAudioLibroInexistente() throws SQLException{
        accesoItem.buscarItemPorID("al9999");
    }
    
    
    @Test
    public void pruebaEliminarAudioLibro() throws SQLException{
        Item audioLibro = accesoItem.buscarItemPorID("al0001");
        boolean resultado = accesoItem.eliminarItem(audioLibro);
        assertTrue(resultado);
    }
    
    @Test (expected = SQLException.class)
    public void pruebaEliminarAudioLibroInexistente() throws SQLException{
        accesoItem.eliminarItem(new AudioLibro());
    }
    
}
