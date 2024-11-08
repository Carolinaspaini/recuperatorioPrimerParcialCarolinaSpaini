

package modelo1;

import java.time.LocalDate;


public class PedidoPapelMensual extends Pedido {
    private LocalDate fechaEntrega;
    protected int cantidadResmas;

    public PedidoPapelMensual(LocalDate fechaEntrega, int cantidadResmas, LocalDate fechaCreacion, double montoBase) {
        super(fechaCreacion, montoBase);
        if(cantidadResmas <= 0){
            throw new ErrorException("No puede ser menor a cero");
        }
        this.fechaEntrega = fechaEntrega;
        
    }

    @Override
    public double calcularPrecioFinal() {
        return this.getMontoBase()* cantidadResmas;
    }

    @Override
    public String toString() {
        return "PedidoPapelMensual{" + "fechaEntrega=" + fechaEntrega + ", cantidadResmas=" + cantidadResmas + '}';
    }

    
    

    
    
    
    
    
    
}
