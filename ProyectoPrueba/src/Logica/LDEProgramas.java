package Logica;

import Domain.Programa;

public class LDEProgramas {

    public LDEProgramas before;
    public LDEProgramas next;
    Programa start;
    String genero;
    int contadorProgramas;

    public LDEProgramas(String genero) {
        this.before = null;
        this.next=null;
        this.contadorProgramas=0;
        this.genero=genero;
        this.start=null;
    }//constructor

    public int getSize() {
        return this.contadorProgramas;
    }//getSize

    public boolean isEmpty() {
        return this.start==null;
    }//isEmpty

    public void insert(Programa programa) {
        Programa aux=this.start;
        Programa programaIngresado=programa;

        if (aux==null) { // acá daba un error si estaba !=, no sé por qué, la verdad
            this.start=programa;
            this.contadorProgramas++;
        } else {
            if (!exists(programa)) { //Permite que no haya programas repetidos
                while (aux.next!=null) {
                    aux=aux.next;
                }//endWhile
                aux.next=programaIngresado;
                programaIngresado.before=aux;
                this.contadorProgramas++;
            }//endIf
        }//endElse
    }//insert

    public boolean exists(Programa programa) {
        if (isEmpty()) {
            throw new LCDEException("La lista está vacía");
        }else {
            Programa aux = this.start;
            boolean existe = false;
            while (aux!=null) {
                if (aux.nombre.equals(programa.nombre)) {
                    existe=true;
                }//endIF
                aux = aux.next;
            }//endWhile
            return existe;
        }//endElse
    }//exists

    public String toString() {
        if (isEmpty()) {
            return "La lista vacía";
        }else {
            Programa aux = this.start;
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
