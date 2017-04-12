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
class Fila {

    public void setNum(Integer num) {
        this.num = num;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public void setSeparador(String separador) {
        this.separador = separador;
    }

    public Integer getNum() {
        return num;
    }

    public String getNombre() {
        return nombre;
    }

    public String getValor() {
        return valor;
    }

    public String getSeparador() {
        return separador;
    }
    
    private Integer num;
    private String nombre;
    private String valor;
    private String separador;
    
}
