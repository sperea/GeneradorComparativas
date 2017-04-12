/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparativos;

import java.lang.reflect.Type;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class CuadroDeserializer implements JsonDeserializer<Cuadro> {

    /**
     *
     * @param json
     * @param typeOfT
     * @param context
     * @return
     * @throws JsonParseException
     */
    @Override
  public Cuadro deserialize(final JsonElement json, final Type typeOfT, final JsonDeserializationContext context)
      throws JsonParseException {
   final JsonObject jsonObject = json.getAsJsonObject();

    final String nombre = jsonObject.get("nombre").getAsString();
    final String logo = jsonObject.get("logo").getAsString();

    // Delegate the deserialization to the context
    Fila[] filas = context.deserialize(jsonObject.get("filas"), Fila[].class);

    final Cuadro cuadro = new Cuadro();
    cuadro.setNombre(nombre);
    cuadro.setLogo(logo);
    cuadro.setFilas(filas);
    return cuadro;
  }
}