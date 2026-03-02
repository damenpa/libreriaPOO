public abstract class Notificacion<E>{
    protected E objetoBiblioteca;
    protected String mensaje;
    
    public Notificacion(E biblio){
        this.objetoBiblioteca = biblio;
        mensaje = new String();

    }

    public abstract String arrojarNotificacion();

}