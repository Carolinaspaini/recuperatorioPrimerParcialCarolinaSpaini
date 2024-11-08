
package modelo1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Sistema {
    private List<Pedido>pedidos=new ArrayList <>();
    
    public boolean agregarPedidoPapelMensual(LocalDate fechaCreacion, double montoBase, LocalDate fechaEntrega, int cantidadResmas){
        for(Pedido pedido:pedidos){
            if(cantidadResmas <= 0){
                throw new ErrorException("La cantidad de resmas debe ser mayor a 0");
                
            }
        }
    pedidos.add(new PedidoPapelMensual(fechaEntrega,cantidadResmas,fechaCreacion,montoBase));
    return true;
   }
    
    public boolean agregarPedidoElectronico(LocalDate fechaCreacion,double montoBase, String motivo, double porcentajeExtra){
    try{
        pedidos.add(new PedidoElectronico(motivo, porcentajeExtra,fechaCreacion, montoBase));
        return true;
    }catch(IllegalArgumentException e){
        System.out.println("El motivo no puede estar vacio");
        return false;
    }
   }
    
   public List<Pedido>traerPedido(){
       return pedidos;
   }
   
   public Pedido traePedido(int idPedido){
       for(Pedido pedido : pedidos){
           if(pedido.getIdPedido()== idPedido){
               return pedido;
           }
       }
       return null;
   }
   
   public List<Pedido> traerPedido(String motivo){
       List<Pedido> resultado = new ArrayList<>();
      
       for(Pedido pedido : pedidos){
           if(pedido instanceof PedidoElectronico){
               PedidoElectronico p = (PedidoElectronico)pedido;
               if(p.getMotivo().equalsIgnoreCase(motivo)){
                   resultado.add(pedido);
                   
               }
           }
       }
       return resultado;
   }
   
 public double calcularTotalGeneral(){
     double total = 0;
             for(Pedido pedido : pedidos){
                 total += pedido.calcularPrecioFinal();
             }
        return total;
 }

    
 
    
}
