package accesoDeDatos.Item;

import Dominio.Item.Item;
import Dominio.Item.AudioLibro;
import accesoDeDatos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AudioLibroDaoImpl implements ItemDao{
    private final Conexion conexion;
    private Connection connection;
    private PreparedStatement consulta;
    private ResultSet resultados;

    public AudioLibroDaoImpl() {
        this.conexion = new Conexion();
    }
    
    @Override
    public boolean insertarItem(Item item)throws SQLException {
        AudioLibro audioLibro = (AudioLibro)item;
        
        try {
            this.connection = this.conexion.obtenerConexion();
            this.consulta = this.connection.prepareStatement("INSERT INTO audiolibro VALUES (?,?,?,?,?,?)");
            this.consulta.setString(1,audioLibro.getIdItem());
            this.consulta.setString(2, audioLibro.getEstado());
            this.consulta.setInt(3, audioLibro.getDiasDePrestamo());
            this.consulta.setString(4, audioLibro.getNombre());
            this.consulta.setString(5, audioLibro.getNarrador() );
            this.consulta.setString(6, audioLibro.getDuracion());
            
            this.consulta.executeUpdate();   
        } catch (SQLException ex) {
            throw new SQLException("Fallo al insertar Audio Libro");
        }finally{
            this.conexion.desconecta();
        }
        return true;
    }

    @Override
    public Item buscarItemPorID(String id)throws SQLException {
        AudioLibro audioLibro = new AudioLibro();
        try{    
            this.connection = this.conexion.obtenerConexion();
            this.consulta = this.connection.prepareStatement("SELECT * FROM audioLibro WHERE idItem = ?");
            this.consulta.setString(1, id);
            this.resultados = this.consulta.executeQuery();
            this.resultados.next();
            
            audioLibro.setIdItem(this.resultados.getString("idItem"));
            audioLibro.setEstado(this.resultados.getString("estado"));
            audioLibro.setDiasDePrestamo(this.resultados.getInt("diasDePrestamo"));
            audioLibro.setNombre(this.resultados.getString("nombre"));
            audioLibro.setNarrador(this.resultados.getString("narrador"));
            audioLibro.setDuracion(this.resultados.getString("duracion"));
        }catch(SQLException ex){
             throw new SQLException("Error al buscar Audio Libro por ID");
        }finally{
            this.conexion.desconecta();
        }
        return audioLibro;
    }

    @Override
    public boolean eliminarItem(Item item)throws SQLException {  
        this.connection = this.conexion.obtenerConexion();
        this.consulta = this.connection.prepareStatement("DELETE FROM audioLibro WHERE idItem = ?");
        this.consulta.setString(1, item.getIdItem());
        int resultado = this.consulta.executeUpdate();
        
        if(resultado==0){
            throw new SQLException("No se pudo eliminar, Audio Libro con ID: "+ item.getIdItem());
        }
        this.conexion.desconecta();
        return true;
    }
}
