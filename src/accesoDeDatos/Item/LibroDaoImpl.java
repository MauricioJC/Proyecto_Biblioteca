package accesoDeDatos.Item;

import Dominio.Item.Libro;
import Dominio.Item.Item;
import accesoDeDatos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LibroDaoImpl implements ItemDao {
    private final Conexion conexion;
    private Connection connection;
    private PreparedStatement consulta;
    private ResultSet resultados;

    public LibroDaoImpl() {
        this.conexion = new Conexion();
    }
    
    @Override
    public boolean insertarItem(Item item)throws SQLException {
        Libro libro = (Libro)item;
        
        try {
            this.connection = this.conexion.obtenerConexion();
            this.consulta = this.connection.prepareStatement("INSERT INTO libro VALUES (?,?,?,?,?,?,?,?,?)");
            this.consulta.setString(1, libro.getIdItem());
            this.consulta.setString(2, libro.getEstado());
            this.consulta.setInt(3, libro.getDiasDePrestamo());
            this.consulta.setString(4,libro.getEditorial());
            this.consulta.setString(5, libro.getFechaDePublicacion());
            this.consulta.setInt(6, libro.getNumeroDeHojas());
            this.consulta.setString(7, libro.getAutor());
            this.consulta.setString(8,libro.getTitulo());
            this.consulta.setString(9, libro.getPais());
            this.consulta.executeUpdate();   
        } catch (SQLException ex) {
            throw new SQLException("Fallo al insertar libro");
        }finally{
            this.conexion.desconecta();
        }
        return true;
    }

    @Override
    public Item buscarItemPorID(String id)throws SQLException {
        Libro libro = new Libro();
        try{    
            this.connection = this.conexion.obtenerConexion();
            this.consulta = this.connection.prepareStatement("SELECT * FROM libro WHERE idItem = ?");
            this.consulta.setString(1, id);
            this.resultados = this.consulta.executeQuery();
            this.resultados.next();
            
            libro.setIdItem(this.resultados.getString("idItem"));
            libro.setEstado(this.resultados.getString("estado"));
            libro.setDiasDePrestamo(this.resultados.getInt("diasDePrestamo"));
            libro.setEditorial(this.resultados.getString("editorial"));
            libro.setFechaDePublicacion(this.resultados.getString("fechaDePublicacion"));
            libro.setNumeroDeHojas(this.resultados.getInt("numeroDeHojas"));
            libro.setAutor(this.resultados.getString("autor"));
            libro.setTitulo(this.resultados.getString("titulo"));
            libro.setPais(this.resultados.getString("pais"));
            
        }catch(SQLException ex){
             throw new SQLException("Error al buscar libro por ID");
        }finally{
            this.conexion.desconecta();
        }
        return libro;
    }

    @Override
    public boolean eliminarItem(Item item)throws SQLException {  
        this.connection = this.conexion.obtenerConexion();
        this.consulta = this.connection.prepareStatement("DELETE FROM libro WHERE idItem = ?");
        this.consulta.setString(1, item.getIdItem());
        int resultado = this.consulta.executeUpdate();
        
        if(resultado==0){
            throw new SQLException("No se pudo eliminar libro con ID: " + item.getIdItem());
        }
        this.conexion.desconecta();
        return true;
    }
}
