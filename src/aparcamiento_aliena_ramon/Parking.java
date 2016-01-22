/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aparcamiento_aliena_ramon;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Parking {
    private String nombre;
    private String direccion;
    private Map<Integer,Plaza> listadoPlazas = new HashMap<>();

    public Parking(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Map<Integer, Plaza> getListadoPlazas() {
        return listadoPlazas;
    }

    public void setListadoPlazas(Map<Integer, Plaza> listadoPlazas) {
        this.listadoPlazas = listadoPlazas;
    }
    
    public String alquilar(Vehiculo v){
        String nPlaza = null;
        Iterator<Integer> it = listadoPlazas.keySet().iterator();
        while(it.hasNext()){
            Integer clave = it.next();
            Plaza plaza = listadoPlazas.get(clave);
            if(plaza.getVehiculo() == null){
                if(v instanceof Coche && plaza.getTipo() == 'C'){
                    listadoPlazas.put(clave, plaza);
                    nPlaza = Integer.toString(clave%100);
                }
                if(v instanceof Moto && plaza.getTipo() == 'M'){
                    listadoPlazas.put(clave, plaza);
                    nPlaza = Integer.toString(clave%100);
                }
            }
        }
        return nPlaza;
    }
    
    public int darBaja(int numPlaza){
        int resultado = 1;
        Iterator<Integer> it = listadoPlazas.keySet().iterator();
        while(it.hasNext()){
            Integer clave = it.next();
            Plaza plaza = listadoPlazas.get(clave);
            if(clave%100 == numPlaza){
                if(plaza.getVehiculo().equals(null)){
                    resultado = 2;
                }else{
                    plaza.setVehiculo(null);
                    resultado = 0;
                }
            }
        }
        return resultado;
    }
    
    public List<Plaza> listarPlazas(String estado, char tipoVehiculo){
        List<Plaza> lista = null;
        List<Plaza> libres = null;
        List<Plaza> ocupadas = null;
        List<Plaza> coches = null;
        List<Plaza> motos = null;
        Iterator<Integer>it = listadoPlazas.keySet().iterator();
        while(it.hasNext()){
            Integer clave = it.next();
            Plaza plaza = listadoPlazas.get(clave);
            if(plaza.getVehiculo() == null){
                libres.add(plaza);
            }else{
                ocupadas.add(plaza);
            }
            if(plaza.getTipo() == 'C'){
                coches.add(plaza);
            }else if(plaza.getTipo() == 'M'){
                motos.add(plaza);
            }
        }
        if(estado.equals("libres") && tipoVehiculo == 'C' && coches.retainAll(libres)){
            lista = coches;
        }
        if(estado.equals("ocupadas") && tipoVehiculo == 'C' && coches.retainAll(ocupadas)){
            lista = coches;
        }
        if(estado.equals("libres") && tipoVehiculo == 'M' && motos.retainAll(libres)){
            lista = motos;
        }
        if(estado.equals("ocupadas") && tipoVehiculo == 'M' && motos.retainAll(ocupadas)){
            lista = motos;
        }
        return lista;
    }
}
