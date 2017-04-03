/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparativos;

import java.util.Hashtable;

/**
 *
 * @author sergio
 */
public class ComparativoComunidades {

    public ComparativoComunidades() {
        filas = new Hashtable<>();
    }

    public void addTexto(String clave, String textContent) {
        
        Hashtable<String,String> contenedor=new Hashtable<>();
        
        contenedor.put(clave, textContent);
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Hashtable<String,String> filas;

}
