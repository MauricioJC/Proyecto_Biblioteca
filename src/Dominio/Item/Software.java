package Dominio.Item;
public class Software extends Multimedia{
    private String plataforma;
    private String version;

    public Software() {
    }
    
    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public String getVersion() {
        return version;
    }
}
