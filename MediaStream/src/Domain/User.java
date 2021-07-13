package Domain;

import Logic.ColaEnlazada;
import Logic.LogicaGrafo.GrafoListaAdyacencia;

public class User {

    private String name;
    private String age;
    private ColaEnlazada colaPrioridad;  //este sería para la implementación, de la cola de prioridad
    private GrafoListaAdyacencia grafoRecomendacion;

    public User(String name, String age) {
        this.age = age;
        this.name = name;
        this.colaPrioridad = new ColaEnlazada();
        this.grafoRecomendacion= new GrafoListaAdyacencia(999999);
    }//constructor

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public GrafoListaAdyacencia getGrafoRecomendacion() {
        return grafoRecomendacion;
    }

    public void setGrafoRecomendacion(GrafoListaAdyacencia grafoRecomendacion) {
        this.grafoRecomendacion = grafoRecomendacion;
    }

    public ColaEnlazada getColaPrioridad() {
        return colaPrioridad;
    }

    public void setColaPrioridad(ColaEnlazada colaPrioridad) {
        this.colaPrioridad = colaPrioridad;
    }

}//fin class
