package modelo1;

import java.time.LocalDate;

public class PedidoElectronico extends Pedido {

    private String motivo;
    private double porcentajeExtra;

    public PedidoElectronico(String motivo, double porcentajeExtra,  LocalDate fechaCreacion, double montoBase) {
        super(fechaCreacion, montoBase);
        if (motivo == null) {
            throw new ErrorException("Motivo  no puede estar vacio");
        }
        this.porcentajeExtra = porcentajeExtra;
    }

    @Override
    public double calcularPrecioFinal() {
        return this.getMontoBase()*(1 + porcentajeExtra/100);
    }

    @Override
    public String toString() {
        return "PedidoElectronico{" + "motivo=" + motivo + ", porcentajeExtra=" + porcentajeExtra + '}';
    }

    public String getMotivo() {
        return motivo;
    }

    public double getPorcentajeExtra() {
        return porcentajeExtra;
    }
    
    
    
    

}
