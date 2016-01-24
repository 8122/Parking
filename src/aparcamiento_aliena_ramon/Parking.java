/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aparcamiento_aliena_ramon;

import java.util.ArrayList;
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
        boolean fin = false;
        String nPlaza = null;
        Iterator<Integer> it = listadoPlazas.keySet().iterator();
        while(it.hasNext() || fin == false){
            Integer clave = it.next();
            Plaza plaza = listadoPlazas.get(clave);
            if(plaza.getVehiculo() == null){
                if(v instanceof Coche && plaza.getTipoVehiculo() == 'C'){
                    listadoPlazas.put(clave, plaza);
                    nPlaza = Integer.toString(plaza.getNumPlaza());
                    fin = true;
                }
                if(v instanceof Moto && plaza.getTipoVehiculo() == 'M'){
                    listadoPlazas.put(clave, plaza);
                    nPlaza = Integer.toString(plaza.getNumPlaza());
                    fin = true;
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
        List<Plaza> lista = new ArrayList<>();
        List<Plaza> libres = new ArrayList<>();
        List<Plaza> ocupadas = new ArrayList<>();
        List<Plaza> coches = new ArrayList<>();
        List<Plaza> motos = new ArrayList<>();
        Iterator<Integer>it = listadoPlazas.keySet().iterator();
        while(it.hasNext()){
            Integer clave = it.next();
            Plaza plaza = listadoPlazas.get(clave);
            if(plaza.getVehiculo() != null){
                boolean b = ocupadas.add(plaza);
            }else{
                boolean b = libres.add(plaza);
            }
            if(plaza.getTipoVehiculo() == 'C'){
                boolean b = coches.add(plaza);
            }
            if(plaza.getTipoVehiculo() == 'M'){
                boolean b = motos.add(plaza);
            }
        }
        if(estado.equals("libres") && tipoVehiculo == 'C'){
            boolean b = coches.retainAll(libres);
            lista = coches;
        }
        if(estado.equals("ocupadas") && tipoVehiculo == 'C'){
            boolean b = coches.retainAll(ocupadas);
            lista = coches;
        }
        if(estado.equals("libres") && tipoVehiculo == 'M'){
            boolean b = motos.retainAll(libres);
            lista = motos;
        }
        if(estado.equals("ocupadas") && tipoVehiculo == 'M'){
            boolean b = motos.retainAll(ocupadas);
            lista = motos;
        }
        return lista;
    }
    
    public int ganancias(){
        int resultado = 0;
        Iterator<Integer> it = listadoPlazas.keySet().iterator();
        while(it.hasNext()){
            Integer clave = it.next();
            Plaza plaza = listadoPlazas.get(clave);
            if(plaza.getVehiculo() != null){
                resultado += plaza.precio();
            }
         }
        return resultado;
    }
}
