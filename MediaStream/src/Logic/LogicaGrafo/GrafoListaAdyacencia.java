package Logic.LogicaGrafo;


import Domain.Program;
import Logic.ColaEnlazada;

public class GrafoListaAdyacencia implements Grafo {
	private ColaEnlazada colaAlmacen;
	private Vertice[] vertices;
	private int contador;
	private int n;
	private int cTerror;
	private int cComedia;
	private int cRomance;
	private int cDocumental;
	private int cAccion;
	private int cKid;

	//private PilaEnlazada pilaEnlazada;
	//private ColaEnlazada colaEnlazada;
	
	public GrafoListaAdyacencia(int n) {
		if (n<=0) 
			System.exit(0);
		this.n=n;
		vertices= new Vertice[n];
		this.contador=0;
		this.colaAlmacen=new ColaEnlazada();
		//this.pilaEnlazada= new PilaEnlazada();
		//this.colaEnlazada= new ColaEnlazada();
		this.cKid=0;
		this.cTerror=0;
		this.cComedia=0;
		this.cDocumental=0;
		this.cAccion=0;
		this.cTerror=0;
	}//constructor
	
	
	@Override
	public void anular() {
		for (int i = 0; i < contador; i++) {
			vertices[i]=null;
		}//for
		contador=0;
	}//anular

	@Override
	public boolean isEmpty() {
		return contador== 0;
	}

	@Override
	public int getSize() throws GrafoException {
		return contador;
	}//getSize

	@Override
	public boolean existVertice(Program programa) throws GrafoException {
		if (isEmpty()) {
			throw new GrafoException("El grafo esta vacio");
		}//if
		
		for (int i = 0; i < contador; i++) {
			if (vertices[i].programa.equals(programa)) {
				return true;
			}//if
		}//for
		return false;
	}//existVertice

	@Override
	public boolean existeArista(Object v1, Object v2) throws GrafoException {
		/*
		if (isEmpty()) 
			throw new GrafoException("El grafo esta vacio");
		
		if (vertices[getPosicion(v1)].listaAristas.exists(v2) && vertices[getPosicion(v2)].listaAristas.exists(v1)) {
			return true;
		}
		return false;
		 */
		return false;
	}

	@Override
	public void agregaVertice(Program programa) throws GrafoException {
		if (contador>=vertices.length) {
			throw new GrafoException("El grafo esta lleno");
		}
		if (programa.genero.equals("terror")){
			cTerror++;
		}else if (programa.genero.equals("comedia")){
			cComedia++;
		}else if (programa.genero.equals("documental")){
			cDocumental++;
		}else if (programa.genero.equals("romance")){
			cRomance++;
		}else if (programa.genero.equals("accion")){
			cAccion++;
		}else if(programa.genero.equals("kid")){
			cKid++;
		}//else-if
		vertices[contador++]=new Vertice(programa);
		agregaArista(programa);
	}//agregaVertice


	public void agregaArista(Program v2) throws GrafoException {
		if (!existVertice(v2)) {
			throw new GrafoException("Uno o ambos vertices no existen");
		}//if
		if (this.getSize()>1){
			vertices[this.contador-2].listaAristas.insert(v2);
			vertices[this.contador-1].listaAristas.insert(vertices[this.contador-2].programa);
		}//if
	}//agregaArista

