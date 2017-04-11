/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparativos;

import java.io.FileReader;
import com.google.gson.JsonParser;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonPrimitive;
import java.io.FileNotFoundException;
import java.util.Map.Entry;

/**
 *
 * @author sergio
 */
public class ComparativoComunidades {

    public ComparativoComunidades() throws FileNotFoundException {
        JsonParser parser = new JsonParser();
        FileReader fr = new FileReader("datos.json");
        JsonElement datos = parser.parse(fr);
        //dumpJSONElement(datos);
    }

    public void addTexto(String clave, String textContent) {

    }


}
