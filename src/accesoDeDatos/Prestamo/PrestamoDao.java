package accesoDeDatos.Prestamo;

import Dominio.EstadoPrestamo;
import Dominio.Prestamo;
import java.sql.SQLException;

public interface PrestamoDao {
    
    public boolean insertarPrestamo(Prestamo prestamo)throws SQLException;
    public Prestamo bucarPrestamoPorId()throws SQLException;
    public boolean modificarEstadoDePrestamo(Prestamo prestamo,EstadoPrestamo estado)throws SQLException;
}
