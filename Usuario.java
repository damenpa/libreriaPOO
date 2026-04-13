import java.util.*;

public class Usuario extends Persona{
    
    private List<Libro> librosPrestados;
    private Set<String> historialPrestamos;
    private Vector<String> generosPreferidos;
    

    public Usuario(String nombre, String id) {
        super(nombre, id);
        this.generosPreferidos = new Vector<String>();

        this.librosPrestados = new ArrayList<>();
        this.historialPrestamos = new HashSet<>();
    }
    
    public Usuario(Usuario usuario) {
        super(usuario.getNombre(), usuario.getId());
        this.librosPrestados = usuario.getLibrosPrestado();
    }

    public boolean solicitarPrestamo(Libro libro) {
        if (!libro.isPrestado() && libro.prestarLibro()) 
        {
            librosPrestados.add(libro);
            historialPrestamos.add(libro.getIsbn());
            return true;
        }
        return false;
    }

    public boolean devolverLibro(Libro libro) 
    {
        if (librosPrestados.contains(libro)) 
        {
            libro.devolverLibro();
            librosPrestados.remove(libro);
            return true;
        }
        return false;
    }

    /**
    * Deprecado, para eliminación: Este elemento de la API será eliminado en una versión futura.
    * Obtiene una copia del libro prestado actualmente 
    * 
    * @return Una copia del libro prestado o null si no hay préstamos activos
    */	

    public Libro getLibrosPrestados() 
    {
        if(librosPrestados.size() > 0)
            return new Libro(librosPrestados.get(0)); // Retorna una copia de la lista
        else
            return null;
    }

    public List<Libro> getLibrosPrestado()
    {
        return new ArrayList<>(librosPrestados);
    }

    public Set<String> getHistorialPrestamos() {
        return new HashSet<>(historialPrestamos);
    }

    public String obtenerTipo() {
		return "Usuario";
	}

    public Vector<String> getGenerosPreferidos() {
        return generosPreferidos;
    }

    public void setGenerosPreferidos(Vector<String> generosPreferidos) {
        this.generosPreferidos = generosPreferidos;
    }

    public String toString() {
        String cad = "ID: " + getId() + ", " + "Nombre: " + getNombre() + ".";
        if(librosPrestados.size()>0)
        {
            cad += "Tiene en prestamo" + librosPrestados.toString() + " libros.";
        }
        else
        {
            cad += "No tiene en prestamo un libro.";
        }
        return cad;
    }
    
}
