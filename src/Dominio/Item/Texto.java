package Dominio.Item;

public abstract class Texto extends Item{
    
    private String editorial;
    private String fechaDePublicacion;
    private int numeroDeHojas;
    private String autor;

    public Texto() {
    }
    
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public void setFechaDePublicacion(String fechaDePublicacion) {
        this.fechaDePublicacion = fechaDePublicacion;
    }

    public void setNumeroDeHojas(int numeroDeHojas) {
        this.numeroDeHojas = numeroDeHojas;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
    
    public String getEditorial() {
        return editorial;
    }

    public String getFechaDePublicacion() {
        return fechaDePublicacion;
    }

    public int getNumeroDeHojas() {
        return numeroDeHojas;
    }

    public String getAutor() {
        return autor;
    }
    
}
