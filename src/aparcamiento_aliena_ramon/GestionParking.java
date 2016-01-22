/*
Practica entregable 2º evaluación.
 */

package aparcamiento_aliena_ramon;

/**
 *
 * Ramon Aliena Gomez
 * 1º DAW
 * Nº expte.: 8122
 */
public class GestionParking {

    public static void main(String[] args) {
        
        Parking parking = new Parking("Cementerio de coches");

        Vehiculo c1 = new Coche("largo", "4562-FGF", "48562144S");
        Vehiculo c2 = new Coche("corto", "4478-FRF", "55412552R");
        Vehiculo m1 = new Moto("7412-EEE", "45522141B");
        
        Plaza p1 = new Plaza(1, "Primero");
        Plaza p2 = new Plaza(2, "Primero");
        Plaza p3 = new Plaza(3, "Primero");
        Plaza p4 = new Plaza(4, "Primero");
        Plaza p5 = new Plaza(5, "Segundo");
        Plaza p6 = new Plaza(6, "Segundo");
        Plaza p7 = new Plaza(7, "Segundo");
        Plaza p8 = new Plaza(8, "Segundo");
        
        parking.getListadoPlazas().put(101, p1);
        parking.getListadoPlazas().put(102, p2);
        parking.getListadoPlazas().put(103, p3);
        parking.getListadoPlazas().put(104, p4);
        parking.getListadoPlazas().put(205, p5);
        parking.getListadoPlazas().put(206, p6);
        parking.getListadoPlazas().put(207, p7);
        parking.getListadoPlazas().put(208, p8);
        
        System.out.println(parking.alquilar(c1));
        //System.out.println(parking.alquilar(c2));
        //System.out.println(parking.alquilar(m1));
        
        
        
        //System.out.println(p1.precio());
        //System.out.println(p2.precio());
        //System.out.println(p3.precio());
        //System.out.println(p4.precio());
        
        //System.out.println(p1.toString());
        //System.out.println(p2.toString());
        //System.out.println(p3.toString());
        //System.out.println(p4.toString());
    }
    
}
