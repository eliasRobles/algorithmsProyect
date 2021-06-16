package Logic;

import Domain.Programa;

public interface Cola {

    public int getSize();

    public boolean isEmpty();//

    public void cancel();//

    public void encolar(Programa program) throws ColaException;//

    public Programa desencolar() throws ColaException; //

    public Programa head() throws ColaException;//

    public boolean exists(Object programName);//

    public int getPosition(Object programName);//

}//fin interface
