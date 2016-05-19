package accesoDeDatos.Item;

import Dominio.Item.Revista;
import Dominio.Item.Item;
import accesoDeDatos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class RevistaDaoImpl implements ItemDao{
    private final Conexion conexion;
    private Connection connection;
    private PreparedStatement consulta;
    private ResultSet resultados;

    public RevistaDaoImpl() {
        this.conexion = new Conexion();
    }
    
    @Override
    public boolean insertarItem(Item item)throws SQLException {
        Revista revista = (Revista)item;
        
        try {
            this.connection = this.conexion.obtenerConexion();
            this.consulta = this.connection.prepareStatement("INSERT INTO revista VALUES (?,?,?,?,?,?,?,?,?)");
            this.consulta.setString(1, revista.getIdItem());
            this.consulta.setString(2, revista.getEstado());
            this.consulta.setInt(3, revista.getDiasDePrestamo());
            this.consulta.setString(4,revista.getEditorial());
            this.consulta.setString(5, revista.getFechaDePublicacion());
            this.consulta.setInt(6, revista.getNumeroDeHojas());
            this.consulta.setString(7, revista.getAutor());
            this.consulta.setString(8,revista.getNombreRevista());
            this.consulta.setString(9, revista.getNumeroDeRevista());
            this.consulta.executeUpdate();   
        } catch (SQLException ex) {
            throw new SQLException("Fallo al insertar revista");
        }finally{
            this.conexion.desconecta();
        }
        return true;
    }

    @Override
    public Item buscarItemPorID(String id)throws SQLException {
        Revista revista = new Revista();
        try{    
            this.connection = this.conexion.obtenerConexion();
            this.consulta = this.connection.prepareStatement("SELECT * FROM revista WHERE idItem = ?");
            this.consulta.setString(1, id);
            this.resultados = this.consulta.executeQuery();
            this.resultados.next();
            
            revista.setIdItem(this.resultados.getString("idItem"));
            revista.setEstado(this.resultados.getString("estado"));
            revista.setDiasDePrestamo(this.resultados.getInt("diasDePrestamo"));
            revista.setEditorial(this.resultados.getString("editorial"));
            revista.setFechaDePublicacion(this.resultados.getString("fechaDePublicacion"));
            revista.setNumeroDeHojas(this.resultados.getInt("numeroDeHojas"));
            revista.setAutor(this.resultados.getString("autor"));
            revista.setNombreRevista(this.resultados.getString("nombreRevista"));
            revista.setNumeroDeRevista(this.resultados.getString("numeroDeRevista"));
            
        }catch(SQLException ex){
             throw new SQLException("Error al buscar revista por ID");
        }finally{
            this.conexion.desconecta();
        }
        return revista;
    }

    @Override
    public boolean eliminarItem(Item item)throws SQLException {  
        this.connection = this.conexion.obtenerConexion();
        this.consulta = this.connection.prepareStatement("DELETE FROM revista WHERE idItem = ?");
        this.consulta.setString(1, item.getIdItem());
        int resultado = this.consulta.executeUpdate();
        
        if(resultado==0){
            throw new SQLException("No se pudo eliminar revista con ID: " + item.getIdItem());
        }
        this.conexion.desconecta();
        return true;
    }
}
