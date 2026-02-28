import java.util.*;

public class Usuario extends Persona{
    
    private Libro libroPrestado;
    private Vector<String> generosPreferidos;

    public Usuario(String nombre, String id) {
        super(nombre, id);
        this.libroPrestado = null;
        this.generosPreferidos = new Vector<String>();
    }
    
    public Usuario(Usuario usuario) {
        super(usuario.getNombre(), usuario.getId());
        this.libroPrestado = usuario.getLibrosPrestados();
        this.generosPreferidos = new Vector<String>();
    }

    public boolean solicitarPrestamo(Libro libro) {
        if (!libro.isPrestado()) {
            if (libro.prestarLibro()) {
                libroPrestado = libro;
                return true;
            }
        }
        return false;
    }

    public boolean devolverLibro() {
        if (libroPrestado != null) {
            libroPrestado.devolverLibro();
            libroPrestado = null;
            return true;
        }
        return false;
    }

    public Libro getLibrosPrestados() {
        if(libroPrestado != null)
            return new Libro(libroPrestado); // Retorna una copia de la lista
        else
            return null;
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
        String cad = "ID: " + getId() + ", " + "Nombre: " + getNombre() + ". \n";
        cad += "Géneros preferidos: ";
        for (String genero : generosPreferidos) 
            cad += genero + ", ";
        if (this.libroPrestado != null)
            cad += "\nTiene en préstamo" + libroPrestado.toString() +  ".";
        else
            cad += "\nNo tiene en préstamo un libro.";
        return cad;
    }
    
}
