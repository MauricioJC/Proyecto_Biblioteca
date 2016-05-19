package Dominio.Item;

public abstract class Multimedia extends Item {
    private String nombre;

    public Multimedia() {
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
    
}
