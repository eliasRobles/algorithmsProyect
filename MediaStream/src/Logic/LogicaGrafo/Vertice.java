package Logic.LogicaGrafo;

import Domain.Program;

public class Vertice {

	Program programa;// elemento almacenado en el vertice
	boolean visitado;
	boolean destino;
	// listas enlazadas para cuando trabajemos el grafo con listas
	CircularDoubleLikedList listaAristas, listaPesos;

	public Vertice(Program programa) {
		this.programa=programa;
		this.destino=false;
		this.visitado=false;
		//inicializar las listas
		listaAristas= new CircularDoubleLikedList();
		listaPesos= new CircularDoubleLikedList();
	}
	
	
}
