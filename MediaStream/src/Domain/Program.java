package Domain;

import javafx.scene.image.Image;

public class Program {
    public String tipo;
    public int duracion;
    public int restriccion;
    public String nombre;
    public String genero;
    public Program next, before;
    public Image img;
    private boolean visto;//Esto es IMPORTANTE ya que permite saber si el programa se visualizó o no, tembien diferencia la cola de las recomendaciones

    public Program(String tipo, int duracion, int restriccion, String nombre,String genero, Image img) {
        this.tipo=tipo;
        this.duracion=duracion;
        this.restriccion=restriccion;
        this.nombre=nombre;
        this.genero=genero;
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
                ", nombre='" + nombre + '\'' +", genero='" + genero + '\'' +
                '}';
    }//toString

    public boolean isVisto() {
        return visto;
    }//---------------------

    public void setVisto(boolean visto) {
        this.visto = visto;
    }

}//fin class
