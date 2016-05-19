package Dominio;

import Dominio.Item.Item;
import java.sql.Date;

public class Prestamo {

    private int idPrestamo;
    private Item item;
    private Prestatario prestatario;
    private Date fechaInicio;
    private EstadoPrestamo estado;

    public Prestamo() {
    }

    public Prestamo(int idPrestamo, Item item, Prestatario prestatario, Date fechaInicio, EstadoPrestamo estado) {
        this.idPrestamo = idPrestamo;
        this.item = item;
        this.prestatario = prestatario;
        this.fechaInicio = fechaInicio;
        this.estado = estado;
    }
    
    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void setPrestatario(Prestatario prestatario) {
        this.prestatario = prestatario;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setEstado(EstadoPrestamo estado) {
        this.estado = estado;
    }
    
    public int getIdPrestamo() {
        return idPrestamo;
    }

    public Item getItem() {
        return item;
    }

    public Prestatario getPrestatario() {
        return prestatario;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public EstadoPrestamo getEstado() {
        return estado;
    }
    
    
}
