package Dominio.Item;

public class Pelicula extends Multimedia {
    private String año;
    private String pais;
    private String director;
    private String duracion;

    public Pelicula() {
    }
    
    public void setAño(String año) {
        this.año = año;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getAño() {
        return año;
    }

    public String getPais() {
        return pais;
    }

    public String getDirector() {
        return director;
    }

    public String getDuracion() {
        return duracion;
    }

}
