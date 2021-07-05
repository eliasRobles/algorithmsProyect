package Domain;

import javafx.scene.image.Image;

public class Program {
    public String tipo;
    public int duracion;
    public int restriccion;
    public String nombre;
    public Program next, before;
    public Image img;
    private boolean visto;//-------------- Esto es IMPORTANTE ya que permite saber si el programa se visualizó o no, tembipen diferencia la cola de las recomendaciones
    //1) Hacer una segunda imagen con todos los datos de esta, que es mas tedioso.
    //2) Hacer solo una imagen de fondo, (como una escena de la peli) e ir poniendo los datos de la lista global..
    //3) Hacer un fondo negro y poner los datos, nada mas.
    //Nota: esto se trataría como una nueva ventana o en la misma...


    public Program(String tipo, int duracion, int restriccion, String nombre, Image img) {
        this.tipo=tipo;
        this.duracion=duracion;
        this.restriccion=restriccion;
        this.nombre=nombre;
        this.next=null;
        this.before=null;
        this.img=img;
        this.visto=false;
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

    public boolean isVisto() {
        return visto;
    }//---------------------
}//fin class
