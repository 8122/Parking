/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aparcamiento_aliena_ramon;

public class Plaza {
    private Vehiculo vehiculo = null;
    private int numPlaza;
    private String sotano;
    private char tipoVehiculo;

    public Plaza(int numPlaza, String sotano) {
        this.numPlaza = numPlaza;
        this.sotano = sotano;
    }

    public String getSotano() {
        return sotano;
    }

    public void setSotano(String sotano) {
        this.sotano = sotano;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public int getNumPlaza() {
        return numPlaza;
    }

    public void setNumPlaza(int numPlaza) {
        this.numPlaza = numPlaza;
    }

    public char getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(char tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }
    
    public int precio(){
        int precio = 0;
        if(this.getVehiculo() instanceof Moto){
            precio = 25;
        }
        if(this.getVehiculo() instanceof Coche){
            Coche c = (Coche) this.getVehiculo();
            if(c.getTipo().equals("corto")){
                precio = 40;
            }
            if(c.getTipo().equals("largo")){
                precio = 55;
            }
            if(this.getSotano().equals("Segundo")){
                precio = precio - 5;
            }
        }
        return precio;
    }

    @Override
    public String toString() {
        String resultado = null;
        if(this.getVehiculo() == null){
            resultado = "Nº Plaza: "+this.getNumPlaza()+"  Sótano: "+this.getSotano();
        }else{
            resultado = "Nº Plaza: "+this.getNumPlaza()+"  Sótano: "+this.getSotano()+"\n"+
                        "Vehículo: "+this.getVehiculo().toString()+"\n"+
                        "Precio: "+this.precio()+" €";
        }
        return resultado;
    }
}
