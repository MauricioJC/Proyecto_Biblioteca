package accesoDeDatos.Prestatario;
import java.sql.SQLException;
import java.util.List;
import Dominio.Prestatario;

public interface PrestatarioDao {

    public boolean insertarPrestatario(Prestatario prestatario)throws SQLException;
    public Prestatario buscarPrestatarioPorId(int id)throws SQLException;
    public List<Prestatario> buscarCoincidenciasDePrestatariosPorNombreYApellido(String nombre,String primerApellido)throws SQLException;
    public List<Prestatario> obtenerTodosLosPrestatarios()throws SQLException;
    public boolean eliminarPrestatario(Prestatario prestatario)throws SQLException;
    
    
}
