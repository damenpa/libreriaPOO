import java.time.LocalTime;
import java.util.*;

public class Empleado extends Persona {
    private String numeroEmpleado;
    private String puesto;
    private double salario;
    private int turno;
    private Queue<Prestamo> prestamosEnProceso;
    private List<Prestamo> historialPrestamos;
    private LocalTime horaEntrada;
    private LocalTime horaSalida;
    private static int contadorId = 0;
    public static final int MATUTINO = 0;
    public static final int VESPERTINO = 1;
    public static final int MIXTO = 2;
    // 1 = Basico 2 = Supervisor 3 = Gerente
    public int nivPermiso;


    public Empleado(String nombre, String id, String numeroEmpleado, String puesto, int nivPermiso,LocalTime entrada, LocalTime salida) {
        super(nombre, id);
        this.numeroEmpleado = numeroEmpleado;
        this.puesto = puesto;
        this.horaEntrada = entrada;
        this.horaSalida = salida;
        this.nivPermiso = nivPermiso;

        this.prestamosEnProceso = new LinkedList<>();
        this.historialPrestamos = new ArrayList<>();

    }
    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario > 0 ? salario : 0;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public String obtenerTipo() {
        return "Empleado";
    }
    public String getHorario(){
        if(horaEntrada == null && horaSalida == null)
        return" Sin horario asignado";

        else{
            return ("Hora de entrada: " + horaEntrada +"\nHora salida: " +horaSalida);
        }
    }
    public void setHoraEntrada(LocalTime entrada){
        this.horaEntrada = entrada;

    }
    public void setHoraSalida(LocalTime salida){
        this.horaSalida = salida;
    }
    public static String generarId() {
        contadorId++;
        return "P" + String.format("%04d", contadorId);
    }
    public boolean procesarPrestamo(Libro libro, Usuario usuario, String fechaPrestamo) 
    { 
        if (libro != null && usuario != null && !libro.isPrestado()) 
        {
            if (usuario.solicitarPrestamo(libro)) 
            {
                Prestamo nuevoPrestamo = new Prestamo(generarId(), usuario, libro);
                prestamosEnProceso.offer(nuevoPrestamo);
                historialPrestamos.add(nuevoPrestamo);
                return true;
            }
        }
        return false;
    }

        public boolean devolverPrestamo() 
        {
		    Prestamo prestamo = prestamosEnProceso.poll();
            return prestamo != null;
		}

        public Prestamo getPrestamoGestionado() {
            return prestamosEnProceso.peek();
        }

    public String toString() {
        return "<<<<<Empleado>>>>\npuesto=" + puesto + 
               ", \nsalario=" + salario + 
               " \nturno=" + turno + 
               " \nprestamos activos=" + prestamosEnProceso.size() +
               ", \nnombre=" + getNombre() + 
               ", \nid=" + getId() +
               "\nHora entrada: "+horaEntrada+
               "\nHora salida: "+ horaSalida;
    }

    public Queue<Prestamo> getPrestamosEnProceso()
    {
        return new LinkedList<>(prestamosEnProceso);
    }

    public List<Prestamo> getHistorialPrestamos()
    {
        return new ArrayList<>(historialPrestamos);
    }


}
