package Logic.LogicaGrafo;

import Domain.Program;

public class Nodo {

	//informacion dentro del nodo
	public Program programa;
	//puntero
	public Nodo next;
	public Nodo before;
	
	public Nodo(Program programa) {
		this.programa=programa;
		this.next=this.before=null;
	}
	
	public void enlazarSiguiente(Nodo n) {
		next=n;
	}

	@Override
	public String toString() {
		return programa+"-->";
	}

	
}
