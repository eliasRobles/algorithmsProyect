package Logic;

import Domain.Programa;

public class Nodo {

    public Nodo next;
    public Programa program;

    public Nodo(Programa programa) {
        this.next=null;
        this.program= programa;
    }//constructor

}//fin class
