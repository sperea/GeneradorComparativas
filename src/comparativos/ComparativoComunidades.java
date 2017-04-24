/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparativos;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;

/**
 *
 * @author sergio
 */
public class ComparativoComunidades {
    
    ArrayList<Cuadro> columnas;  

    public ComparativoComunidades() {
        this.columnas = new ArrayList<>();
    }

    public void InsertarOferta(String ficheroConfig,
                               boolean danosEsteticosCom,
                               boolean danosEsteticosPriv,
                               boolean danosAguaCom,
                               boolean danosAguaPriv,
                               boolean franquicia,
                               String  importeFranquicia) throws FileNotFoundException, IOException {
        final GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Cuadro.class, new CuadroDeserializer());
        gsonBuilder.registerTypeAdapter(Fila.class, new FilaDeserializer());
        final Gson gson = gsonBuilder.create();

        // Read the JSON data
        try (Reader reader = new InputStreamReader(ComparativoComunidades.class.getResourceAsStream("/config/"), "UTF-8")) {

          // Parse JSON to Java
          Cuadro cuadro = gson.fromJson(reader, Cuadro.class);
          
          cuadro = SetDanosEsteticosCom(danosEsteticosCom, cuadro);
          cuadro = SetDanosEsteticosPriv(danosEsteticosPriv, cuadro);
          cuadro = SetDanosAguaCom(danosAguaCom, cuadro);
          cuadro = SetDanosAguaPriv(danosAguaPriv, cuadro);
          cuadro = SetFranquicia(franquicia, importeFranquicia, cuadro);
          
          boolean add = this.columnas.add(cuadro);
          //System.out.println(cuadro);
        }
    }

    public String[][] toArray(){
        
        //return 
        // ¿cuantas filas?
        int numFilas = 0;
        int numColumnas = 0;
        if (columnas.size() > 0)  {
            numColumnas = columnas.size() + 1;
            numFilas = columnas.get(0).getFilas().length;
        }
        
        String[][] toArrayAux = new String [numColumnas][numFilas];
        
        // primera columna
        
        for (int i=0 ;i<numFilas; i++)
        {
            toArrayAux[i][0] = columnas.get(0).getFilas()[i].getNombre();
        }
        
        //resto de columnas
        for (int i=0 ;i<numFilas; i++)
        {   
            for (int j=0 ;j<numColumnas; j++)
            {
                toArrayAux[i][j+1] = columnas.get(j).getFilas()[i].getNombre();
            }
        }
        return toArrayAux;
        
    }

    private Cuadro SetDanosEsteticosCom(boolean danosEsteticosCom, Cuadro cuadro) {

       Cuadro cuadroAux = cuadro;
       
        if (danosEsteticosCom)
        {
            cuadroAux.setClaveValor("Daños estéticos", "S");
        }
        else
        {
            cuadroAux.setClaveValor("Daños estéticos", "N");
        }
       
       return cuadroAux;
    }

    private Cuadro SetDanosEsteticosPriv(boolean danosEsteticosPriv, Cuadro cuadro) {
       Cuadro cuadroAux = cuadro;
       
        if (danosEsteticosPriv)
        {
            cuadroAux.setClaveValor("Daños estéticos", "S");
        }
        else
        {
            cuadroAux.setClaveValor("Daños estéticos", "N");
        }
       
       return cuadroAux;
    }

    private Cuadro SetDanosAguaCom(boolean danosAguaCom, Cuadro cuadro) {
       Cuadro cuadroAux = cuadro;
       
        if (danosAguaCom)
        {
            cuadroAux.setClaveValor("Daños propios por aguas canalizaciones comunitarias", "S");
            cuadroAux.setClaveValor("Gastos de localización y reparación de averías", "S");
            cuadroAux.setClaveValor("Atascos y gastos desatranco", "S");
            cuadroAux.setClaveValor("Responsabilidad Civil por aguas comunes", "S");
        }
        else
        {
            cuadroAux.setClaveValor("Daños propios por aguas canalizaciones comunitarias", "N");
            cuadroAux.setClaveValor("Gastos de localización y reparación de averías", "N");
            cuadroAux.setClaveValor("Atascos y gastos desatranco", "N");
            cuadroAux.setClaveValor("Responsabilidad Civil por aguas comunes", "N");
        }
       
       return cuadroAux;
    }

    private Cuadro SetDanosAguaPriv(boolean danosAguaPriv, Cuadro cuadro) {
       Cuadro cuadroAux = cuadro;
       
        if (danosAguaPriv)
        {
            cuadroAux.setClaveValor("Daños propios por aguas canalizaciones comunitarias", "S");
            cuadroAux.setClaveValor("Daños propios por agua canalizaciones privadas", "S");
            cuadroAux.setClaveValor("Gastos de localización y reparación de averías", "S");
            cuadroAux.setClaveValor("Atascos y gastos desatranco", "S");
            cuadroAux.setClaveValor("Responsabilidad Civil por aguas comunes", "S");
        }
        else
        {
            cuadroAux.setClaveValor("Daños propios por aguas canalizaciones comunitarias", "N");
            cuadroAux.setClaveValor("Daños propios por agua canalizaciones privadas", "N");
            cuadroAux.setClaveValor("Gastos de localización y reparación de averías", "N");
            cuadroAux.setClaveValor("Atascos y gastos desatranco", "N");
            cuadroAux.setClaveValor("Responsabilidad Civil por aguas comunes", "N");
        }
       
       return cuadroAux;
    }

    private Cuadro SetFranquicia(boolean franquicia, String importeFranquicia, Cuadro cuadro) {
       Cuadro cuadroAux = cuadro;
       
        if (franquicia)
        {
            cuadroAux.setClaveValor("Franquicia", importeFranquicia);
        }
        else
        {
            cuadroAux.setClaveValor("Franquicia", "N");
        }
       
       return cuadroAux;
    }
}
