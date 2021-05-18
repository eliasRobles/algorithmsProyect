package Domain;

public class LCDEGenero {

    NodoLCDE start, end;
    int cont;

    public LCDEGenero() {
        this.start = this.end = null;
        this.cont = 0;
    }

    public int getSize() {
        return cont;
    }

    public boolean isEmpty() throws LCDEException{
        return start==null;
    }

    public void insert(Object element) {

        NodoLCDE aux=start;
        NodoLCDE newNodo=new NodoLCDE(element);

        if (aux==null) {
            start=end=newNodo;
        }else {
            while(aux!=end) {
                aux=aux.next;
            }
            aux.next=newNodo;
            newNodo.before=aux;
            end=newNodo;
        }
        end.next=start;
        start.before=end;
        cont++;
    }

    public Object getBefore(Object element){
        NodoLCDE aux=start;

        while (aux!=end) {
            if (aux.genero.equals(element))
                return aux.before.genero;

            aux=aux.next;
        }
        if(end.genero.equals(element))
            return aux.before.genero;

        return null;
    }
    public Object getNext(Object element){
        NodoLCDE aux=start;

        while (aux!=end) {
            if (aux.genero.equals(element))
                return aux.next.genero;

            aux=aux.next;
        }
        if(end.genero.equals(element))
            return aux.next.genero;

        return null;
    }


}//fin LCDEGenero
