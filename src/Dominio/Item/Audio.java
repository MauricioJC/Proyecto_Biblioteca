package Dominio.Item;
public class Audio extends Multimedia{
    private String areaEducativa;
    private String duracion;

    public Audio() {
    }

    public void setAreaEducativa(String areaEducativa) {
        this.areaEducativa = areaEducativa;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getAreaEducativa() {
        return areaEducativa;
    }

    public String getDuracion() {
        return duracion;
    }
}
