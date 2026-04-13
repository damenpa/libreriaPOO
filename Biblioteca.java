import java.util.*;

public class Biblioteca {
    private String nombre;
    private String ubicacion;
    private Libro libro;
    private Usuario usuario;
    private Empleado empleadoBibliotecario;
    private PrestamoVencido vencido;
    private LibrosDisp disponibilidad;

    private List<Libro> libros; 
    private Set<Usuario> usuarios;
    private Map<String, Empleado> empleados;

    
    public Biblioteca(String nombre, String ubicacion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.empleadoBibliotecario = null;
        this.libro = null;
        this.usuario = null;

        this.libros = new ArrayList<>();
        this.usuarios = new HashSet<>();
        this.empleados = new HashMap<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void agregarLibro(Libro libro)
    {
        libros.add(libro);
    }

    public List<Libro> buscarLibrosPorTitulo(String titulo)
    {
        List<Libro> resultados = new ArrayList<>();
        for(Libro libro : libros)
        {
            if(libro.getTitulo().toLowerCase().contains(titulo.toLowerCase()))
            {
                resultados.add(libro);
            }
        }
        return resultados;
    }

    public void eliminarLibro(Libro libro)
    {
        libros.remove(libro);
    }

    public void agregarUsuario(Usuario usuario)
    {
        usuarios.add(usuario);
    }

    public void eliminarUsuario(Usuario usuario)
    {
        usuarios.remove(usuario);
    }

    public Usuario buscarUsuarioPorId(String id)
    {
        for(Usuario usuario : usuarios)
        {
            if(usuario.getId().equals(id))
            {
                return usuario;
            }
        }
        return null;
    }

    public void agregarEmpleado(Empleado empleado)
    {
        empleados.put(empleado.getId(), empleado);
    }

    public Empleado obtenerEmpleado(String id)
    {
        return empleados.get(id);
    }

    public void eliminarEmpleado(String id)
    {
        empleados.remove(id);
    }

    public boolean prestarLibro(String isbnjsjss, String idUsuario, String idEmpleado, String fechaPrestamo) {
		    Libro libro = null;
		    for (Libro l : libros) {
		        if (l.getIsbn().equals(isbnjsjss)) {
		            libro = l;
		            break;
		        }
		    }
		    
		    Usuario usuario = buscarUsuarioPorId(idUsuario);
		    Empleado empleado = empleados.get(idEmpleado);
		
		    if (libro != null && usuario != null && empleado != null && !libro.isPrestado()) {
		        return empleado.procesarPrestamo(libro, usuario, fechaPrestamo);
		    }
		    return false;
		}
    public boolean devolverLibro(String isbnjsjs, String idEmpleado) 
    {
		Libro libro = null;
		for (Libro l : libros) {
		    if (l.getIsbn().equals(isbnjsjs)) {
		        libro = l;
		        break;
		    }
		}
		    
		Empleado empleado = empleados.get(idEmpleado);
		
		if (libro != null && empleado != null && libro.isPrestado()) {
		    libro.devolverLibro();
		    empleado.devolverPrestamo();
		    return true;
		}
		return false;
	}
    public String bandejaEntrada(){
        String men = " ";
        if (libro != null && usuario != null && libro.isPrestado() &&
            empleadoBibliotecario != null && empleadoBibliotecario.getPrestamoGestionado() != null){
                vencido = new PrestamoVencido(empleadoBibliotecario.getPrestamoGestionado());
                men += vencido.arrojarNotificacion();
            }
            else{
                men = "no resgistros";
            }
            return men;
        
    }
    public List<Libro> getLibrosDisponibles() 
    {
    List<Libro> disponibles = new ArrayList<>();
    for (Libro libro : libros) {
        if (!libro.isPrestado()) {
            disponibles.add(libro);
        }
    }
    return disponibles;
    }
    public List<Libro> getLibrosPrestados() 
    {
        List<Libro> prestados = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.isPrestado()) {
                prestados.add(libro);
            }
        }
        return prestados;
    }
    public String toString() {
        String estado = "";
        estado += "Biblioteca: " + nombre + "\n";
        estado += "Ubicación: " + ubicacion + "\n";
        estado += "Total de libros: " + libros.size() + "\n";
        estado += "Libros disponibles: " + getLibrosDisponibles().size() + "\n";
        estado += "Libros prestados: " + getLibrosPrestados().size() + "\n";
        estado += "Total de usuarios registrados: " + usuarios.size() + "\n";
        estado += "Total de empleados: " + empleados.size() + "\n";
        estado += "\nLibros actualmente prestados:\n";
        for (Libro libro : getLibrosPrestados()) {
            estado += "- " + libro.getTitulo() + "\n";
        }
        
        return estado;
    }

}