package Dominio.Item;

public class Ensayo extends Texto {
    private String Titulo;
    private String lugarDePublicacion;

    public Ensayo() {
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public void setLugarDePublicacion(String lugarDePublicacion) {
        this.lugarDePublicacion = lugarDePublicacion;
    }

    public String getTitulo() {
        return Titulo;
    }

    public String getLugarDePublicacion() {
        return lugarDePublicacion;
    }
    
}
