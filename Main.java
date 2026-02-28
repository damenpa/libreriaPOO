import java.time.LocalDate;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {

        // Crear una instancia de la biblioteca
        Biblioteca biblioteca = new Biblioteca("Biblioteca Central", "Av. Principal #123");
        biblioteca.setEmpleado("José Iturbide", "EMP001", 1000.00, "Bibliotecario", Empleado.MATUTINO);

        // Crear algunos libros
        Libro libro1 = new Libro("El Principito", "Antoine de Saint-Exupéry", "978-0156012195", 96);
        Libro libro2 = new Libro("Don Quijote", "Miguel de Cervantes", "978-8424922498", 863);

        //Proceso de observación
        System.out.println("=== Agregando observación al libro ===");
        Observacion observacion1 = new Observacion(1, "Mordieron una pagina", LocalDate.now());
        libro1.getObservaciones().add(observacion1);
        
        Vector<Observacion> observacionesLibro1 = libro1.getObservaciones();
        System.out.println("Libro: " + libro1.getTitulo() + ":");
        for (Observacion obs : observacionesLibro1) 
            System.out.println(obs.toString());
        
        System.out.println("\n=== Reparando observación del libro ===");
        libro1.repararObservacion(1);
        System.out.println("Libro '" + libro1.getTitulo() + ":");
        for (Observacion obs : observacionesLibro1) 
            System.out.println(obs.toString());

        
    }
}   