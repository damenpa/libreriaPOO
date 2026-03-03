import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Prestamo {
    private String id;
    private Usuario usuario;
    private Libro libro;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucionEsperada;
    private LocalDate fechaDevolucionReal;
    private int estado;
    private double multadia=10;

    public static final int ACTIVO = 0;
    public static final int DEVUELTO = 1;
    public static final int VENCIDO = 2;

    public Prestamo(String id, Usuario usuario, Libro libro) 
    {
		this.id = id;
        this.usuario = usuario;
        this.libro = libro;
        this.fechaPrestamo = LocalDate.now();
        this.fechaDevolucionEsperada = fechaPrestamo.plusDays(14); // 14 días de préstamo por defecto
        this.fechaDevolucionReal = null;
        this.estado = ACTIVO;
    }

    public String getId() { 
        return id; 
    }
    
    public Usuario getUsuario() { 
        return new Usuario(usuario); 
    }
    
    public Libro getLibro() { 
        return new Libro(libro); 
    }
    
    public LocalDate getFechaPrestamo() { 
        return fechaPrestamo; 
    }
    
    public LocalDate getFechaDevolucionEsperada() { 
        return fechaDevolucionEsperada; 
    }

    public void setFechaDevolucionEsperada(LocalDate fechaDevolucionEsperada) {
        this.fechaDevolucionEsperada = fechaDevolucionEsperada;
    }

    public LocalDate getFechaDevolucionReal() { 
        return fechaDevolucionReal; 
    }
    
    public int getEstado() { 
        return estado; 
    }
    public boolean registrarPrestamo() {
        if (libro.isPrestado() || usuario.getLibrosPrestados() != null) {
            return false;
        }
        if (usuario.solicitarPrestamo(libro)) {
            estado = ACTIVO;
            return true;
        }
        return false;
    }
    public boolean procesarDevolucion() {
        if (estado == ACTIVO) {
            fechaDevolucionReal = LocalDate.now();
            if (usuario.devolverLibro()) {
                estado = DEVUELTO;
                return true;
            }
        }
        return false;
    }
    public void verificarEstado() {
        if (estado == ACTIVO && LocalDate.now().isAfter(fechaDevolucionEsperada)) {
            estado = VENCIDO;
        }
    }
    
    public boolean extenderPrestamo(int dias) {
        if (estado == ACTIVO && !LocalDate.now().isAfter(fechaDevolucionEsperada)) {
            fechaDevolucionEsperada = fechaDevolucionEsperada.plusDays(dias);
            return true;
        }
        return false;
    }

    public long calcularDiasRetraso() 
    {
        if (fechaDevolucionReal == null) 
        {
            return 0;
        }

        long dias = ChronoUnit.DAYS.between(fechaDevolucionEsperada, fechaDevolucionReal);

        return Math.max(dias, 0);
    }

    public double calcularMulta() 
    {
        return calcularDiasRetraso() * multadia;
    }

    public boolean tieneMulta() 
    {
        return calcularDiasRetraso() > 0;
    }

    public Recibo generarRecibo() 
    {
        return new Recibo(id, usuario, libro, calcularDiasRetraso(), calcularMulta());
    }

}
