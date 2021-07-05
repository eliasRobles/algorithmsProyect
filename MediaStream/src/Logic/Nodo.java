package Logic;

import Domain.Program;

public class Nodo {

    public Nodo next;
    public Program program;

    public Nodo(Program program) {
        this.next=null;
        this.program= program;
    }//constructor

}//fin class
