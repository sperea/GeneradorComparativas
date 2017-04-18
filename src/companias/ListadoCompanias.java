/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package companias;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**
 *
 * @author sergio
 */
public class ListadoCompanias {
    
    private ArrayList<Compania> contenedor; 
    
    public ListadoCompanias() throws ParserConfigurationException, SAXException, IOException 
    {
        // Leemos el listado de companias del fichero xml
        this.contenedor = new ArrayList<Compania>();
        
        File fXmlFile = new File("src/config/companias.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);

        doc.getDocumentElement().normalize();
        //Se obtiene la raiz '
        NodeList nList = doc.getElementsByTagName("compania");
        
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                Compania c = new Compania ();
                c.setNombre(eElement.getElementsByTagName("nombre").item(0).getTextContent());
                c.setRutaConfig(eElement.getElementsByTagName("config").item(0).getTextContent());
                c.setRutaIcono(eElement.getElementsByTagName("icono").item(0).getTextContent());
                contenedor.add(c);
            }
        }
    }
    
    private String GetFicheroConfig (String nombreCompania)
    {
        String salida = "";
        for (Compania companiaActual: this.contenedor)
        {
            if (nombreCompania.equals(companiaActual.getNombre()))
            {
                salida = companiaActual.getRutaConfig();
            }
        }
        return salida;
    }
    
    public ArrayList<String> getListadoOrdenadorCompanias()
    {
        // Se genera una lista de nombres de Cia y se ordena por orden alfabético
        ArrayList<String> c = new ArrayList<String>();
        for (int temp = 0; temp < contenedor.size(); temp++) {
            c.add(this.contenedor.get(temp).getNombre());
        }
        Collections.sort(c);
        return c;
    }
    
    /*
    public ArrayList<String> getListadoOrdenadoCampos() throws ParserConfigurationException, SAXException, IOException
    {
        
        File fXmlFile = new File("src/config/filas.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);

        doc.getDocumentElement().normalize();
        //Se obtiene la raiz '
        NodeList nList = doc.getElementsByTagName("fila");
        
        ComparativoComunidades comparativo = new ComparativoComunidades();
        
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            
            Element el = (org.w3c.dom.Element) nList.item(temp);
            String filaId = el.getAttribute("id");
            
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                comparativo.addTexto(filaId, eElement.getElementsByTagName("texto").item(0).getTextContent());
            }
        }
        
        
        // Se genera una lista de nombres de Cia y se ordena por orden alfabético
        ArrayList<String> c = new ArrayList<String>();
        for (int temp = 0; temp < contenedor.size(); temp++) {
            c.add(this.contenedor.get(temp).getNombre());
        }
        Collections.sort(c);
        return c;
    }*/
    
}
