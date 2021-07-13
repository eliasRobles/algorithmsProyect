package Logic.LogicaGrafo;

import Domain.Program;

public class CircularDoubleLikedList implements Lista{
	Nodo start,end;
	int cont;
	
	public CircularDoubleLikedList() {
		start=end=null;
		this.cont=0;
	}

	@Override
	public int getSize() {
		return cont;
	}

	@Override
	public void cancel() {
		this.start=this.end=null;
		cont--;
	}

	@Override
	public boolean isEmpty() throws ListaException {
		return start==null;
	}

	@Override
	public void insert(Program programa) {
			Nodo aux = start; // Defino aux para moverme por la lista y no perder el inicio
			Nodo newNode = new Nodo(programa); // El nuevo nodo que estamos almacenando

			if (aux == null) {// Caso 1: Cuando la lista est� vac�a
				start = end = newNode;
			} else {
				while (aux != end) {
					aux = aux.next; // Mueve el aux al siguiente nodo
				} // Se sale cuando sea el fin de la lista
				aux.next = newNode; // Almacenamos el nuevo nodo
				newNode.before = aux; // Hacemos el doble enlace
				end = newNode; // Se actualiza el �ltimo nodo
			}
			// Se hace el doble enlace circular
			end.next = start;
			start.before = end;
			cont++; // Se agreg� un nodo a la lista, le sumamos 1 a contadorDeNodos(count)
		
		
//		Nodo aux=start;
//		Nodo newNodo=new Nodo(element);
//		
//		if (aux==null) {
//			start=end=newNodo;
//		}else {
//			while(aux!=end) {
//			aux=aux.next;
//		}
//		aux.next=newNodo;
//		newNodo.before=aux;
//		end=newNodo;
//		}
//		end.next=start;
//		start.before=end;
//		cont++;
	}

	@Override
	public int getPosition(Program programa) {
		if (isEmpty()) 
			throw new ListaException("Lista vacia");
		Nodo aux=start;
		int pos=1;
		while (aux!=end) {
			if (aux.programa.equals(programa))
				return pos;
			
			aux=aux.next;
			pos++;
		}
		if(end.programa.equals(programa))
			return pos;
		
		return -1;
	}

	@Override
	public void delete1(Program programa) {
		
		if (isEmpty()) {
			throw new ListaException("Lista vacia");
			
		}
		Nodo aux=start;
		if (start.programa.equals(programa)) {
			start=start.next;
			start.before=end;			
		}else {
			while(aux!=end && !aux.programa.equals(programa)) {
				aux=aux.next;
			}
			if (aux.programa.equals(programa)) {
				aux.before.next=aux.next;
				aux.next.before=aux.before;
			}
			if (aux==end) {
				end=aux.before;
			}
		}
		end.next=start;//para manteber el enlace circular 
		start.before=end;
		cont--;
		
		if (start==end && start.programa.equals(programa)) {
			cancel();
		}
	}

	@Override
	public void delete2(int position) {
		
		if (isEmpty()) {
			throw new ListaException("Lista vacia");	
		}
		if (position==0) {
			start=start.next;
			start.before=end;
		} else {
			int contador=0;
			Nodo aux=start;
			while (contador<position-1) {
				aux=aux.next;
				contador++;
			}
			aux.enlazarSiguiente(aux.next.next);
		}
//		Nodo aux=start;
//		if (position==0) {
//			start=start.next;
//			start.before=end;			
//		}else {
//			int contador=0;
//			while(contador<position-1 ) {
//				aux=aux.next;
//				contador++;
//			}
//			if (aux.element) {
//				aux.before.next=aux.next;
//				aux.next.before=aux.before;
//			}
//			if (aux==end) {
//				end=aux.before;
//			}
//		}
		end.next=start;//para manteber el enlace circular 
		start.before=end;
		cont--;
		
		if (start==end && getSize()==position) {
			cancel();
		}
		
	}

	@Override
	public boolean exists(Program programa) {
		Nodo aux=start;
		while (aux!=end ) {
			if (aux.programa.equals(programa)) {
				return true;
			}
			aux=aux.next;
		}
		if (end.programa.equals(programa)) {
			return true;
		}
		return false;
	}

	@Override
	public Object firstInList() {
		return start.programa;
	}

	@Override
	public Object lastInList() {
		return end.programa;
	}

	@Override
	public Object getByPosition(int position) {
		if (isEmpty()) 
			throw new ListaException("Lista vacia");
		int cont2=0;
		Nodo aux=start;
		while (cont2<position) {
			aux=aux.next;
			cont2++;
		}
		return aux.programa;
	}
	
	public String toString() {
		String result="";
		if (isEmpty()) {
			return "\nLa lista esta vacia \n";
		} else {
			Nodo aux=start;
			while (aux!=end) {
				
				result+=aux.programa+"<-->";
				aux=aux.next;
				
			}
			result+=end.programa+"<-->";
	}
		return result;
	}
	
	
}
