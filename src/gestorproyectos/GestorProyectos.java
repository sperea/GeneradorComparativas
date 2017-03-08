/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestorproyectos;
import static java.awt.Frame.MAXIMIZED_BOTH;
import ui.mainForm;

/**
 *
 * @author sergio
 */
public class GestorProyectos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        mainForm ventana = new mainForm();
        ventana.setExtendedState(MAXIMIZED_BOTH);
        ventana.setVisible(true);
    }
    
}
