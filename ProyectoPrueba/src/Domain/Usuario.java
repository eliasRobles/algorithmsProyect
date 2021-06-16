package Domain;

import Logic.ColaEnlazada;

public class Usuario {
    private int edad;
    private String nombre;
    private String genero;
    private int tarjeta;
    private String país;
    private int condigoDeCuenta;
    private String ocupacion;  // esta ocuapcion es para las cuentas compartidas, es decir, para cuando es hijo1, principal, amigo 2, y así.
    private ColaEnlazada colaPrioridad;  //este sería para la implementación, de la cola de prioridad


    public Usuario(int edad, String nombre, String genero, int tarjeta, String país, int condigoDeCuenta, String ocupacion) {
        this.edad = edad;
        this.nombre = nombre;
        this.genero = genero;
        this.tarjeta = tarjeta;
        this.país = país;
        this.condigoDeCuenta = condigoDeCuenta;
        this.ocupacion = ocupacion;
        this.colaPrioridad = new ColaEnlazada();
    }//constructor

    public int getEdad() {
        return edad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getGenero() {
        return genero;
    }

    public int getTarjeta() {
        return tarjeta;
    }

    public String getPaís() {
        return país;
    }

    public int getCondigoDeCuenta() {
        return condigoDeCuenta;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public ColaEnlazada getColaPrioridad() {
        return colaPrioridad;
    }


}//fin class
