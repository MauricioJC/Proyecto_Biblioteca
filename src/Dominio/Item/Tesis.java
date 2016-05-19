package Dominio.Item;
public class Tesis extends Texto{
    private String titulo;
    private String universidad;
    private String gradoAcademico;

    public Tesis() {
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }

    public void setGradoAcademico(String gradoAcademico) {
        this.gradoAcademico = gradoAcademico;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getUniversidad() {
        return universidad;
    }

    public String getGradoAcademico() {
        return gradoAcademico;
    }
 
}
