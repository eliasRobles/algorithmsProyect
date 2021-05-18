package Domain;

public class NodoLCDE {

    public  NodoLCDE before;
    public  NodoLCDE next;
    public Object genero;

    public NodoLCDE(Object genero) {
        this.before = null;
        this.next=null;
        this.genero=genero;
    }


}
