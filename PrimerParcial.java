
package modelo1;

import java.time.LocalDate;
import java.util.List;
import modelo1.ErrorException;
import modelo1.Pedido;
import modelo1.PedidoElectronico;
import modelo1.PedidoPapelMensual;

import modelo1.Sistema;

public class PrimerParcial {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
       Sistema sistema = new Sistema();
       
       // 1-1 agregar un objecto
        System.out.println("1-1");
        try {
            sistema.agregarPedidoPapelMensual(LocalDate.of(2020, 12, 12), 2500.0, LocalDate.of(2020, 12, 15), 5);
            System.out.println("Pedido papel mensual agregado exitosamante");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        
        // 1-2 crear y agregar un objecto
        System.out.println("1-2");
        try {
            sistema.agregarPedidoElectronico(LocalDate.of(2020, 12, 12), 3000.0, "PC no funciona", 200.0);
            System.out.print("Pedido electronico agregado exitosamante");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        
        
        // 1-3 pruebas de creacion fallida
        System.out.println("1-3");
        try {
            sistema.agregarPedidoPapelMensual(LocalDate.of(2020, 12, 12), 2500.0, LocalDate.of(2020, 12, 15), 0);
            System.out.print("Pedido papel mensual agregado exitosamante");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        
        
      // 1-4 motivo electronico vacio
        System.out.println("1-4");
        try {
            sistema.agregarPedidoElectronico(LocalDate.of(2020, 12, 12), 3500.0, null, 200.0);
            System.out.print("Pedido electronico agregado exitosamante");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        
      // 2-1 
        System.out.println("2_1");
        Pedido pedido1 = sistema.traePedido(1);
        System.out.println("precio final del pedido de papel: "+ pedido1.calcularPrecioFinal());
        Pedido pedido2 = sistema.traePedido(2);
        System.out.println("El precio final del pedido electronico:"+ pedido2.calcularPrecioFinal());
        
        
     //3 pruebas de agregacion a la lista
     sistema.agregarPedidoPapelMensual(LocalDate.of(2020, 12, 12), 1200.0, LocalDate.of(2020, 12, 16), 3);
     sistema.agregarPedidoElectronico(LocalDate.of(2020, 12, 14), 3000.0, "PC no funciona", 210.0);
     sistema.agregarPedidoElectronico(LocalDate.of(2020, 12, 15), 3100.0, "monitor no funciona", 2100.0);
     System.out.println("Total de pedidos en el sistema: " + sistema.traerPedido().size());
     
     //4
     System.out.println("4-1");
     List<Pedido>pedidosConMotivo = sistema.traerPedido("PC no funciona");
     for(Pedido pedido : pedidosConMotivo){
         PedidoElectronico pe = (PedidoElectronico) pedido;
         System.out.println("Pedido electronico: "+ pe.getIdPedido() + "motivo" + pe.getMotivo());
         
     }
     
     
     System.out.println("4-2");
     System.out.println("total general: "+ sistema.calcularTotalGeneral());
        
            
    }
}
