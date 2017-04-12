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

    public void InsertarOferta(String ficheroConfig) throws FileNotFoundException, IOException {
        final GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Cuadro.class, new CuadroDeserializer());
        gsonBuilder.registerTypeAdapter(Fila.class, new FilaDeserializer());
        final Gson gson = gsonBuilder.create();

        // Read the JSON data
        try (Reader reader = new InputStreamReader(ComparativoComunidades.class.getResourceAsStream("/config/"), "UTF-8")) {

          // Parse JSON to Java
          final Cuadro cuadro = gson.fromJson(reader, Cuadro.class);
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


}
