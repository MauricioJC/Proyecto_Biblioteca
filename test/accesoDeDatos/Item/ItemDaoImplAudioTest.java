package accesoDeDatos.Item;

import Dominio.Item.Audio;
import Dominio.Item.Item;
import java.sql.SQLException;
import junit.framework.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class ItemDaoImplAudioTest {
    ItemDao accesoItem;
    public ItemDaoImplAudioTest() {
        accesoItem = new ItemDaoImpl();
    }
    
    
    /**
     * Pruebas para utilizar la implementacion de DAO de item con Audios
     */

    @Test
    public void pruebaInsertarAudio() throws SQLException{
       Audio audio = new Audio();
       
       audio.setIdItem("au0001");
       audio.setEstado("Disponible");
       audio.setDiasDePrestamo(7);
       audio.setNombre("CD top notch");
       audio.setAreaEducativa("Ingles");
       audio.setDuracion("3:00:12");
       
       boolean resultado = accesoItem.insertarItem(audio); 
       assertTrue(resultado);
    }

    @Test (expected = SQLException.class)
    public void pruebaInsertarAudioNoValido() throws SQLException{
        accesoItem.insertarItem(new Audio());
    }
    
    @Test
    public void pruebaBuscarPorIdAudio() throws SQLException{
        Item audio = accesoItem.buscarItemPorID("au0001");
        assertEquals("Probar que lo que se reciva sea un audio", Audio.class, audio.getClass());
    }
    
    
    @Test (expected = SQLException.class)
    public void pruebaBuscarAudioInexistente() throws SQLException{
        accesoItem.buscarItemPorID("au9999");
    }
    
    
    @Test
    public void pruebaEliminarAudio() throws SQLException{
        Item audio = accesoItem.buscarItemPorID("au0001");
        boolean resultado = accesoItem.eliminarItem(audio);
        assertTrue(resultado);
    }
    
    @Test (expected = SQLException.class)
    public void pruebaEliminarAudioInexistente() throws SQLException{
        accesoItem.eliminarItem(new Audio());
    }
    
}
