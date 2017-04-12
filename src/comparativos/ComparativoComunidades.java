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

/**
 *
 * @author sergio
 */
public class ComparativoComunidades {

    public ComparativoComunidades() throws FileNotFoundException, IOException {
        final GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Cuadro.class, new CuadroDeserializer());
        gsonBuilder.registerTypeAdapter(Fila.class, new FilaDeserializer());
        final Gson gson = gsonBuilder.create();

        // Read the JSON data
        try (Reader reader = new InputStreamReader(ComparativoComunidades.class.getResourceAsStream("/config/allianz.json"), "UTF-8")) {

          // Parse JSON to Java
          final Cuadro cuadro = gson.fromJson(reader, Cuadro.class);
          System.out.println(cuadro);
        }
    }

    public void addTexto(String clave, String textContent) {

    }


}
