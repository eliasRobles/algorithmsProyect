package Data;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StatusData {

    public void guardarPos(int pos) throws FileNotFoundException, IOException, ClassNotFoundException {
        File file = new File("pos.dat");
        List<Integer> posiciones = new ArrayList<>();
        if (file.exists()) {
            ObjectInputStream input =
                    new ObjectInputStream(new FileInputStream(file)
                    );
            Object aux = input.readObject();
            posiciones = (List<Integer>)aux;
            input.close();
        }//if
        posiciones.add(pos);
        ObjectOutputStream output =
                new ObjectOutputStream(new FileOutputStream(file)
                );
        output.writeUnshared(posiciones);
        output.close();
    }//guardarPos

    public List<Integer> retornarPosiciones() throws FileNotFoundException, IOException, ClassNotFoundException{
        File file = new File("pos.dat");
        List<Integer> posiciones = new ArrayList<Integer>();
        if (file.exists()) {
            ObjectInputStream input = new ObjectInputStream(
                    new FileInputStream(file)
            );
            Object aux = input.readObject();
            posiciones=(List<Integer>)aux;
            input.close();
            return posiciones;
        }//if
        return null;
    }//retornarPosiciones

    public boolean logIn(int pos, ArrayList<Integer> posiciones) throws IOException, ClassNotFoundException {

        ArrayList<Integer> aux = new ArrayList<>();

        for (int i = 0; i < posiciones.size(); i++) {
            if (i==pos){
                aux.add(1);
            }else {
                aux.add(0);
            }//else
        }//for

        File file = new File("pos.dat");
        if (file.exists()){
            file.delete();
            for (int i = 0; i < aux.size(); i++) {
                this.guardarPos(aux.get(i));
            }//for
        }//if

        return true;
    }//eliminarYActualizar

    public boolean logOut(int pos, ArrayList<Integer> posiciones) throws IOException, ClassNotFoundException {

        ArrayList<Integer> aux = new ArrayList<>();

        for (int i = 0; i < posiciones.size(); i++) {
            aux.add(0); //Reiniciamos el arreglo con ceros
        }//for

        File file = new File("pos.dat");
        if (file.exists()){
            file.delete();
            for (int i = 0; i < aux.size(); i++) {
                this.guardarPos(aux.get(i));
            }//for
        }//if

        return true;
    }//eliminarYActualizar

}//fin class
