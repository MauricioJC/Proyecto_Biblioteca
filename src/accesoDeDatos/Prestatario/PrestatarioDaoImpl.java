package accesoDeDatos.Prestatario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Dominio.Prestatario;
import accesoDeDatos.Conexion;

public class PrestatarioDaoImpl implements PrestatarioDao {
    private final Conexion conexion;
    private Connection connection;
    private PreparedStatement consulta;
    private ResultSet resultados;

    public PrestatarioDaoImpl() {
        this.conexion = new Conexion();
    }

    @Override
    public boolean insertarPrestatario(Prestatario prestatario)throws SQLException{
        try {
            this.connection = this.conexion.obtenerConexion();
            this.consulta = this.connection.prepareStatement("INSERT INTO Prestatario VALUES (?,?,?,?,?,?)");
            this.consulta.setInt(1,prestatario.getIdPrestatario());
            this.consulta.setString(2, prestatario.getNombre());
            this.consulta.setString(3, prestatario.getPrimerApellido());
            this.consulta.setString(4, prestatario.getSegundoApellido());
            this.consulta.setInt(5,prestatario.getNumeroDePrestamos());
            this.consulta.setString(6, prestatario.getCorreo());
            this.consulta.executeUpdate();
            return true;
        } catch (SQLException ex) {
            throw new SQLException("Fallo al insertar elemento");
        }finally{
            this.conexion.desconecta();
        }
    }

    @Override
    public Prestatario buscarPrestatarioPorId(int id)throws SQLException{
         Prestatario prestatario = new Prestatario();
        try{    
            this.connection = this.conexion.obtenerConexion();
            this.consulta = this.connection.prepareStatement("SELECT * FROM prestatario WHERE idPrestatario = ?");
            this.consulta.setInt(1, id);
            this.resultados = this.consulta.executeQuery();
            this.resultados.next();
            prestatario.setIdPrestatario(this.resultados.getInt("idPrestatario"));
            prestatario.setNombre(this.resultados.getString("nombre"));
            prestatario.setPrimerApellido(this.resultados.getString("primerApellido"));
            prestatario.setSegundoApellido(this.resultados.getString("segundoApellido"));
            prestatario.setNumeroDePrestamos(this.resultados.getInt("numeroDePrestamos"));
            prestatario.setCorreo(this.resultados.getString("correo"));
 
        }catch(SQLException ex){
             throw new SQLException("Error al buscar por ID");
        }finally{
            this.conexion.desconecta();
        }
        return prestatario;
    }

    @Override
     public List<Prestatario> buscarCoincidenciasDePrestatariosPorNombreYApellido(String nombre,String primerApellido)throws SQLException{
        List<Prestatario> prestatarios = new ArrayList<>();
        
        try{
            this.connection = this.conexion.obtenerConexion();
            this.consulta = this.connection.prepareStatement("SELECT * FROM prestatario WHERE nombre LIKE ? AND primerApellido LIKE ?");
            this.consulta.setString(1,"%"+ nombre + "%");
            this.consulta.setString(2,"%"+ primerApellido + "%");
            System.out.println("here_"+this.consulta);
            this.resultados = this.consulta.executeQuery();
            
            while(this.resultados.next()){
                Prestatario prestatario = new Prestatario();
                
                prestatario.setIdPrestatario(this.resultados.getInt("idPrestatario"));
                prestatario.setNombre(this.resultados.getString("nombre"));
                prestatario.setPrimerApellido(this.resultados.getString("primerApellido"));
                prestatario.setSegundoApellido(this.resultados.getString("segundoApellido"));
                prestatario.setNumeroDePrestamos(this.resultados.getInt("numeroDePrestamos"));
                prestatario.setCorreo(this.resultados.getString("correo"));
            
                prestatarios.add(prestatario);
            }
        }catch(SQLException ex){
            throw new SQLException("Error al obtener todos los contactos con la coincidencia");
        }finally{
            this.conexion.desconecta();
        }
        
        return prestatarios;
    }
    @Override
    public List<Prestatario> obtenerTodosLosPrestatarios()throws SQLException{
        List<Prestatario> prestatarios = new ArrayList<>();
        
        try{
            this.connection = this.conexion.obtenerConexion();
            this.consulta = this.connection.prepareStatement("SELECT * FROM prestatario");
            this.resultados = this.consulta.executeQuery();
            
            while(this.resultados.next()){
                Prestatario prestatario = new Prestatario();
                
                prestatario.setIdPrestatario(this.resultados.getInt("idPrestatario"));
                prestatario.setNombre(this.resultados.getString("nombre"));
                prestatario.setPrimerApellido(this.resultados.getString("primerApellido"));
                prestatario.setSegundoApellido(this.resultados.getString("segundoApellido"));
                prestatario.setNumeroDePrestamos(this.resultados.getInt("numeroDePrestamos"));
                prestatario.setCorreo(this.resultados.getString("correo"));
            
                prestatarios.add(prestatario);
            }
        }catch(SQLException ex){
            throw new SQLException("Error al obtener todos los contactos");
        }finally{
            this.conexion.desconecta();
        }
        
        return prestatarios;
    }
   
    @Override
    public boolean eliminarPrestatario(Prestatario prestatario)throws SQLException{
        
        this.connection = this.conexion.obtenerConexion();
        this.consulta = this.connection.prepareStatement("DELETE FROM prestatario WHERE idPrestatario = ?");
        this.consulta.setInt(1, prestatario.getIdPrestatario());
        int resultado = this.consulta.executeUpdate();
       
        if(resultado==0){
            throw new SQLException("No se pudo eliminar, ID no encontrado");
        }
        
        this.conexion.desconecta();
        return true;
    }
}
