package main;

public class Grafo {
	int CantNodos;
	Vertice[] vertice;
	
	public Grafo(int CantNods){
		this.CantNodos=CantNods;
		vertice = new Vertice[CantNods];
		for(int i = 0; i<CantNods; i++){
			vertice[i] = new Vertice(i);
		}
	}
	
	void addEdge(int Vert1, int Vert2){
		vertice[Vert1].ady.add(vertice[Vert2]);
		if(Vert1!=Vert2)
			vertice[Vert2].ady.add(vertice[Vert1]);
	}

}