package accesoDeDatos.Item;

import Dominio.Item.Item;
import Dominio.Item.Software;
import accesoDeDatos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SoftwareDaoImpl implements ItemDao {
    private final Conexion conexion;
    private Connection connection;
    private PreparedStatement consulta;
    private ResultSet resultados;

    public SoftwareDaoImpl() {
        this.conexion = new Conexion();
    }
    
    @Override
    public boolean insertarItem(Item item)throws SQLException {
        Software software = (Software)item;
        
        try {
            this.connection = this.conexion.obtenerConexion();
            this.consulta = this.connection.prepareStatement("INSERT INTO software VALUES (?,?,?,?,?,?)");
            this.consulta.setString(1, software.getIdItem());
            this.consulta.setString(2, software.getEstado());
            this.consulta.setInt(3, software.getDiasDePrestamo());
            this.consulta.setString(4, software.getNombre());
            this.consulta.setString(5, software.getPlataforma());
            this.consulta.setString(6, software.getVersion());
            this.consulta.executeUpdate();   
        } catch (SQLException ex) {
            throw new SQLException("Fallo al insertar elemento");
        }finally{
            this.conexion.desconecta();
        }
        return true;
    }

    @Override
    public Item buscarItemPorID(String id)throws SQLException {
        Software software = new Software();
        try{    
            this.connection = this.conexion.obtenerConexion();
            this.consulta = this.connection.prepareStatement("SELECT * FROM software WHERE idItem = ?");
            this.consulta.setString(1, id);
            this.resultados = this.consulta.executeQuery();
            this.resultados.next();
            
            software.setIdItem(this.resultados.getString("idItem"));
            software.setEstado(this.resultados.getString("estado"));
            software.setDiasDePrestamo(this.resultados.getInt("diasDePrestamo"));
            software.setNombre(this.resultados.getString("nombre"));
            software.setPlataforma(this.resultados.getString("plataforma"));
            software.setVersion(this.resultados.getString("version"));
        }catch(SQLException ex){
             throw new SQLException("Error al buscar por ID");
        }finally{
            this.conexion.desconecta();
        }
        return software;
    }

    @Override
    public boolean eliminarItem(Item item)throws SQLException {  
        this.connection = this.conexion.obtenerConexion();
        this.consulta = this.connection.prepareStatement("DELETE FROM software WHERE idItem = ?");
        this.consulta.setString(1, item.getIdItem());
        int resultado = this.consulta.executeUpdate();
        
        if(resultado==0){
            throw new SQLException("No se pudo eliminar software con ID: " + item.getIdItem());
        }
        this.conexion.desconecta();
        return true;
    }    
}
