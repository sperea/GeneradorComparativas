/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdf;

import org.apache.pdfbox.tools.PDFToImage;

/**
 *
 * @author sergio
 */
public class Portada {
    
    private final String pathOfPdf;

    public Portada(String _pathOfPdf) 
    {

        pathOfPdf = _pathOfPdf;

    }
    
    public void CrearPortada(String pathPortada)
    {
        // Se convierte el PDF del catastro en una imagen 
        String [] args_2 =  new String[7];
        args_2[0] = "-startPage";
        args_2[1] = "1";
        args_2[2] = "-endPage";
        args_2[3] = "1";
        args_2[4] = "-outputPrefix";
        args_2[5] = "my_image_2";
        args_2[6] = pathOfPdf;

        try {
           PDFToImage.main(args_2); 
              
        } catch (Exception e) 
        {  
        }
    }
    
    
}
