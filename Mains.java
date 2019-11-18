package main;


public class Mains {

	public static void main(String[] args){
		///////////////////////////////////////////PRIM//////////////////////////////////////////////
		
		
		int CantNods =5;
		
		
		int[][] peso = new int[CantNods][CantNods];
		PRIM g = new PRIM(CantNods);
		System.out.println("");
		System.out.println("Algoritmo PRIM********************************************");
		System.out.println("(carga hardcoeada para prueba rapida) Cantidad de nodos: 5 / Cantidad de aristas: 8");
		
		peso[0][1]=1;
		peso[1][0]=1;						//carga de datos hardcodeados
		g.addEdge(0, 1);
		
		peso[0][2]=4;
		peso[2][0]=4;
		g.addEdge(0, 2);
		
		peso[0][4]=2;
		peso[4][0]=2;
		g.addEdge(0, 4);
		
		peso[2][4]=3;
		peso[4][2]=3;
		g.addEdge(2, 4);
		
		peso[1][4]=3;
		peso[4][1]=3;
		g.addEdge(1, 4);
		
		peso[3][1]=3;
		peso[1][3]=3;
		g.addEdge(3, 1);
		
		peso[3][2]=1;
		peso[2][3]=1;
		g.addEdge(3, 2);
		
		peso[3][4]=2;
		peso[4][3]=2;
		g.addEdge(3, 4);
		
		
		
		int comienzo = 0;
		g.Prim(peso,comienzo);
		
		System.out.println("(Revisar codigo para ver estructura)");
		/*
		
		 EJEMPLO 
		 ESTRUCTURA DE HARDCODEO
		 cant nodos: 5
		 cant aristas: 8
		 
		 nodo nodo2 peso
         0    1     1
         0    2     4							//matriz de hardcodeo a modo de visual
         0    4     2
         2    4     3
         1    4     3
         3    1     3
         3    2     1
         3    4     2
		 */
		
		
	
	
			///////////////////////////////////////////////////DFS///////////////////////////////////////////////////////
		System.out.println("");
		System.out.println("Algoritmo DFS*******************************************");
		System.out.println("(carga hardcoeada para prubea rapida)");
		NodoDFS.Nodo nodo4 =new NodoDFS.Nodo(4);   //creo los nodos
		NodoDFS.Nodo nodo1 =new NodoDFS.Nodo(1);
		NodoDFS.Nodo nodo2 =new NodoDFS.Nodo(2);
		NodoDFS.Nodo nodo3 =new NodoDFS.Nodo(3);
		NodoDFS.Nodo nodo6 =new NodoDFS.Nodo(6);
		NodoDFS.Nodo nodo5 =new NodoDFS.Nodo(5);
		NodoDFS.Nodo nodo7 =new NodoDFS.Nodo(7);
		
		/*ESTRUCTURA DE HARDCODEO
		  nodo	 vecinos
		  4       1/2
		  1       3
		  2       1/3/6/5
		  6       7
		  5       7
		*/
		
		
		
		//Creo sus vecinos
		nodo4.agregarVecino(nodo1);
		nodo4.agregarVecino(nodo2);
		nodo1.agregarVecino(nodo3);
		nodo2.agregarVecino(nodo1);
		nodo2.agregarVecino(nodo3);
		nodo2.agregarVecino(nodo6);
		nodo2.agregarVecino(nodo5);
		nodo3.agregarVecino(nodo6);
		nodo6.agregarVecino(nodo7);
		nodo5.agregarVecino(nodo7);
 
		//inicializo el DFS
		GrafoDinamic dfsImplementacion = new GrafoDinamic();
 
		
 
		// Reseteo de banderas para los nodos
		nodo4.visitado=false;
		nodo1.visitado=false;
		nodo2.visitado=false;
		nodo3.visitado=false;
		nodo6.visitado=false;
		nodo5.visitado=false;
		nodo7.visitado=false;
 
		//llamada al DFS
		
		System.out.println("El grafo se visita en el siguiente orden:");
		dfsImplementacion.dfs(nodo4);  //se pasa el nodo inicial
		System.out.println("");
		System.out.println("(Revisar codigo para ver la estructura)");
		System.out.println("");
		
		
		//////////////////////////////////////DISKJTRA///////////////////////////////////////////
		System.out.println("Algritmo diskjtra*****************************************");
		int inicial;
		int CantV;
		
		inicial =1;
		CantV = 5;
        Dijkstra dijkstraAlgorithm = new Dijkstra(CantV);
       
            dijkstraAlgorithm.agregarDatos(1, 2, 7, true);								  
            dijkstraAlgorithm.agregarDatos(1, 4, 2, true);			//Estructura hardcodeada
            dijkstraAlgorithm.agregarDatos(2, 3, 1, true);
            dijkstraAlgorithm.agregarDatos(2, 4, 2, true);
            dijkstraAlgorithm.agregarDatos(3, 5, 4, true);
            dijkstraAlgorithm.agregarDatos(4, 2, 3, true);
            dijkstraAlgorithm.agregarDatos(4, 3, 8, true);
            dijkstraAlgorithm.agregarDatos(4, 5, 5, true);
            dijkstraAlgorithm.agregarDatos(5, 3, 5, true);									
            																				
            																						
       
        System.out.println("Vertice inicial de ejemplo: "+inicial );
        System.out.println(" Cantidad de vertices:"+CantV );
        System.out.println(" ");
        dijkstraAlgorithm.dijkstra(inicial);
        dijkstraAlgorithm.imprimirCaminoCorto();
	
	}
	
	
	
}
