/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package companias;

/**
 *
 * @author sergio
 */
public class Compania {

    private String nombre;
    private String rutaIcono;
    private String rutaConfig;
    
    public Compania(String _nombre) {
        this.nombre = _nombre;
    }

    Compania() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getRutaIcono() {
        return rutaIcono;
    }

    public String getRutaConfig() {
        return rutaConfig;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRutaIcono(String rutaIcono) {
        this.rutaIcono = rutaIcono;
    }

    public void setRutaConfig(String rutaConfig) {
        this.rutaConfig = rutaConfig;
    }
    
}
