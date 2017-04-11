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

public class FilaDeserializer implements JsonDeserializer {

    /**
     *
     * @param json
     * @param typeOfT
     * @param context
     * @return
     * @throws JsonParseException
     */
    @Override
  public Fila deserialize(final JsonElement json, final Type typeOfT, final JsonDeserializationContext context)
      throws JsonParseException {
    final JsonObject jsonObject = json.getAsJsonObject();

    final Fila fila = new Fila();
    fila.setNum(jsonObject.get("num").getAsInt());
    fila.setNombre(jsonObject.get("nombre").getAsString());
    fila.setValor(jsonObject.get("valor").getAsString());
    fila.setSeparador(jsonObject.get("separador").getAsString());
    return fila;
  }
}