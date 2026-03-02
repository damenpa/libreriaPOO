import java.time.LocalDate;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {

        // Crear una instancia de la biblioteca
        Biblioteca biblioteca = new Biblioteca("Biblioteca Central", "Av. Principal #123");
        biblioteca.setEmpleado("José Iturbide", "EMP001", 1000.00, "Bibliotecario", Empleado.MATUTINO,1);
        Usuario usuario = new Usuario("junan", "fr");
        biblioteca.setUsuario(usuario);

        // Crear algunos libros
        Libro libro1 = new Libro("El Principito", "Antoine de Saint-Exupéry", "978-0156012195", 96, "Cuento");

        biblioteca.setLibro(libro1);
        biblioteca.prestarLibro();
        


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

        //Generos preferidos
        System.out.println("\n=== Agregando géneros preferidos al usuario ===");
        Usuario usuario1 = new Usuario("Ana Pérez", "USR001");
        usuario1.getGenerosPreferidos().add("Cuento");
        usuario1.getGenerosPreferidos().add("Novela");
        System.out.println(usuario1.toString());
        
        /*Notificaciones*/
        System.out.println(biblioteca.bandejaEntrada());
        biblioteca.devolverLibro();

        
    }
}   