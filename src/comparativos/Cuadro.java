/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparativos;

/**
 *
 * @author sergio
 */
class Cuadro {
    
    private String nombre;
    private String logo;
    private Fila[] filas;

    private void AsignarClaveValor(String clave, String valor)
    {
        for (Fila elemento: filas)
            if (elemento.getNombre().equals(clave))
            {
                elemento.setValor(valor);
            }
    }

    public String getNombre() {
        return nombre;
    }

    public String getLogo() {
        return logo;
    }

    public Fila[] getFilas() {
        return filas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public void setFilas(Fila[] filas) {
        this.filas = filas;
    }
    
    public void setRc(String rc) {
        AsignarClaveValor("Responsabilidad Civil General", rc);
    }

    public void setPrima(String prima) {
        AsignarClaveValor("PRIMA ANUAL", prima);
    }
    
    public void SetCapital(String capital) {
        AsignarClaveValor("CAPITAL BASE ASEGURADO", capital);
    }

    public void setFranquicia(String franquicia) {
        AsignarClaveValor("Franquicia", franquicia);
    }    
}
