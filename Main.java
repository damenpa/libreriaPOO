import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {


        // Crear una instancia de la biblioteca
        Biblioteca biblioteca = new Biblioteca("Biblioteca Central", "Av. Principal #123");
        
        // Crear y agregar empleado
        Empleado empleado = new Empleado("José Iturbide", "EMP001", "EMP001", "Bibliotecario", 1, LocalTime.of(9, 0), LocalTime.of(17, 0));
        empleado.setSalario(1000.00);
        empleado.setTurno(Empleado.MATUTINO);
        biblioteca.agregarEmpleado(empleado);

        // Crear y agregar usuario
        Usuario usuario = new Usuario("junan", "fr");
        biblioteca.agregarUsuario(usuario);


        // Crear y agregar algunos libros
        Libro libro1 = new Libro("El Principito", "Antoine de Saint-Exupéry", "978-0156012195", 96, "Cuento");
        biblioteca.agregarLibro(libro1);
        
        // Probar busqueda de libro
        System.out.println("Búsqueda de libros con 'El':");
        for (Libro libro : biblioteca.buscarLibrosPorTitulo("El")) {
            System.out.println(libro.getTitulo());
        }

        // Probar prestamo de libro
        System.out.println("\nProbando préstamo de libro:");
        if (biblioteca.prestarLibro("978-0156012195", "fr", "EMP001", "2026-03-04")) {
            System.out.println("Préstamo realizado con éxito");
        } else {
            System.out.println("No se pudo realizar el préstamo");
        }

        // Mostrar libros prestados
        System.out.println("\nLibros prestados:");
        for (Libro libro : biblioteca.getLibrosPrestados()) {
            System.out.println(libro.getTitulo());
        }

        // Probar devolución de libro
        System.out.println("\nProbando devolución de libro:");
        if (biblioteca.devolverLibro("978-0156012195", "EMP001")) {
            System.out.println("Devolución realizada con éxito");
        } else {
            System.out.println("No se pudo realizar la devolución");
        }

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
        

        // Notificaciones
        System.out.println(biblioteca.bandejaEntrada());
        biblioteca.devolverLibro(null, null);


        //Prueba de multa
        System.out.println("\n===== PRUEBA DE MULTA =====");
        System.out.println();

        Prestamo prestamo = new Prestamo("P100", usuario, libro1);

        prestamo.setFechaDevolucionEsperada(LocalDate.now().minusDays(5));
        prestamo.procesarDevolucion("2026-03-04");

        // Verificar multa
        if (prestamo.tieneMulta()) {
            Recibo recibo = prestamo.generarRecibo();
            recibo.imprimir();
        }

        /*Empleado horario */
        System.out.println("======Horario entrada-salida Empleado====");
        System.out.println(biblioteca.obtenerEmpleado("EMP001").toString());

        // Mostrar estado final de la biblioteca
        System.out.println("\nEstado final de la biblioteca:");
        System.out.println(biblioteca.toString());
    }
}   