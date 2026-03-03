import java.time.LocalTime;

public class Empleado extends Persona {
    private String numeroEmpleado;
    private String puesto;
    private double salario;
    private int turno;
    private Prestamo prestamoGestionado;
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
        this.prestamoGestionado = null;
        this.horaEntrada = entrada;
        this.horaSalida = salida;
        this.nivPermiso = nivPermiso;

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

    public Prestamo getPrestamoGestionado() {
        return prestamoGestionado;
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
    public boolean procesarPrestamo(Libro libro, Usuario usuario) { 
        if (libro != null && usuario != null && !libro.isPrestado()) {
            if (usuario.solicitarPrestamo(libro)) {
                prestamoGestionado = new Prestamo(generarId(), usuario, libro);
                return true;
            }
        }
        return false;
    }
    public boolean devolverPrestamo() {
		    if (prestamoGestionado != null) {
		        prestamoGestionado = null;
		        return true;
		    }
		    return false;
		}
    public String toString() {
        return "<<<<<Empleado>>>>\npuesto=" + puesto + 
               ", \nsalario=" + salario + 
               " \nturno=" + turno + 
               ", \nprestamoGestionado=" + prestamoGestionado + 
               ", \nnombre=" + getNombre() + 
               ", \nid=" + getId() +
               "\nHora entrada: "+horaEntrada+
               "\nHora salida: "+ horaSalida;
    }

}
