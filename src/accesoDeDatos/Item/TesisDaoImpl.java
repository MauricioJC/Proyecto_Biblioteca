package accesoDeDatos.Item;

import Dominio.Item.Item;
import Dominio.Item.Tesis;
import accesoDeDatos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TesisDaoImpl implements ItemDao {
    private final Conexion conexion;
    private Connection connection;
    private PreparedStatement consulta;
    private ResultSet resultados;

    public TesisDaoImpl() {
        this.conexion = new Conexion();
    }
    
    @Override
    public boolean insertarItem(Item item)throws SQLException {
        Tesis tesis = (Tesis)item;
        
        try {
            this.connection = this.conexion.obtenerConexion();
            this.consulta = this.connection.prepareStatement("INSERT INTO tesis VALUES (?,?,?,?,?,?,?,?,?,?)");
            this.consulta.setString(1, tesis.getIdItem());
            this.consulta.setString(2, tesis.getEstado());
            this.consulta.setInt(3, tesis.getDiasDePrestamo());
            this.consulta.setString(4,tesis.getEditorial());
            this.consulta.setString(5, tesis.getFechaDePublicacion());
            this.consulta.setInt(6, tesis.getNumeroDeHojas());
            this.consulta.setString(7, tesis.getAutor());
            this.consulta.setString(8,tesis.getTitulo());
            this.consulta.setString(9, tesis.getUniversidad());
            this.consulta.setString(10, tesis.getGradoAcademico());
            this.consulta.executeUpdate();   
        } catch (SQLException ex) {
            throw new SQLException("Fallo al insertar tesis");
        }finally{
            this.conexion.desconecta();
        }
        return true;
    }

    @Override
    public Item buscarItemPorID(String id)throws SQLException {
        Tesis tesis = new Tesis();
        try{    
            this.connection = this.conexion.obtenerConexion();
            this.consulta = this.connection.prepareStatement("SELECT * FROM tesis WHERE idItem = ?");
            this.consulta.setString(1, id);
            this.resultados = this.consulta.executeQuery();
            this.resultados.next();
            
            tesis.setIdItem(this.resultados.getString("idItem"));
            tesis.setEstado(this.resultados.getString("estado"));
            tesis.setDiasDePrestamo(this.resultados.getInt("diasDePrestamo"));
            tesis.setEditorial(this.resultados.getString("editorial"));
            tesis.setFechaDePublicacion(this.resultados.getString("fechaDePublicacion"));
            tesis.setNumeroDeHojas(this.resultados.getInt("numeroDeHojas"));
            tesis.setAutor(this.resultados.getString("autor"));
            tesis.setTitulo(this.resultados.getString("titulo"));
            tesis.setUniversidad(this.resultados.getString("universidad"));
            tesis.setGradoAcademico(this.resultados.getString("gradoAcademico"));
            
        }catch(SQLException ex){
             throw new SQLException("Error al buscar tesis por ID");
        }finally{
            this.conexion.desconecta();
        }
        return tesis;
    }

    @Override
    public boolean eliminarItem(Item item)throws SQLException {  
        this.connection = this.conexion.obtenerConexion();
        this.consulta = this.connection.prepareStatement("DELETE FROM tesis WHERE idItem = ?");
        this.consulta.setString(1, item.getIdItem());
        int resultado = this.consulta.executeUpdate();
        
        if(resultado==0){
            throw new SQLException("No se pudo eliminar tesis con ID: " + item.getIdItem());
        }
        this.conexion.desconecta();
        return true;
    }
}
