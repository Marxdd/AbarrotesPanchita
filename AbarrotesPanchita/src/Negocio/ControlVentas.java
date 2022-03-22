
package Negocio;

/**
 *
 * @author boble
 */
public class ControlVentas {

    public ControlVentas() {
    }
     
    public float ventaNoGranel(int cantidad, float precio){
        return cantidad * precio;
    }
    
    public float ventaGranel(float cantidad, float precio){
        return cantidad * precio;
    }
    
}
