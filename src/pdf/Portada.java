/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdf;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.FontSelector;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
    
    private void CrearJpgCatastro(String pathOfPortada)
    {
        // Se convierte el PDF del catastro en una imagen 
        String [] args_2 =  new String[7];
        args_2[0] = "-startPage";
        args_2[1] = "1";
        args_2[2] = "-endPage";
        args_2[3] = "1";
        args_2[4] = "-outputPrefix";
        args_2[5] = pathOfPortada;
        args_2[6] = pathOfPortada + ".pdf";

        try {
           PDFToImage.main(args_2); 
              
        } catch (Exception e) 
        {  
        }
    }
    
    public void CrearPortada(String pathPortada) throws DocumentException, FileNotFoundException, BadElementException, IOException
    {
                // Aquí introduciremos el código para crear el PDF.

        // Se crea el documento
        Document documento = new Document(PageSize.A4,60,60,60,60);
        PdfWriter writer = PdfWriter.getInstance(documento, new FileOutputStream(pathPortada));
        writer.setInitialLeading(5);
        // Se abre el documento.
        documento.open();
        //documento.newPage();
        FontSelector fontselector = new FontSelector();
        fontselector.addFont(new Font(Font.FontFamily.HELVETICA, 6));

        CrearJpgCatastro(pathOfPdf);
        
        Image imagen = Image.getInstance("img/logo.jpg");
        imagen.scalePercent(25f);
        imagen.setAlignment(Image.MIDDLE); 
        documento.add(imagen);
        
        Paragraph titulo = new Paragraph("SEGURO DE COMUNIDADES", new Font(Font.FontFamily.HELVETICA, 14));
        titulo.setAlignment(Paragraph.ALIGN_CENTER);
        documento.add(titulo);
      
        documento.add(new Paragraph(" ", new Font(Font.FontFamily.HELVETICA, 14)));
        
        LineSeparator objectName = new LineSeparator();              
        documento.add(objectName);
        
        documento.add(new Paragraph(" ", new Font(Font.FontFamily.HELVETICA, 14)));
        
        documento.add(new Paragraph("RIESGO A ASEGURAR: COM. PROP. CL Sagasta 32", new Font(Font.FontFamily.HELVETICA, 12)));
        
        documento.add(new Paragraph(" ", new Font(Font.FontFamily.HELVETICA, 14)));
        

        
        PdfPTable table = new PdfPTable(2);
        Font f = new Font(Font.FontFamily.HELVETICA, 8);

        PdfPCell c1 = new PdfPCell(new Phrase("Metros de viviendas:"));
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Número de viviendas"));
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.addCell(c1);
        
        c1 = new PdfPCell(new Phrase("Metros de locales:"));
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Número de locales"));
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.addCell(c1);
        
        c1 = new PdfPCell(new Phrase("Metros de oficinas:"));
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Número de oficinas"));
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.addCell(c1);
        
        c1 = new PdfPCell(new Phrase("Metros de garajes:"));
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Número de garajes"));
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.addCell(c1);
        
        PdfPTable table2 = new PdfPTable(2);
        
        c1 = new PdfPCell(new Phrase("Año de construcción:"));
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        table2.addCell(c1);
        
        c1 = new PdfPCell(new Phrase("Año de rehabilitación de conducciones:"));
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        table2.addCell(c1);
        
        PdfPTable table3 = new PdfPTable(2);
        
        c1 = new PdfPCell(new Phrase("Alturas:"));
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        table3.addCell(c1);

        c1 = new PdfPCell(new Phrase(" "));
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.addCell(c1);
        
        documento.add(table);
        documento.add(new Paragraph(" ", new Font(Font.FontFamily.HELVETICA, 14)));
        documento.add(table2);
        documento.add(new Paragraph(" ", new Font(Font.FontFamily.HELVETICA, 14)));
        documento.add(table3);
        documento.add(new Paragraph(" ", new Font(Font.FontFamily.HELVETICA, 14)));
        
        LineSeparator objectName2 = new LineSeparator();              
        documento.add(objectName2);
        
        documento.add(new Paragraph(" ", new Font(Font.FontFamily.HELVETICA, 14)));
        
        Image image1 = Image.getInstance(pathOfPdf+"1.jpg");
        image1.scalePercent(50f);
        image1.setAlignment(Image.MIDDLE); 
        documento.add(image1);
        
        documento.close();
    }    
    
    
}
