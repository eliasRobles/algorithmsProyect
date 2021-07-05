package Logic;

import Domain.Program;

public interface Cola {

    public int getSize();

    public boolean isEmpty();//

    public void cancel();//

    public void encolar(Program program) throws ColaException;//

    public Program desencolar() throws ColaException; //

    public Program head() throws ColaException;//

    public boolean exists(Object programName);//

    public int getPosition(Object programName);//

}//fin interface
