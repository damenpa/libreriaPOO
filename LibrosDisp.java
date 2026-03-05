public class LibrosDisp extends Notificacion<Libro> {

    
     public LibrosDisp(Libro lib){
        super(lib);
     }

     public String arrojarNotificacion(){
        if(super.objetoBiblioteca.isPrestado()){
            super.mensaje = "El libro aun esta en un prestamo";
            return mensaje;
        }
        return mensaje = "EL libro: "+super.objetoBiblioteca.getTitulo()+ " ya esta disponible!!!!\n";
     }

     
}
