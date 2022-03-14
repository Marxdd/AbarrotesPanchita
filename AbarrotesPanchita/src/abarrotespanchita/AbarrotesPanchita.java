/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abarrotespanchita;

import DAOs.ProductoDAO;
import Entidades.Producto;

/**
 *
 * @author Mario
 */
public class AbarrotesPanchita {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ProductoDAO pd = new ProductoDAO();
        
        Producto producto = new Producto("Galletas",15.50f,"AVGSY13");
        pd.agregar(producto);
        
    }
    
}
