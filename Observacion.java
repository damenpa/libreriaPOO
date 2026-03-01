import java.time.LocalDate;

public class Observacion {

    private int id;
    private String detalle;
    private boolean estado;
    private LocalDate fechaCreacion;
    private LocalDate fechaReparacion;

    public Observacion(int id, String detalle, LocalDate fechaCreacion) {
        this.estado = true;
        this.id = id;
        this.detalle = detalle;
        this.fechaCreacion = fechaCreacion;
        this.fechaReparacion = null;
    }

    public int getId() {
        return id;
    }

    public String getDetalle() {
        return detalle;
    }

    public boolean getEstado() {
        return estado;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public LocalDate getFechaReparacion() {
        return fechaReparacion;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setFechaReparacion(LocalDate fechaReparacion) {
        this.fechaReparacion = fechaReparacion;
    }

    public String toString() {
        return "Observacion ID: " + id + "\nDetalle: " + detalle + "\nEstado: " + (estado ? "Abierta" : "Cerrada") + "\nFecha de Creación: " + fechaCreacion + 
        "\nFecha de Reparación: " + (fechaReparacion == null ? "Sin atender" : fechaReparacion);
    }

}
