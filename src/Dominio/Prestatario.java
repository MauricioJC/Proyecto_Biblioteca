package Dominio;

public class Prestatario {
    
    private int idPrestatario;
    private String nombre;
    private String primerApellido;
    private String segundoApellido = null;
    private int numeroDePrestamos;
    private String correo;
    
    public Prestatario() {
    }
    
    public Prestatario(int idPrestatario, String nombre, String primerApellido, String segundoApellido, int numeroDePrestamos, String correo) {
        this.idPrestatario = idPrestatario;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.numeroDePrestamos = numeroDePrestamos;
        this.correo = correo;
    }



    public void setIdPrestatario(int idPrestatario) {
        this.idPrestatario = idPrestatario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public void setNumeroDePrestamos(int numeroDePrestamos) {
        this.numeroDePrestamos = numeroDePrestamos;
    }
    
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getIdPrestatario() {
        return idPrestatario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public int getNumeroDePrestamos() {
        return numeroDePrestamos;
    }

    public String getCorreo() {
        return correo;
    }
}
