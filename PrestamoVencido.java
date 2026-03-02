import java.time.LocalDate;

public class PrestamoVencido extends Notificacion<Prestamo> {
    private LocalDate vence;
    private int diaVence;
    private int diaHoy;

    public PrestamoVencido(Prestamo pres){
        super(pres);
        vence = super.objetoBiblioteca.getFechaDevolucionEsperada();
        super.mensaje = new String();
        diaVence = vence.getDayOfMonth();
        diaHoy = LocalDate.now().getDayOfMonth();
    }

    @Override
    public String arrojarNotificacion(){
        if(vence.isAfter(LocalDate.now())){
            super.mensaje = "El prestamo expiro el: "+ vence +"\n";

        }
        else{
            super.mensaje = "El presamos aun tiene: "+(diaHoy-diaVence) + "dias de gracia \n";
        }
        return super.mensaje;
    } 
}
