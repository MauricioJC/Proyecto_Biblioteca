package accesoDeDatos.Item;

import Dominio.Item.Item;
import Dominio.Item.Video;
import accesoDeDatos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class VideoDaoImpl implements ItemDao{
    private final Conexion conexion;
    private Connection connection;
    private PreparedStatement consulta;
    private ResultSet resultados;

    public VideoDaoImpl() {
        this.conexion = new Conexion();
    }
    
    @Override
    public boolean insertarItem(Item item)throws SQLException {
        Video video = (Video)item;
        
        try {
            this.connection = this.conexion.obtenerConexion();
            this.consulta = this.connection.prepareStatement("INSERT INTO video VALUES (?,?,?,?,?,?)");
            this.consulta.setString(1, video.getIdItem());
            this.consulta.setString(2, video.getEstado());
            this.consulta.setInt(3, video.getDiasDePrestamo());
            this.consulta.setString(4, video.getNombre());
            this.consulta.setString(5, video.getTitulo() );
            this.consulta.setString(6, video.getAreaEducativa());
            this.consulta.executeUpdate();   
        } catch (SQLException ex) {
            throw new SQLException("Fallo al insertar video");
        }finally{
            this.conexion.desconecta();
        }
        return true;
    }

    @Override
    public Item buscarItemPorID(String id)throws SQLException {
        Video video = new Video();
        try{    
            this.connection = this.conexion.obtenerConexion();
            this.consulta = this.connection.prepareStatement("SELECT * FROM video WHERE idItem = ?");
            this.consulta.setString(1, id);
            this.resultados = this.consulta.executeQuery();
            this.resultados.next();
            
            video.setIdItem(this.resultados.getString("idItem"));
            video.setEstado(this.resultados.getString("estado"));
            video.setDiasDePrestamo(this.resultados.getInt("diasDePrestamo"));
            video.setNombre(this.resultados.getString("nombre"));
            video.setTitulo(this.resultados.getString("titulo"));
            video.setAreaEducativa(this.resultados.getString("areaEducativa"));
        }catch(SQLException ex){
             throw new SQLException("Error al buscar video por ID");
        }finally{
            this.conexion.desconecta();
        }
        return video;
    }

    @Override
    public boolean eliminarItem(Item item)throws SQLException {  
        this.connection = this.conexion.obtenerConexion();
        this.consulta = this.connection.prepareStatement("DELETE FROM video WHERE idItem = ?");
        this.consulta.setString(1, item.getIdItem());
        int resultado = this.consulta.executeUpdate();
        
        if(resultado==0){
            throw new SQLException("No se pudo eliminar Video con ID: " + item.getIdItem());
        }
        this.conexion.desconecta();
        return true;
    }
}
