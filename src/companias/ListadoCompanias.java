/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package companias;

import java.awt.Event;
import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMException;
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
    
}
