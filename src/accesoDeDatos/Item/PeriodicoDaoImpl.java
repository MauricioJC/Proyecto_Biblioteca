package accesoDeDatos.Item;

import Dominio.Item.Item;
import Dominio.Item.Periodico;
import accesoDeDatos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PeriodicoDaoImpl implements ItemDao {
    private final Conexion conexion;
    private Connection connection;
    private PreparedStatement consulta;
    private ResultSet resultados;

    public PeriodicoDaoImpl() {
        this.conexion = new Conexion();
    }
    
    @Override
    public boolean insertarItem(Item item)throws SQLException {
        Periodico periodico = (Periodico)item;
        
        try {
            this.connection = this.conexion.obtenerConexion();
            this.consulta = this.connection.prepareStatement("INSERT INTO periodico VALUES (?,?,?,?,?,?,?,?)");
            this.consulta.setString(1, periodico.getIdItem());
            this.consulta.setString(2, periodico.getEstado());
            this.consulta.setInt(3, periodico.getDiasDePrestamo());
            this.consulta.setString(4, periodico.getEditorial());
            this.consulta.setString(5, periodico.getFechaDePublicacion());
            this.consulta.setInt(6, periodico.getNumeroDeHojas());
            this.consulta.setString(7, periodico.getAutor());
            this.consulta.setString(8,periodico.getNombrePeriodico());
            this.consulta.executeUpdate();   
        } catch (SQLException ex) {
            throw new SQLException("Fallo al insertar periodico");
        }finally{
            this.conexion.desconecta();
        }
        return true;
    }

    @Override
    public Item buscarItemPorID(String id)throws SQLException {
        Periodico periodico = new Periodico();
        try{    
            this.connection = this.conexion.obtenerConexion();
            this.consulta = this.connection.prepareStatement("SELECT * FROM periodico WHERE idItem = ?");
            this.consulta.setString(1, id);
            this.resultados = this.consulta.executeQuery();
            this.resultados.next();
            
            periodico.setIdItem(this.resultados.getString("idItem"));
            periodico.setEstado(this.resultados.getString("estado"));
            periodico.setDiasDePrestamo(this.resultados.getInt("diasDePrestamo"));
            periodico.setEditorial(this.resultados.getString("editorial"));
            periodico.setFechaDePublicacion(this.resultados.getString("fechaDePublicacion"));
            periodico.setNumeroDeHojas(this.resultados.getInt("numeroDeHojas"));
            periodico.setAutor(this.resultados.getString("autor"));
            periodico.setNombrePeriodico(this.resultados.getString("nombrePeriodico"));
        }catch(SQLException ex){
             throw new SQLException("Error al buscar periodico por ID");
        }finally{
            this.conexion.desconecta();
        }
        return periodico;
    }

    @Override
    public boolean eliminarItem(Item item)throws SQLException {  
        this.connection = this.conexion.obtenerConexion();
        this.consulta = this.connection.prepareStatement("DELETE FROM periodico WHERE idItem = ?");
        this.consulta.setString(1, item.getIdItem());
        int resultado = this.consulta.executeUpdate();
        
        if(resultado==0){
            throw new SQLException("No se pudo eliminar periodico con ID: " + item.getIdItem());
        }
        this.conexion.desconecta();
        return true;
    }
}
