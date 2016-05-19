package Dominio.Item;

public class Periodico extends Texto{
    private String nombrePeriodico;

    public Periodico() {
    }
    
    public void setNombrePeriodico(String nombrePeriodico) {
        this.nombrePeriodico = nombrePeriodico;
    }

    public String getNombrePeriodico() {
        return nombrePeriodico;
    }
    
}
