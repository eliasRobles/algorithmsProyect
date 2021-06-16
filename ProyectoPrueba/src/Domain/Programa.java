package Domain;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Programa {
    public String tipo;
    public int duracion;
    public int restriccion;
    public String nombre;
    public Programa next, before;
    public Image img;
    //1) Hacer una segunda imagen con todos los datos de esta, que es mas tedioso.
    //2) Hacer solo una imagen de fondo, (como una escena de la peli) e ir poniendo los datos de la lista global..
    //3) Hacer un fondo negro y poner los datos, nada mas.
    //Nota: esto se trataría como una nueva ventana o en la misma...


    public Programa(String tipo, int duracion, int restriccion, String nombre, Image img) {
        this.tipo=tipo;
        this.duracion=duracion;
        this.restriccion=restriccion;
        this.nombre=nombre;
        this.next=null;
        this.before=null;
        this.img=img;
    }//constructor

    @Override
    public String toString() {
        return "Programa{" +
                "tipo='" + tipo + '\'' +
                ", duracion=" + duracion +
                ", restriccion=" + restriccion +
                ", nombre='" + nombre + '\'' +
                '}';
    }//toString
}//fin class
