package main;

import java.util.LinkedList;

public class PRIM extends Grafo{
	int costo;
	int[] inicio;
	int[] incluido;

	public PRIM(int CantNods) {
		super(CantNods);  //miramos la cantidad de nodos del padre
		costo = 0;
		inicio = new int[CantNods];
		for(int i = 0; i<CantNods; i++)	
		inicio[i] = Integer.MAX_VALUE;
		incluido = new int[CantNods];
	}
	
	int extractMin(){
		int min=Integer.MAX_VALUE;
		int indice=-1;
		for(int i=0;i<CantNodos;i++){
			if(incluido[i]==0 && inicio[i]<min){
				min = inicio[i];
				indice=i;
			}
		}
		return indice;
	}
	
	void Prim(int[][] peso, int comienzo){
		inicio[comienzo]=0;
		vertice[comienzo].padre=null;
		int min = extractMin();//fijamos a min el indice obtenido en extractMin
		while(min!=-1){
			costo+=inicio[min];
			for(Vertice ver:vertice[min].ady){
				if(incluido[ver.dato]==0 && peso[min][ver.dato]<inicio[ver.dato]){
					ver.padre=vertice[min];
					inicio[ver.dato]=peso[min][ver.dato];
				}
			}
			incluido[min]=1;
			min=extractMin();
		}
		System.out.println("Costo camino minimo: "+costo);
	}
	
	
}
	class Vertice {
	LinkedList<Vertice> ady;
	int dato;
	int distancia;//distancia desde el inicio del vertice
	Vertice padre;
	
	public Vertice(int data){
		this.dato=data;
		distancia=-1;
		padre=null;
		ady = new LinkedList<>();
		
	}
	}
	
	


