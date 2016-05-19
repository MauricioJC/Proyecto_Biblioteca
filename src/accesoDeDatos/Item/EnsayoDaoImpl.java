package accesoDeDatos.Item;

import Dominio.Item.Item;
import Dominio.Item.Ensayo;
import accesoDeDatos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EnsayoDaoImpl implements ItemDao {
    private final Conexion conexion;
    private Connection connection;
    private PreparedStatement consulta;
    private ResultSet resultados;

    public EnsayoDaoImpl() {
        this.conexion = new Conexion();
    }
    
    @Override
    public boolean insertarItem(Item item)throws SQLException {
        Ensayo ensayo = (Ensayo)item;
        
        try {
            this.connection = this.conexion.obtenerConexion();
            this.consulta = this.connection.prepareStatement("INSERT INTO ensayo VALUES (?,?,?,?,?,?,?,?,?)");
            this.consulta.setString(1, ensayo.getIdItem());
            this.consulta.setString(2, ensayo.getEstado());
            this.consulta.setInt(3, ensayo.getDiasDePrestamo());
            this.consulta.setString(4,ensayo.getEditorial());
            this.consulta.setString(5, ensayo.getFechaDePublicacion());
            this.consulta.setInt(6, ensayo.getNumeroDeHojas());
            this.consulta.setString(7, ensayo.getAutor());
            this.consulta.setString(8,ensayo.getTitulo());
            this.consulta.setString(9, ensayo.getLugarDePublicacion());
            this.consulta.executeUpdate();   
        } catch (SQLException ex) {
            throw new SQLException("Fallo al insertar Ensayo");
        }finally{
            this.conexion.desconecta();
        }
        return true;
    }

    @Override
    public Item buscarItemPorID(String id)throws SQLException {
        Ensayo ensayo = new Ensayo();
        try{    
            this.connection = this.conexion.obtenerConexion();
            this.consulta = this.connection.prepareStatement("SELECT * FROM ensayo WHERE idItem = ?");
            this.consulta.setString(1, id);
            this.resultados = this.consulta.executeQuery();
            this.resultados.next();
            
            ensayo.setIdItem(this.resultados.getString("idItem"));
            ensayo.setEstado(this.resultados.getString("estado"));
            ensayo.setDiasDePrestamo(this.resultados.getInt("diasDePrestamo"));
            ensayo.setEditorial(this.resultados.getString("editorial"));
            ensayo.setFechaDePublicacion(this.resultados.getString("fechaDePublicacion"));
            ensayo.setNumeroDeHojas(this.resultados.getInt("numeroDeHojas"));
            ensayo.setAutor(this.resultados.getString("autor"));
            ensayo.setTitulo(this.resultados.getString("titulo"));
            ensayo.setLugarDePublicacion(this.resultados.getString("lugarDePublicacion"));
            
        }catch(SQLException ex){
             throw new SQLException("Error al buscar ensayo por ID");
        }finally{
            this.conexion.desconecta();
        }
        return ensayo;
    }

    @Override
    public boolean eliminarItem(Item item)throws SQLException {  
        this.connection = this.conexion.obtenerConexion();
        this.consulta = this.connection.prepareStatement("DELETE FROM ensayo WHERE idItem = ?");
        this.consulta.setString(1, item.getIdItem());
        int resultado = this.consulta.executeUpdate();
        
        if(resultado==0){
            throw new SQLException("No se pudo eliminar ensayo con ID: " + item.getIdItem());
        }
        this.conexion.desconecta();
        return true;
    }
}
