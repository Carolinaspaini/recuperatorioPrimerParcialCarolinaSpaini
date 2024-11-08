package modelo1;
import java.time.LocalDate;


public abstract class Pedido {
    private static int id = 1;
    private int idPedido;
    private LocalDate fechaCreacion;
    private double montoBase;

    public Pedido( LocalDate fechaCreacion, double montoBase) {
        this.idPedido = id ++;
        this.fechaCreacion = fechaCreacion;
        this.montoBase = montoBase;
    }
    
    public abstract double calcularPrecioFinal();

    public static int getId() {
        return id;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public double getMontoBase() {
        return montoBase;
    }

    @Override
    public String toString() {
        return "Pedido{" + "idPedido=" + idPedido + ", fechaCreacion=" + fechaCreacion + ", montoBase=" + montoBase + '}';
    }
    
    
    
    
    
    
    
}
