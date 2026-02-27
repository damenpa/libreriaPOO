public class Biblioteca {
    private String nombre;
    private String ubicacion;
    private Libro libro;
    private Usuario usuario;
    private Empleado empleadoBibliotecario;
    public Biblioteca(String nombre, String ubicacion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.empleadoBibliotecario = null;
        this.libro = null;
        this.usuario = null;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Empleado getEmpleadoBibliotecario() {
        return empleadoBibliotecario;
    }

    public void setEmpleado(String nombre, String Id, double salario, String puesto, int turno) {
        this.empleadoBibliotecario = new Empleado( nombre,  Id, "78", puesto);
        empleadoBibliotecario.setSalario(salario);
        empleadoBibliotecario.setTurno(turno);
    }

    public boolean prestarLibro() {
        if (libro != null && usuario != null && !libro.isPrestado() && empleadoBibliotecario != null) {
            return empleadoBibliotecario.procesarPrestamo(libro, usuario);
        }
        return false;
    }
    public boolean devolverLibro() {
        if (libro != null && usuario != null && libro.isPrestado() && 
            empleadoBibliotecario != null && empleadoBibliotecario.getPrestamoGestionado() != null) {
            libro.devolverLibro();
            empleadoBibliotecario.devolverPrestamo();
            return true;
        }
        return false;
    }
    public String toString() {
        String estado = "";
        estado += "Biblioteca: " + nombre + "\n";
        estado += "Ubicación: " + ubicacion + "\n";
        estado += "Libro actual: ";
        estado += (libro != null ? libro.getTitulo() : "Ninguno") + "\n";
        estado += "Usuario actual: ";
        estado += (usuario != null ? usuario.getNombre() : "Ninguno") + "\n";
        estado += "Bibliotecario: ";
        estado += (empleadoBibliotecario != null ? empleadoBibliotecario.getNombre() : "Sin asignar") + "\n";
        estado += "Estado préstamo: ";
        estado += (empleadoBibliotecario != null && empleadoBibliotecario.getPrestamoGestionado() != null ? 
                "Préstamo activo" : "Sin préstamos");
        return estado;
    }

}