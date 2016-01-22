/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aparcamiento_aliena_ramon;

public class Coche extends Vehiculo{
    private String tipo;

    public Coche(String tipo, String matricula, String nif) {
        super(matricula, nif);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}
