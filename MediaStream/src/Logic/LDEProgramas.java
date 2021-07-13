package Logic;

import Domain.Program;
import javafx.scene.image.Image;

public class LDEProgramas {

    public LDEProgramas before;
    public LDEProgramas next;
    Program start;
    String genero;
    int contadorProgramas;
    public Image img;

    public LDEProgramas(String genero, Image img) {
        this.before = null;
        this.next=null;
        this.contadorProgramas=0;
        this.genero=genero;
        this.start=null;
        this.img=img;
    }//constructor

    public int getSize() {
        return this.contadorProgramas;
    }//getSize

    public boolean isEmpty() {
        return this.start==null;
    }//isEmpty

    public void insert(Program program, int edad) {
        if (edad>=program.restriccion){//Esto es necesario para llevar un control de la edad y el programa que se visualizará
            Program aux=this.start;
            Program programIngresado = program;

            if (aux==null) { // acá daba un error si estaba !=, no sé por qué, la verdad
                this.start= program;
                this.contadorProgramas++;
            } else {
                if (!exists(program)) { //Permite que no haya programas repetidos
                    while (aux.next!=null) {
                        aux=aux.next;
                    }//endWhile
                    aux.next= programIngresado;
                    programIngresado.before=aux;
                    this.contadorProgramas++;
                }//endIf
            }//endElse
        }//if
    }//insert

    public Program buscarPrograma(String nombre, ColaEnlazada colaRecomendacion){
        //Recibimos la cola para saber saber si el programa no se repite
        if (isEmpty()) {
            throw new LCDEException("La lista está vacía");
        }else {
            Program aux= this.start;
            while(aux!=null){
                if (!aux.nombre.equals(nombre) && !aux.isVisto() && !colaRecomendacion.exists(aux.nombre)){
                    return aux;
                }//if
                aux=aux.next;
            }//while
        }//else
        return null;
    }//buscarPrograma

    public boolean exists(Program program) {
        if (isEmpty()) {
            throw new LCDEException("La lista está vacía");
        }else {
            Program aux = this.start;
            boolean existe = false;
            while (aux!=null) {
                if (aux.nombre.equals(program.nombre)) {
                    existe=true;
                }//endIF
                aux = aux.next;
            }//endWhile
            return existe;
        }//endElse
    }//exists

    public LDEProgramas getBefore() {
        return this.before;
    }

    public LDEProgramas getNext() {
        return this.next;
    }

    public String getGenero() {
        return genero;
    }

    public Program getStart() {
        return start;
    }

    public Image getImg() {
        return img;
    }

    public String toString() {
        if (isEmpty()) {
            return "La lista vacía";
        }else {
            Program aux = this.start;
            String result= "Nombres de los programas\n";
            result+="--------------------------------------\n";

            if (aux.before==null) {
                result+="null<-->";
            }//endIf

            while (aux!=null) {
                result+= aux.nombre+"<-->";
                if (aux.next==null) {
                    result+="null";
                }//endIf
                aux=aux.next;
            }//endWhile
            return result;
        }//endWhile
    }//toString

}//fin class
