package accesoDeDatos.Item;

import Dominio.Item.Item;
import java.sql.SQLException;

public interface ItemDao {
    public boolean insertarItem(Item item)throws SQLException ;
    public Item buscarItemPorID(String id)throws SQLException ;
    public boolean eliminarItem(Item item)throws SQLException ;
}
