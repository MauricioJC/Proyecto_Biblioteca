package accesoDeDatos.Item;

import Dominio.Item.Audio;
import Dominio.Item.Item;
import accesoDeDatos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AudioDaoImpl implements ItemDao {
    private final Conexion conexion;
    private Connection connection;
    private PreparedStatement consulta;
    private ResultSet resultados;

    public AudioDaoImpl() {
        this.conexion = new Conexion();
    }
    
    @Override
    public boolean insertarItem(Item item)throws SQLException {
        Audio audio = (Audio)item;
        
        try {
            this.connection = this.conexion.obtenerConexion();
            this.consulta = this.connection.prepareStatement("INSERT INTO audio VALUES (?,?,?,?,?,?)");
            this.consulta.setString(1, audio.getIdItem());
            this.consulta.setString(2, audio.getEstado());
            this.consulta.setInt(3, audio.getDiasDePrestamo());
            this.consulta.setString(4, audio.getNombre());
            this.consulta.setString(5, audio.getAreaEducativa());
            this.consulta.setString(6, audio.getDuracion());
            this.consulta.executeUpdate();   
        } catch (SQLException ex) {
            throw new SQLException("Fallo al insertar Audio");
        }finally{
            this.conexion.desconecta();
        }
        return true;
    }

    @Override
    public Item buscarItemPorID(String id)throws SQLException {
        Audio audio = new Audio();
        try{    
            this.connection = this.conexion.obtenerConexion();
            this.consulta = this.connection.prepareStatement("SELECT * FROM audio WHERE idItem = ?");
            this.consulta.setString(1, id);
            this.resultados = this.consulta.executeQuery();
            this.resultados.next();
            
            audio.setIdItem(this.resultados.getString("idItem"));
            audio.setEstado(this.resultados.getString("estado"));
            audio.setDiasDePrestamo(this.resultados.getInt("diasDePrestamo"));
            audio.setNombre(this.resultados.getString("nombre"));
            audio.setAreaEducativa(this.resultados.getString("areaEducativa"));
            audio.setDuracion(this.resultados.getString("duracion"));
        }catch(SQLException ex){
             throw new SQLException("Error al buscar Audio por ID");
        }finally{
            this.conexion.desconecta();
        }
        return audio;
    }

    @Override
    public boolean eliminarItem(Item item)throws SQLException {  
        this.connection = this.conexion.obtenerConexion();
        this.consulta = this.connection.prepareStatement("DELETE FROM audio WHERE idItem = ?");
        this.consulta.setString(1, item.getIdItem());
        int resultado = this.consulta.executeUpdate();
        
        if(resultado==0){
            throw new SQLException("No se pudo eliminar Audio con ID: " + item.getIdItem());
        }
        this.conexion.desconecta();
        return true;
    }
}
