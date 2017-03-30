/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdf;
import java.io.*; 
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.FontSelector;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfGState;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
/**
 *
 * @author sergio
 */
public class TablaComparativa {
    
    
    public static PdfPCell getNormalCell(String string, String language, float size, String tipoCelda) throws DocumentException, IOException {
        
        String imagenSi = "img/si.png";
        
        if(string != null && "".equals(string)){
            return new PdfPCell();
        }
        
        if ("S".equals(string)) 
        {
            /*Image img = Image.getInstance(imagenSi);
            img.setAlignment(Image.ALIGN_CENTER);
            PdfPCell cell = new PdfPCell();
            //Chunk chunk = new Chunk(img, 0, 0);
            Phrase phrase = new Phrase("\u2208 hh", f);
            //phrase.add(new Phrase(new Chunk(img, 0, 0)));
            cell.addElement(phrase);
            */
            Font fSi  = new Font(Font.FontFamily.ZAPFDINGBATS, 6);
            fSi.setColor(BaseColor.GREEN);
            fSi.setSize(size);
            PdfPCell cell = new PdfPCell(new Phrase("4", fSi));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            return cell;
        }
        if ("N".equals(string)) 
        {
            /*Image img = Image.getInstance(imagenSi);
            img.setAlignment(Image.ALIGN_CENTER);
            PdfPCell cell = new PdfPCell();
            //Chunk chunk = new Chunk(img, 0, 0);
            Phrase phrase = new Phrase("\u2208 hh", f);
            //phrase.add(new Phrase(new Chunk(img, 0, 0)));
            cell.addElement(phrase);
            */
            Font fSi  = new Font(Font.FontFamily.ZAPFDINGBATS, 6);
            fSi.setColor(BaseColor.RED);
            fSi.setSize(size);
            PdfPCell cell = new PdfPCell(new Phrase("5", fSi));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            return cell;
        }       
        Font f  = new Font(Font.FontFamily.HELVETICA, 8);
        f.setColor(BaseColor.BLACK);
        //f.setSize(size);
        PdfPCell cell = new PdfPCell(new Phrase(string, f));
        if ("1".equals(tipoCelda))
        {
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        }
        else
        {
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        }
        
        if (" ".equals(string))
        {
            cell.setFixedHeight(2f);
        }
        return cell;
    }
    
    
    
    public void MarcaDeAgua(String src, String dest, Image img) throws IOException, DocumentException 
    {
        PdfReader reader = new PdfReader(src);
        int n = reader.getNumberOfPages();
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
        // text watermark
        Font f = new Font(FontFamily.HELVETICA, 30);
        Phrase p = new Phrase("JLA Asociados Correduría de Seguros S.A.", f);
        // image watermark
        float w = img.getScaledWidth();
        float h = img.getScaledHeight();
        // transparency
        PdfGState gs1 = new PdfGState();
        gs1.setFillOpacity(0.1f);
        // properties
        PdfContentByte over;
        Rectangle pagesize;
        float x, y;
        // loop over every page
        for (int i = 1; i <= n; i++) {
            pagesize = reader.getPageSizeWithRotation(i);
            x = (pagesize.getLeft() + pagesize.getRight()) / 2;
            y = (pagesize.getTop() + pagesize.getBottom()) / 2;
            over = stamper.getOverContent(i);
            over.saveState();
            over.setGState(gs1);
            if (i % 2 == 1)
                ColumnText.showTextAligned(over, Element.ALIGN_CENTER, p, x, y, 0);
            else
                over.addImage(img, w, 0, 0, h, x - (w / 2), y - (h / 2));
            over.restoreState();
        }
        stamper.close();
        reader.close();
    }
    
