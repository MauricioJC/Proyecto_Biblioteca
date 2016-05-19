package Dominio.Item;

public abstract class Item {
    private String idItem;
    private String estado;
    private int diasDePrestamo;

    public Item() {
    }
    
    public void setIdItem(String idItem) {
        this.idItem = idItem;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setDiasDePrestamo(int diasDePrestamo) {
        this.diasDePrestamo = diasDePrestamo;
    }

    public String getIdItem() {
        return idItem;
    }

    public String getEstado() {
        return estado;
    }

    public int getDiasDePrestamo() {
        return diasDePrestamo;
    }
  
}
