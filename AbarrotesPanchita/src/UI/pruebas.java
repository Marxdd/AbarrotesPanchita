/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import DAOs.ProductoDAO;
import DAOs.RelacionProductosVentasDAO;
import DAOs.VentaDAO;
import Entidades.Producto;
import Entidades.RelacionProductosVentas;
import Entidades.Venta;
import java.util.Calendar;

/**
 *
 * @author Abarrotes
 */
public class pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ProductoDAO pd = new ProductoDAO();
        
        RelacionProductosVentasDAO rpvD = new RelacionProductosVentasDAO();
        VentaDAO vD = new VentaDAO();
        
        Producto entidad =new Producto("Galletas",15.50f,"QEHJEE",false);// pd.buscarPorId(1);//
        pd.agregar(entidad);
        
        //entidad.setNombre("Sabritas 2");
        
        
        
        /*
        Todo esto es para agregar la venta y relacion
        
         Venta venta = new Venta(Calendar.getInstance(), entidad.getPrecio()*2);
        
        vD.agregar(venta);
        
        RelacionProductosVentas rpv = new RelacionProductosVentas(2, venta.getMontoTotal(), entidad, venta);
        
        rpvD.agregar(rpv);
        */
       
        
        
        //pd.actualizar(entidad);
        
        
        /*
        
        */
     //   Venta venta = vD.buscarPorId(1);
        
       // venta.setMontoTotal(entidad.getPrecio());
        
      //  vD.eliminar(venta);
        
        
    }
    
}
