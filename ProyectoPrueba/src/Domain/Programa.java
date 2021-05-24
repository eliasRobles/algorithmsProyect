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
    }
}//fin class
