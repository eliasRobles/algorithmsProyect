package Logic.LogicaGrafo;

import Domain.Program;

public interface Grafo {

	// eliminar el grafo
	public void anular();
	
	public boolean isEmpty();
	
	public int getSize()throws GrafoException;
	
	public boolean existVertice(Program programa)throws GrafoException;
	
	public boolean existeArista(Object v1, Object v2)throws GrafoException;
	
	public void agregaVertice(Program programa)throws GrafoException;
	
	public void agregaArista(Program v2)throws GrafoException;
	
	public void agregaPeso(Object v1, Object v2, Object peso)throws GrafoException;
	
	public void agregaAristaYPeso(Object v1, Object v2, Object peso)throws GrafoException;
	
	//1- recorre el grafo el grafo utilizando el algoritmo de busqueda en pronfundidad
	//public String dfs()throws GrafoException;
	
	
	//2- recorre el grafo el grafo utilizando el algoritmo de busqueda en amplitud/anchura
	//public String bfs()throws GrafoException;
	
	
	
}