	//metodos privados auxiliares
		private int getPosicion(Program programa) {
			for (int i = 0; i < contador; i++) {
				if (vertices[i].programa.equals(programa)) {
					return i;
				}
			}
			return -1;//significa que el vertice no existe
		}//fin getPosicion;
		
	
	@Override
	public void agregaPeso(Object v1, Object v2, Object peso) throws GrafoException {
		// TODO Auto-generated method stub
		
	}
	/*
	@Override
	public String dfs() throws GrafoException {
		String info="";
		vertices[0].visitado= true;
		info+=muestraVertice(0)+" ";
		pilaEnlazada.push(0);
		while (!pilaEnlazada.isEmpty()) {
			int v= verticeAdyacenteNoVisitado(Integer.parseInt(pilaEnlazada.top().toString()));
			if (v==-1) {
				pilaEnlazada.pop();
			}else {
				vertices[v].visitado=true;
				info+=muestraVertice(v)+" ";
				pilaEnlazada.push(v);
			}
		}
		for (int i = 0; i < contador; i++) {
			vertices[i].visitado=false;
		}
		return info;
	}

	@Override
	public String bfs() throws GrafoException {
		String info="";
		vertices[0].visitado=true;
		info+=muestraVertice(0)+"";
		colaEnlazada.encolar(0);
		int v2=0;
		while (!colaEnlazada.isEmpty()) {
			int v= verticeAdyacenteNoVisitado(Integer.parseInt(colaEnlazada.head().toString()));
			if (v!=-1 && v<contador) {
				vertices[v].visitado=true;
				info+=muestraVertice(v)+"";
				colaEnlazada.encolar(v);
				while ((v2=verticeAdyacenteNoVisitado(v))!=-1) {
					vertices[v2].visitado=true;
					info+=muestraVertice(v2)+" ";
					colaEnlazada.encolar(v2);
				}
			}
			if (v2==-1 && v==-1) {
				colaEnlazada.desencolar();
			}	
		}
		return info;
	}
	 */

	@Override
	public void agregaAristaYPeso(Object v1, Object v2, Object peso) throws GrafoException {
	/*
		if (!existVertice(v1)||!existVertice(v2)) 
			throw new GrafoException("Uno o ambos vertices no existen");
		
		vertices[getPosicion(v1)].listaAristas.insert(v2);
		vertices[getPosicion(v2)].listaAristas.insert(v1);
		vertices[getPosicion(v1)].listaPesos.insert(peso);
		vertices[getPosicion(v2)].listaPesos.insert(peso);

	 */
	}
	/*
	private int verticeAdyacenteNoVisitado(int v) {
		for (int i = 0; i < contador; i++) {
			if (vertices[i].listaAristas.exists(muestraVertice(v)) && vertices[i].visitado==false)
				return i;
			
		}
		return -1;
	}

	 */
	/*
	private Object muestraVertice(int pos) {
		if (pos<0 || pos==contador) 
			throw new GrafoException("No Existe el vertice en el grafo ");
		
		return vertices[pos].element.toString();
	}
	 */
	public String toString() {
		
		String result="Informacion del grafo: ";
		result+="\n";
		result+="\nVertices: \n";
		for (int i = 0; i < contador; i++) {
			if (vertices[i]!=null) 
				result+=vertices[i].programa+" ";
		}
		result+="\n";
		result+="\nAristas: \n";
		
		for (int i = 0; i <contador; i++) {
			result+=vertices[i].listaAristas.toString();
			
		}
		result+="\n";
		result+="Pesos: \n";
		for (int i = 0; i < contador; i++) {
			
			result+=vertices[i].listaPesos.toString();
		}
		return result;
	}

	public int getcTerror() {
		return cTerror;
	}

	public void setcTerror(int cTerror) {
		this.cTerror = cTerror;
	}

	public int getcComedia() {
		return cComedia;
	}

	public void setcComedia(int cComedia) {
		this.cComedia = cComedia;
	}

	public int getcRomance() {
		return cRomance;
	}

	public void setcRomance(int cRomance) {
		this.cRomance = cRomance;
	}

	public int getcDocumental() {
		return cDocumental;
	}

	public void setcDocumental(int cDocumental) {
		this.cDocumental = cDocumental;
	}

	public int getcAccion() {
		return cAccion;
	}

	public void setcAccion(int cAccion) {
		this.cAccion = cAccion;
	}

	public ColaEnlazada getColaAlmacen() {
		return colaAlmacen;
	}

	public void setColaAlmacen(ColaEnlazada colaAlmacen) {
		this.colaAlmacen = colaAlmacen;
	}

	public int getcKid() {
		return cKid;
	}

	public void setcKid(int cKid) {
		this.cKid = cKid;
	}
}// fin GrafoListaAdyacencia
