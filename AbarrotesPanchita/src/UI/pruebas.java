/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import DAOs.ProductoDAO;
import Entidades.Producto;

/**
 *
 * @author Carlos
 */
public class pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ProductoDAO pd = new ProductoDAO();
        
        Producto entidad = pd.buscarPorId(1);//new Producto("Sabritas",18.00f,"ASDASDSA");
     //  pd.agregar(entidad);
        
        entidad.setNombre("Sabritas 2");
        
        pd.actualizar(entidad);
    }
    
}
