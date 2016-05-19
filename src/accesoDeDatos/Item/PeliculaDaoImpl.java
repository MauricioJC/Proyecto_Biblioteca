package accesoDeDatos.Item;

import Dominio.Item.Item;
import Dominio.Item.Pelicula;
import accesoDeDatos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PeliculaDaoImpl implements ItemDao{
    private final Conexion conexion;
    private Connection connection;
    private PreparedStatement consulta;
    private ResultSet resultados;

    public PeliculaDaoImpl() {
        this.conexion = new Conexion();
    }
    
    @Override
    public boolean insertarItem(Item item)throws SQLException {
        Pelicula pelicula = (Pelicula)item;
        
        try {
            this.connection = this.conexion.obtenerConexion();
            this.consulta = this.connection.prepareStatement("INSERT INTO pelicula VALUES (?,?,?,?,?,?,?,?)");
            this.consulta.setString(1, pelicula.getIdItem());
            this.consulta.setString(2, pelicula.getEstado());
            this.consulta.setInt(3, pelicula.getDiasDePrestamo());
            this.consulta.setString(4, pelicula.getNombre());
            this.consulta.setString(5, pelicula.getAño());
            this.consulta.setString(6, pelicula.getPais());
            this.consulta.setString(7, pelicula.getDirector());
            this.consulta.setString(8, pelicula.getDuracion());
            this.consulta.executeUpdate();   
        } catch (SQLException ex) {
            throw new SQLException("Fallo al insertar Pelicula");
        }finally{
            this.conexion.desconecta();
        }
        return true;
    }

    @Override
    public Item buscarItemPorID(String id)throws SQLException {
        Pelicula pelicula = new Pelicula();
        try{    
            this.connection = this.conexion.obtenerConexion();
            this.consulta = this.connection.prepareStatement("SELECT * FROM pelicula WHERE idItem = ?");
            this.consulta.setString(1, id);
            this.resultados = this.consulta.executeQuery();
            this.resultados.next();
            
            pelicula.setIdItem(this.resultados.getString("idItem"));
            pelicula.setEstado(this.resultados.getString("estado"));
            pelicula.setDiasDePrestamo(this.resultados.getInt("diasDePrestamo"));
            pelicula.setNombre(this.resultados.getString("nombre"));
            pelicula.setAño(this.resultados.getString("año"));
            pelicula.setPais(this.resultados.getString("pais"));
            pelicula.setDirector(this.resultados.getString("director"));
            pelicula.setDuracion(this.resultados.getString("duración"));
            
        }catch(SQLException ex){
             throw new SQLException("Error al buscar Pelicula por ID");
        }finally{
            this.conexion.desconecta();
        }
        return pelicula;
    }

    @Override
    public boolean eliminarItem(Item item)throws SQLException {  
        this.connection = this.conexion.obtenerConexion();
        this.consulta = this.connection.prepareStatement("DELETE FROM pelicula WHERE idItem = ?");
        this.consulta.setString(1, item.getIdItem());
        int resultado = this.consulta.executeUpdate();
        
        if(resultado==0){
            throw new SQLException("No se pudo eliminar Pelicula con ID: " + item.getIdItem());
        }
        this.conexion.desconecta();
        return true;
    }
}
