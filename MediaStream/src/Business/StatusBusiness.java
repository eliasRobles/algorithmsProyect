package Business;

import Data.StatusData;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StatusBusiness {

    private StatusData statusData;

    public StatusBusiness() {
        this.statusData = new StatusData();
    }//constructor

    public void guardarPos(int pos) throws FileNotFoundException, IOException, ClassNotFoundException {
        this.statusData.guardarPos(pos);
    }//guardarPos

    public List<Integer> retornarPosiciones() throws FileNotFoundException, IOException, ClassNotFoundException{
        return this.statusData.retornarPosiciones();
    }//retornarPosiciones

    public boolean logIn(int pos, ArrayList<Integer> posiciones) throws IOException, ClassNotFoundException {
        return this.statusData.logIn(pos,posiciones);
    }//LogIn

    public boolean logOut(int pos, ArrayList<Integer> posiciones) throws IOException, ClassNotFoundException {
        return this.statusData.logOut(pos,posiciones);
    }//logOut

}//fin class
