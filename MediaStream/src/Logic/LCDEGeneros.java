package Logic;

public class LCDEGeneros {

    LDEProgramas start, end;
    int contGeneros;

    public LCDEGeneros() {
        this.start = this.end = null;
        this.contGeneros = 0;
    }//constructor

    public int getSize() {
        return contGeneros;
    }//getSize

    public boolean isEmpty() throws LCDEException {
        return start==null;
    }//isEmpty

    public void insert(LDEProgramas lista) {

        LDEProgramas aux=start;
        LDEProgramas newList= lista;

        if (aux==null) {
            start=end=newList;
            this.contGeneros++;
        }else {
            if (!exists(lista)) {
                while(aux!=end) {
                    aux=aux.next;
                }//endWhile
                aux.next=newList;
                newList.before=aux;
                this.end=newList;
                //Hacemos el doble enlace
                this.contGeneros++;
            }//endIf
        }//endElse
        this.end.next=this.start;
        this.start.before=this.end;
        //Hacemos el enlace circular
    }//insert

    public Object getBefore(Object element){
        LDEProgramas aux=start;

        while (aux!=end) {
            if (aux.genero.equals(element))
                return aux.before.genero;

            aux=aux.next;
        }
        if(end.genero.equals(element))
            return aux.before.genero;

        return null;
    }//getBefore

    public Object getNext(Object element){
        LDEProgramas aux=start;

        while (aux!=end) {
            if (aux.genero.equals(element))
                return aux.next.genero;

            aux=aux.next;
        }
        if(end.genero.equals(element))
            return aux.next.genero;

        return null;
    }//getNext

    public boolean exists(LDEProgramas lista) {
        if (isEmpty()) {
            throw new LCDEException("NO hay programas");
        }else {
            LDEProgramas aux = this.start;
            boolean existe = false;
            while (aux!=this.end) {
                if (aux.genero.equals(lista.genero)) {
                    existe=true;
                }//endIf
                aux=aux.next;
            }//endWhile

            if (this.end.genero.equals(lista.genero)) {
                existe=true;
            }//endIf
            return existe;
        }//endElse
    }//exists

    public LDEProgramas getStart() {
        return start;
    }

    public String toString() {
        if (isEmpty()) {
            return "No hay programas";
        }else {
            LDEProgramas aux = this.start;
            String result="Lista de los Generos:\n";
            result+="----------------------------------------\n";

            while (aux!=this.end) {
                result+= aux.genero+"<-->";
                aux=aux.next;
            }
            result+=this.end.genero+"<-->";
            return  result;
        }//endElse
    }//toString

}//fin LCDEGenero
