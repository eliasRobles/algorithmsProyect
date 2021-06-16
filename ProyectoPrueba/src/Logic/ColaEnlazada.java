package Logic;

import Domain.Programa;

public class ColaEnlazada implements Cola {

    Nodo first;
    int cont;

    public ColaEnlazada() {
        this.first=null;
        this.cont=0;
    }//constructor

    @Override
    public int getSize() {
        return this.cont;
    }//getSize

    @Override
    public boolean isEmpty() {
        return this.cont==0;
    }//isEmpty

    @Override
    public void cancel() {
        this.first=null;
        this.cont=0;
    }//cancel

    @Override
    public void encolar(Programa programa) throws ColaException {
        Nodo aux = this.first;
        Nodo nuevoNodo = new Nodo(programa);

        if (isEmpty()) {
            this.first= nuevoNodo;
            this.cont++;
        }else {
            if (!exists(programa.nombre)) {
                while (aux.next!=null) {
                    aux = aux.next;
                }//endWhile
                aux.next= nuevoNodo;
                this.cont++;
            }//endIf
        }//endElse
    }//encolar

    @Override
    public Programa desencolar() throws ColaException {
        if (isEmpty()) {
            throw new ColaException("Lista vacia, no se puede desencolar");
        }else {
            Object element= this.first.program;
            this.first= this.first.next;
            this.cont--;
            return (Programa) element;
        }//endElse
    }//desencolar

    @Override
    public Programa head() throws ColaException {
        return this.first.program;
    }//head

    @Override
    public boolean exists(Object element) {
        Nodo aux = this.first;
        boolean existe = false;
        if (this.first.program.nombre==element) {
            existe=true;
        }else {
            while (aux.next!=null) {
                if (aux.program.nombre==element) {
                    existe=true;
                }//endIf
                aux = aux.next;
            }//endWhile
            if (aux.program.nombre==element) {
                existe=true;
            }//endIf
        }//endElse
        return existe;
    }//exists

    @Override
    public int getPosition(Object element) {
        if (isEmpty()) {
            throw new ColaException("La lista está vacía, no se puede retornar una posicón");
        }else {
            int pos=0;
            int posReturn=-1;
            if (this.first.program.nombre.equals(element)) {
                return 1;
            }//if
            Nodo aux = this.first;
            while (aux.next!=null) {
                pos++;
                if (aux.program.nombre.equals(element)) {
                    posReturn=pos;
                }//endIf
                aux= aux.next;
            }//endWhile
            if (aux.program.nombre.equals(element)) {
                posReturn=pos+1; //esto es para que no se estanque en la penultima
            }//endIf

            return posReturn;
        }//endElse
    }//getPosition

    public String toString() {
        Nodo aux = this.first;
        String result ="Valores de Cola:\n";

        if (isEmpty()) {
            throw new ColaException("Cola vacía");
        }else {
            while (aux!=null) {
                result+=aux.program.nombre+"<-->";
                aux = aux.next;
            }//while
            result+="null";

        }//endElse
        return result;
    }//toString

}//fin class
