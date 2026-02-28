import java.util.*;
import java.time.LocalDate;

public class Libro {
   private String titulo;
   private String autor;
   private String isbn;
   private int numPaginas;
   private boolean prestado;
   private Vector<Observacion> observaciones;
   
   public Libro() {
    this.titulo = "Sin título";
    this.autor = "Desconocido";
    this.isbn = "0000000000000";
    this.numPaginas = 0;
    this.prestado = false;
    this.observaciones = new Vector<Observacion>();
    }
    public Libro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = "0000000000000";
        this.numPaginas = 0;
        this.prestado = false;
        this.observaciones = new Vector<Observacion>();
    }
    public Libro(String titulo, String autor, String isbn, int numPaginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.numPaginas = numPaginas;
        this.prestado = false;
        this.observaciones = new Vector<Observacion>();
    }
    public Libro(Libro otroLibro) {
        this.titulo = otroLibro.titulo;
        this.autor = otroLibro.autor;
        this.isbn = otroLibro.isbn;
        this.numPaginas = otroLibro.numPaginas;
        this.prestado = false;  // El nuevo libro siempre inicia como no prestado
        this.observaciones = new Vector<Observacion>();
    }   

    public String getTitulo() {
    return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo != null && !titulo.trim().isEmpty()) {
            this.titulo = titulo;
        }
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        if (autor != null && !autor.trim().isEmpty()) {
            this.autor = autor;
        }
    }

        public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        if (isbn != null && isbn.matches("\\d{13}")) {
            this.isbn = isbn;
        }
    }

        public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        if (numPaginas > 0) {
            this.numPaginas = numPaginas;
        }
    }

    public boolean isPrestado() {
        return prestado;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    public boolean prestarLibro() {
        if (!prestado) {
            prestado = true;
            return true;
        }
        return false;
    }

    public void devolverLibro() {
        prestado = false;
    }

    public boolean verificarDisponibilidad() {
        return !prestado;
    }

    public void agregarObservacion(Observacion observacion) {
        observaciones.add(observacion);
    }

    public void repararObservacion(int id) {
        for (Observacion obs : observaciones) {
            if(obs.getId() == id) {
                obs.setEstado(false);
                obs.setFechaReparacion(LocalDate.now());
                break;
            }
        }
    }

    public Vector<Observacion> getObservaciones() {
        return observaciones;
    }

    public String toString() {
        return "Libro: " + titulo + " por " + autor + 
            "\nISBN: " + isbn + 
            "\nPáginas: " + numPaginas +
            "\nEstado: " + (prestado ? "Prestado" : "Disponible");
    }

}