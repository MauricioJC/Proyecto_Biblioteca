package Dominio.Item;
public class AudioLibro extends Multimedia{
    private String narrador;
    private String duracion;

    public AudioLibro() {
    }

    public void setNarrador(String narrador) {
        this.narrador = narrador;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getNarrador() {
        return narrador;
    }

    public String getDuracion() {
        return duracion;
    }
    
}
