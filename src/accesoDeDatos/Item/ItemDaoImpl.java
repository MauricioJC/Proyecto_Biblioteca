package accesoDeDatos.Item;

import Dominio.Item.Audio;
import Dominio.Item.AudioLibro;
import Dominio.Item.Ensayo;
import Dominio.Item.Item;
import Dominio.Item.Libro;
import Dominio.Item.Pelicula;
import Dominio.Item.Periodico;
import Dominio.Item.Revista;
import Dominio.Item.Software;
import Dominio.Item.Tesis;
import Dominio.Item.Video;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ItemDaoImpl implements ItemDao {

    public ItemDaoImpl() {
    }
    
    
    private ItemDao obtenerImplemetacionDaoDeItem(Item item) throws SQLException{
        ItemDao itemDao = null;
        
        if(item.getClass() == Audio.class){
            itemDao = new AudioDaoImpl();    
        }else{
            if(item.getClass() == AudioLibro.class){
                itemDao = new AudioLibroDaoImpl();
            }else{
                if (item.getClass() == Ensayo.class) {
                    itemDao = new EnsayoDaoImpl();
                }else{
                    if(item.getClass() == Libro.class){
                        itemDao = new LibroDaoImpl();
                    }else{
                        if(item.getClass() == Pelicula.class){
                            itemDao = new PeliculaDaoImpl();
                        }else{
                            if(item.getClass() == Periodico.class){
                                itemDao = new PeriodicoDaoImpl();
                            }else{
                                if(item.getClass() == Revista.class){
                                    itemDao = new RevistaDaoImpl();
                                }else{
                                    if(item.getClass() == Software.class){
                                        itemDao = new SoftwareDaoImpl();
                                    }else{
                                        if(item.getClass() == Tesis.class){
                                            itemDao = new TesisDaoImpl();
                                        }else{
                                            if(item.getClass() == Video.class){
                                                itemDao = new VideoDaoImpl();
                                            }else{
                                                throw new SQLException("Clase para acceso de Datos no soportada");
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return itemDao;
    }
    
    @Override
    public boolean insertarItem(Item item) throws SQLException {
        ItemDao  itemDao = obtenerImplemetacionDaoDeItem(item);
        return itemDao.insertarItem(item);
    }

    private Audio buscarAudio(String id){
        ItemDao itemDao = new AudioDaoImpl();
        try {
            return (Audio) itemDao.buscarItemPorID(id);
        } catch (SQLException ex) {
            return null;
        }
    }
    
    private AudioLibro buscarAudioLibro(String id){
        ItemDao itemDao = new AudioLibroDaoImpl();
        try {
            return (AudioLibro) itemDao.buscarItemPorID(id);
        } catch (SQLException ex) {
            return null;
        }
    }
    
    private Ensayo buscarEnsayo(String id){
        ItemDao itemDao = new EnsayoDaoImpl();
        try {
            return (Ensayo) itemDao.buscarItemPorID(id);
        } catch (SQLException ex) {
            return null;
        }
    }
    
    private Pelicula buscarPelicula(String id){
        ItemDao itemDao = new PeliculaDaoImpl();
        try {
            return (Pelicula) itemDao.buscarItemPorID(id);
        } catch (SQLException ex) {
            return null;
        }
    }
    
    private Libro buscarLibro(String id){
        ItemDao itemDao = new LibroDaoImpl();
        try {
            return (Libro) itemDao.buscarItemPorID(id);
        } catch (SQLException ex) {
            return null;
        }
    }
    
    private Periodico buscarPeriodico(String id){
        ItemDao itemDao = new PeriodicoDaoImpl();
        try {
            return (Periodico) itemDao.buscarItemPorID(id);
        } catch (SQLException ex) {
            return null;
        }
    }
    
    private Revista buscarRevista(String id){
        ItemDao itemDao = new RevistaDaoImpl();
        try {
            return (Revista) itemDao.buscarItemPorID(id);
        } catch (SQLException ex) {
            return null;
        }
    }
    
    private Software buscarSoftware(String id){
        ItemDao itemDao = new SoftwareDaoImpl();
        try {
            return (Software) itemDao.buscarItemPorID(id);
        } catch (SQLException ex) {
            return null;
        }
    }
    
    private Tesis buscarTesis(String id){
        ItemDao itemDao = new TesisDaoImpl();
        try {
            return (Tesis) itemDao.buscarItemPorID(id);
        } catch (SQLException ex) {
            return null;
        }
    }
    
    private Video buscarVideo(String id){
        ItemDao itemDao = new VideoDaoImpl();
        try {
            return (Video) itemDao.buscarItemPorID(id);
        } catch (SQLException ex) {
            return null;
        }
    }
    
    @Override
    public Item buscarItemPorID(String id) throws SQLException {
        Audio audio = buscarAudio(id);
        AudioLibro audioLibro = buscarAudioLibro(id);
        Ensayo ensayo = buscarEnsayo(id);
        Libro libro = buscarLibro(id);
        Pelicula pelicula = buscarPelicula(id);
        Periodico periodico = buscarPeriodico(id);
        Revista revista = buscarRevista(id);
        Software software = buscarSoftware(id);
        Tesis tesis = buscarTesis(id);
        Video video = buscarVideo(id);
        
        if(audio!= null){
            return audio;
        }else{
            if(audioLibro!=null){
                return audioLibro;
            }else{
                if(ensayo!=null){
                    return ensayo;
                }else{
                    if(libro!=null){
                        return libro;
                    }else{
                        if(pelicula!=null){
                            return pelicula;
                        }else{
                            if(periodico!=null){
                                return periodico;
                            }else{
                                if(revista!=null){
                                    return revista;
                                }else{
                                    if(software!=null){
                                        return software;
                                    }else{
                                        if(tesis!=null){
                                            return tesis;
                                        }else{
                                            if(video!=null){
                                                return video;
                                            }else{
                                                throw new SQLException("No se encontro Item con ID: "+ id);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public boolean eliminarItem(Item item) throws SQLException {
       ItemDao  itemDao = obtenerImplemetacionDaoDeItem(item);
       return itemDao.eliminarItem(item);
    }
    
}

