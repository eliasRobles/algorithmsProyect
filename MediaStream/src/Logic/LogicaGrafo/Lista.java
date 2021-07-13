package Logic.LogicaGrafo;

import Domain.Program;

public interface Lista {

	public int getSize();
	
	// eliminar,destruir,anular,resetear
	public void cancel();
	
	public boolean isEmpty() throws ListaException;
	
	//agrega un nuevo nodo a la lista
	public void insert(Program programa);
	
	public int getPosition(Program programa);
	
	public void delete1(Program programa);
	public void delete2 (int position);
	
	//devuelve true si existe el elemento en la lista
	public boolean exists(Program programa);
	
	//devuelve el primer elemento de la lista 
	//return inicio.element
	
	public Object firstInList();

	public Object lastInList();
	
	public Object getByPosition(int position);
	
}//fin Lista