    @SuppressWarnings("empty-statement")
    private PdfPTable DibujarTabla() throws BadElementException, DocumentException, IOException 
    {
        int numColumnas = 7;
        PdfPTable table = new PdfPTable(numColumnas);

        // t.setBorderColor(BaseColor.GRAY);
        // t.setPadding(4);
        // t.setSpacing(4);
        // t.setBorderWidth(1);
        Font f = new Font(Font.FontFamily.HELVETICA, 8);

        PdfPCell c1 = new PdfPCell(new Phrase(" "));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("CATALANA OCCIDENTE", f));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("MUTUA DE PROPIETARIOS", f));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        c1 = new PdfPCell(new Phrase("REALE", f));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("HELVETIA", f));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("GENERALI", f));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        
        c1 = new PdfPCell(new Phrase("ALLIANZ", f));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
 
        table.setHeaderRows(1);
        
        table.addCell(getNormalCell("Incendio, Explosión y caída del rayo", "greek", 10, "1"));
        table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("N", "greek", 10, ""));
        table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("N", "greek", 10, ""));
        table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("Impacto de vehículos", "greek", 10, "1"));
        table.addCell(getNormalCell("S", "greek", 10, ""));
             table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("N", "greek", 10, ""));
        table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("N", "greek", 10, ""));
        table.addCell(getNormalCell("Bomberos", "greek", 10, "1"));
        table.addCell(getNormalCell("S", "greek", 10, ""));
                table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("N", "greek", 10, ""));
        table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("N", "greek", 10, ""));
                table.addCell(getNormalCell(" ", "greek", 10, "1"));
                table.addCell(getNormalCell(" ", "greek", 10, ""));
        table.addCell(getNormalCell(" ", "greek", 10, ""));
        table.addCell(getNormalCell(" ", "greek", 10, ""));
        table.addCell(getNormalCell(" ", "greek", 10, ""));
        table.addCell(getNormalCell(" ", "greek", 10, ""));
        table.addCell(getNormalCell(" ", "greek", 10, ""));
        table.addCell(getNormalCell("Demolición y desescombro", "greek", 10, "1"));
                table.addCell(getNormalCell("S", "greek", 10, ""));
                table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("N", "greek", 10, ""));
        table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("N", "greek", 10, ""));
        table.addCell(getNormalCell("Inhabitabilidad", "greek", 10, "1"));
                table.addCell(getNormalCell("S", "greek", 10, ""));
                table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("N", "greek", 10, ""));
        table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("N", "greek", 10, ""));
        table.addCell(getNormalCell("perdida de alquileres", "greek", 10, "1"));
                table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("N", "greek", 10, ""));
        table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("N", "greek", 10, ""));
                        table.addCell(getNormalCell(" ", "greek", 10, "1"));
                table.addCell(getNormalCell(" ", "greek", 10, ""));
        table.addCell(getNormalCell(" ", "greek", 10, ""));
        table.addCell(getNormalCell(" ", "greek", 10, ""));
        table.addCell(getNormalCell(" ", "greek", 10, ""));
        table.addCell(getNormalCell(" ", "greek", 10, ""));
        table.addCell(getNormalCell(" ", "greek", 10, ""));
        table.addCell(getNormalCell("Robo y expoliación", "greek", 10, "1"));
                table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("N", "greek", 10, ""));
        table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("N", "greek", 10, ""));
        table.addCell(getNormalCell("Desperfectos por robo o expoliación en continente", "greek", 10, "1"));
                table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("N", "greek", 10, ""));
        table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("N", "greek", 10, ""));
        table.addCell(getNormalCell("Hurto", "greek", 10, "1"));
                table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("N", "greek", 10, ""));
        table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("N", "greek", 10, ""));
                        table.addCell(getNormalCell(" ", "greek", 10, "1"));
                table.addCell(getNormalCell(" ", "greek", 10, ""));
        table.addCell(getNormalCell(" ", "greek", 10, ""));
        table.addCell(getNormalCell(" ", "greek", 10, ""));
        table.addCell(getNormalCell(" ", "greek", 10, ""));
        table.addCell(getNormalCell(" ", "greek", 10, ""));
        table.addCell(getNormalCell(" ", "greek", 10, ""));
        table.addCell(getNormalCell("Rotura de lunas espejos y cristales comunitarios", "greek", 10, "1"));
                table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("N", "greek", 10, ""));
        table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("N", "greek", 10, ""));
        table.addCell(getNormalCell("Rotura de lunas espejos y cristales privados exteriores", "greek", 10, "1"));
                table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("N", "greek", 10, ""));
        table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("N", "greek", 10, ""));
                        table.addCell(getNormalCell(" ", "greek", 10, "1"));
                table.addCell(getNormalCell(" ", "greek", 10, ""));
        table.addCell(getNormalCell(" ", "greek", 10, ""));
        table.addCell(getNormalCell(" ", "greek", 10, ""));
        table.addCell(getNormalCell(" ", "greek", 10, ""));
        table.addCell(getNormalCell(" ", "greek", 10, ""));
        table.addCell(getNormalCell(" ", "greek", 10, ""));
        table.addCell(getNormalCell("Daños propios por aguas canalizaciones comunitarias", "greek", 10, "1"));
                table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("N", "greek", 10, ""));
        table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("N", "greek", 10, ""));
        table.addCell(getNormalCell("Gastos de localización y reparación de averías", "greek", 10, "1"));
                table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("N", "greek", 10, ""));
        table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("N", "greek", 10, ""));
        table.addCell(getNormalCell("Atascos y gastos desatranco", "greek", 10, "1"));        
        table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("N", "greek", 10, ""));
        table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("N", "greek", 10, ""));
                        table.addCell(getNormalCell(" ", "greek", 10, "1"));
                table.addCell(getNormalCell(" ", "greek", 10, ""));
        table.addCell(getNormalCell(" ", "greek", 10, ""));
        table.addCell(getNormalCell(" ", "greek", 10, ""));
        table.addCell(getNormalCell(" ", "greek", 10, ""));
        table.addCell(getNormalCell(" ", "greek", 10, ""));
        table.addCell(getNormalCell(" ", "greek", 10, ""));
        table.addCell(getNormalCell("Daños propios por agua canalizaciones privadas", "greek", 10, "1"));
                table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("N", "greek", 10, ""));
        table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("N", "greek", 10, ""));
                        table.addCell(getNormalCell(" ", "greek", 10, "1"));
                table.addCell(getNormalCell(" ", "greek", 10, ""));
        table.addCell(getNormalCell(" ", "greek", 10, ""));
        table.addCell(getNormalCell(" ", "greek", 10, ""));
        table.addCell(getNormalCell(" ", "greek", 10, ""));
        table.addCell(getNormalCell(" ", "greek", 10, ""));
        table.addCell(getNormalCell(" ", "greek", 10, ""));
        table.addCell(getNormalCell("Actos de vandalismo o malintencionados", "greek", 10, "1"));
                table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("N", "greek", 10, ""));
        table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("N", "greek", 10, ""));
        table.addCell(getNormalCell("Daños por lluvia, viento, pedrisco o nieve", "greek", 10, "1"));
                table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("N", "greek", 10, ""));
        table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("N", "greek", 10, ""));
        table.addCell(getNormalCell("Inundación", "greek", 10, "1"));
                table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("N", "greek", 10, ""));
        table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("N", "greek", 10, ""));
        table.addCell(getNormalCell("Desbarre y extracción de lodos", "greek", 10, "1"));
                table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("N", "greek", 10, ""));
        table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("N", "greek", 10, ""));
        table.addCell(getNormalCell("Humo", "greek", 10, "1"));
                table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("N", "greek", 10, ""));
        table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("N", "greek", 10, ""));
        table.addCell(getNormalCell("Ondas sónicas", "greek", 10, "1"));
                table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("N", "greek", 10, ""));
        table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("N", "greek", 10, ""));
        table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("Daños eléctricos", "greek", 10, "1"));
                table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("N", "greek", 10, ""));
        table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("N", "greek", 10, ""));
                        table.addCell(getNormalCell(" ", "greek", 10, "1"));
                table.addCell(getNormalCell(" ", "greek", 10, ""));
        table.addCell(getNormalCell(" ", "greek", 10, ""));
        table.addCell(getNormalCell(" ", "greek", 10, ""));
        table.addCell(getNormalCell(" ", "greek", 10, ""));
        table.addCell(getNormalCell(" ", "greek", 10, ""));
        table.addCell(getNormalCell(" ", "greek", 10, ""));
        table.addCell(getNormalCell("Responsabilidad Civil General", "greek", 10, "1"));
                table.addCell(getNormalCell("300.000€", "greek", 10, ""));
        table.addCell(getNormalCell("300.000€", "greek", 10, ""));
        table.addCell(getNormalCell("300.000€", "greek", 10, ""));
        table.addCell(getNormalCell("300.000€", "greek", 10, ""));
        table.addCell(getNormalCell("300.000€", "greek", 10, ""));
        table.addCell(getNormalCell("300.000€", "greek", 10, ""));
        table.addCell(getNormalCell("Responsabilidad Civil por aguas comunes", "greek", 10, "1"));
                table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("N", "greek", 10, ""));
        table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("N", "greek", 10, ""));
        table.addCell(getNormalCell("Responsabilidad Civil patronal", "greek", 10, "1"));
                table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("N", "greek", 10, ""));
        table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("N", "greek", 10, ""));
        table.addCell(getNormalCell("Defensa y fianzas", "greek", 10, "1"));
                table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("N", "greek", 10, ""));
        table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("N", "greek", 10, ""));
                        table.addCell(getNormalCell(" ", "greek", 10, "1"));
                table.addCell(getNormalCell(" ", "greek", 10, ""));
        table.addCell(getNormalCell(" ", "greek", 10, ""));
        table.addCell(getNormalCell(" ", "greek", 10, ""));
        table.addCell(getNormalCell(" ", "greek", 10, ""));
        table.addCell(getNormalCell(" ", "greek", 10, ""));
        table.addCell(getNormalCell(" ", "greek", 10, ""));
        table.addCell(getNormalCell("Daños estéticos", "greek", 10, "1"));
                table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("N", "greek", 10, ""));
        table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("N", "greek", 10, ""));
        table.addCell(getNormalCell("Defensa Juridica ", "greek", 10, "1"));
                table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("N", "greek", 10, ""));
        table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("N", "greek", 10, ""));
        table.addCell(getNormalCell("Reclamación Cuotas impagados", "greek", 10, "1"));
                table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("N", "greek", 10, ""));
        table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("N", "greek", 10, ""));
        table.addCell(getNormalCell("Asistencia 24 horas", "greek", 10, "1"));
                table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("N", "greek", 10, ""));
        table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("S", "greek", 10, ""));
        table.addCell(getNormalCell("N", "greek", 10, ""));
        table.addCell(getNormalCell("Franquicia ", "greek", 10, "1"));
                table.addCell(getNormalCell("200€", "greek", 10, ""));
        table.addCell(getNormalCell("N", "greek", 10, ""));
        table.addCell(getNormalCell("240€", "greek", 10, ""));
        table.addCell(getNormalCell("150€", "greek", 10, ""));
        table.addCell(getNormalCell("300€", "greek", 10, ""));
        table.addCell(getNormalCell("10% siniestro, mínimo 250€", "greek", 10, ""));
                        table.addCell(getNormalCell(" ", "greek", 10, "1"));
                table.addCell(getNormalCell(" ", "greek", 10, ""));
        table.addCell(getNormalCell(" ", "greek", 10, ""));
        table.addCell(getNormalCell(" ", "greek", 10, ""));
        table.addCell(getNormalCell(" ", "greek", 10, ""));
        table.addCell(getNormalCell(" ", "greek", 10, ""));
        table.addCell(getNormalCell(" ", "greek", 10, ""));
        table.addCell(getNormalCell("CAPITAL BASE ASEGURADO", "greek", 10, "1"));
                table.addCell(getNormalCell("12.000.000,00", "greek", 10, ""));
        table.addCell(getNormalCell("21.000.000,00", "greek", 10, ""));
        table.addCell(getNormalCell("11.000.000,00", "greek", 10, ""));
        table.addCell(getNormalCell("22.000.000,00", "greek", 10, ""));
        table.addCell(getNormalCell("22.000.000,00", "greek", 10, ""));
        table.addCell(getNormalCell("12.000.000,00", "greek", 10, ""));
        table.addCell(getNormalCell("PRIMA ANUAL", "greek", 10, "1"));
                table.addCell(getNormalCell("2.000,00", "greek", 10, ""));
        table.addCell(getNormalCell("1.000,00", "greek", 10, ""));
        table.addCell(getNormalCell("1.000,00", "greek", 10, ""));
        table.addCell(getNormalCell("2.000,00", "greek", 10, ""));
        table.addCell(getNormalCell("2.000,00", "greek", 10, ""));
        table.addCell(getNormalCell("2.000,00", "greek", 10, ""));


        float[] columnWidths = new float[numColumnas];
        columnWidths[0] = 20f;
        int i;
        for (i=1; i<=numColumnas-1; i++)
        {
            columnWidths[i] = 5f;
        }
        table.setWidths(columnWidths);

        return table;

        }


    public void crearPDF() throws FileNotFoundException, DocumentException, BadElementException, IOException {
        // Aquí introduciremos el código para crear el PDF.

        // Se crea el documento
        Document documento = new Document(PageSize.A4.rotate(),0,0,60,0);
        PdfWriter writer = PdfWriter.getInstance(documento, new FileOutputStream("fichero.pdf"));
        writer.setInitialLeading(5);
        // Se abre el documento.
        documento.open();
        //documento.newPage();
        FontSelector fontselector = new FontSelector();
        fontselector.addFont(new Font(Font.FontFamily.HELVETICA, 6));
        //documento.setPageSize(PageSize.A4.rotate());
        documento.setMargins(0, 0, 0, 0);
        documento.add(DibujarTabla());
    	Rectangle rect = writer.getPageSize();
        ColumnText.showTextAligned(writer.getDirectContent(),Element.ALIGN_CENTER, new Phrase("JLA Asociados, Correduría de Seguros | C/ Sagasta 32 5º Derecha 28004 Madrid | 91593 83 33", new Font(Font.FontFamily.TIMES_ROMAN, 7)), rect.getLeft()+40, rect.getBottom()+180, 90);
        ColumnText.showTextAligned(writer.getDirectContent(),Element.ALIGN_LEFT, new Phrase("COMUNIDAD DE PROPIETARIOS CL SAGASTA 32", new Font(Font.FontFamily.HELVETICA, 18)), rect.getLeft()+78, rect.getTop()-50, 0);
        documento.close();
    }
}
