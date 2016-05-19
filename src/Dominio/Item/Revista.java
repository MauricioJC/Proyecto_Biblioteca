package Dominio.Item;

public class Revista extends Texto{
    private String nombreRevista;
    private String numeroDeRevista;

    public Revista() {
    }

    public void setNombreRevista(String nombreRevista) {
        this.nombreRevista = nombreRevista;
    }

    public void setNumeroDeRevista(String numeroDeRevista) {
        this.numeroDeRevista = numeroDeRevista;
    }

    public String getNombreRevista() {
        return nombreRevista;
    }

    public String getNumeroDeRevista() {
        return numeroDeRevista;
    }
}
