public class Recibo 
{
    private String id;
    private Usuario usuario;
    private Libro libro;
    private long diasRetraso;
    private double monto;

    public Recibo(String id, Usuario usuario, Libro libro, long diasRetraso, double monto) 
    {
        this.id = id;
        this.usuario = usuario;
        this.libro = libro;
        this.diasRetraso = diasRetraso;
        this.monto = monto;
    }

    public void imprimir() 
    {
        System.out.println("===== RECIBO DE MULTA =====");
        System.out.println("Préstamo: " + id);
        System.out.println("Usuario: " + usuario.getNombre());
        System.out.println("Libro: " + libro.getTitulo());
        System.out.println("Días de retraso: " + diasRetraso);
        System.out.println("Total a pagar: $" + monto);
    }

}
