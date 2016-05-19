package Dominio.Item;

public class Libro extends Texto{
    
    private String titulo;
    private String pais;

    public Libro() {
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getPais() {
        return pais;
    }
}
