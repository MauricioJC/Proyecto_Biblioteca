package Dominio.Item;

public class Video extends Multimedia{
    private String titulo;
    private String areaEducativa;

    public Video() {
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAreaEducativa(String areaEducativa) {
        this.areaEducativa = areaEducativa;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAreaEducativa() {
        return areaEducativa;
    }
    
    
}
