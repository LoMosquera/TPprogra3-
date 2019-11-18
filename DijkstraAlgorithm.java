package main;

import java.util.*;




class Dijkstra{
    
    
    private final int MAX = 10005;  //maximo numero de vértices
    private final int INF = 999999;  //definimos un valor grande que sea superior al maximo valor del peso en cualqueira de las aristas
    
    private List< List< Nodo > > ady = new ArrayList< List< Nodo > >(); //Es la lista de adyacencia, se crea la lista con los nodos
    private int distancia[ ] = new int[ MAX ];          				
    private boolean visitado[ ] = new boolean[ MAX ];   				
    private PriorityQueue< Nodo > Q = new PriorityQueue<Nodo>(); 	//Q viene de queue	//priority queue propia de Java, usamos el comparador definido para que el de menor valor este en el tope
    private int Vert;                                      				//Vert= vertice, indica el numero de vertices
    private int previo[] = new int[ MAX ];              				//para la impresion de caminos
    private boolean dijkstraEjecutado;
    
    Dijkstra(int Vert){
        this.Vert = Vert;
        for( int i = 0 ; i <= Vert ; ++i ) 
            ady.add(new ArrayList<Nodo>()) ; //inicializamos la lista de adyacencia
        dijkstraEjecutado = false;
    }
    
    
    class Nodo implements Comparable<Nodo>{
        int primero, segundo;							//p=primero , s=segundo
        Nodo( int p , int s ){                          //constructor
            this.primero = p;
            this.segundo = s;
        }
        public int compareTo( Nodo siguiente){              
            if( segundo > siguiente.segundo ) return 1;
            if( segundo == siguiente.segundo ) return 0;
            return -1;
        }
    };
    
    //función de inicialización
    private void inicializar(){
        for( int i = 0 ; i <= Vert ; ++i ){
            distancia[ i ] = INF; 
            visitado[ i ] = false; 
            previo[ i ] = -1;
        }
    }

    //Paso de relajacion
    private void VerDis( int actual , int adyacente , int peso ){
        //Si la distancia del origen al vertice actual + peso de su arista es menor a la distancia del origen al vertice adyacente
        if( distancia[ actual ] + peso < distancia[ adyacente ] ){
            distancia[ adyacente ] = distancia[ actual ] + peso;  // actualizando la distancia
            previo[ adyacente ] = actual;                         //a su vez actualizamos el vertice previo
            Q.add( new Nodo( adyacente , distancia[ adyacente ] ) ); //agregamos adyacente a la cola de prioridad
        }
    }

    void dijkstra( int inicial ){
        inicializar(); 
        Q.add( new Nodo( inicial , 0 ) ); //Insertamos el vértice inicial en la Cola de Prioridad
        distancia[ inicial ] = 0;      
        int actual , adyacente , peso;
        while( !Q.isEmpty() ){                   //Mientras cola no este vacia
            actual = Q.element().primero;            //Obtenemos de la cola el nodo con menor peso, en un comienzo sera el inicial
            Q.remove();                           
            if( visitado[ actual ] ) continue; //Si el vértice actual ya fue visitado entonces sigo sacando elementos de la cola
            visitado[ actual ] = true;         

            for( int i = 0 ; i < ady.get( actual ).size() ; ++i ){ //reviso sus adyacentes del vertice actual
                adyacente = ady.get( actual ).get( i ).primero;   
                peso = ady.get( actual ).get( i ).segundo;        //peso de la arista que une actual con adyacente ( actual , adyacente )
                if( !visitado[ adyacente ] ){        //si el vertice adyacente no fue visitado
                    VerDis( actual , adyacente , peso ); //realizamos el paso de VerDis
                }
            }
        }

        System.out.printf( "Distancias mas cortas iniciando en vertice %d\n" , inicial );
        for( int i = 1 ; i <= Vert ; ++i ){
            System.out.printf("Vertice %d , distancia mas corta = %d\n" , i , distancia[ i ] );
        }
        dijkstraEjecutado = true;
    }
    
    void agregarDatos( int origen , int destino , int peso , boolean dirigido ){
        ady.get( origen ).add( new Nodo( destino , peso ) );    //grafo diridigo
        if( !dirigido )
            ady.get( destino ).add( new Nodo( origen , peso ) ); //no dirigido
    }
    
    void imprimirCaminoCorto(){
        if( !dijkstraEjecutado ){
            System.out.println("Es necesario ejecutar el algoritmo de Dijkstra antes de poder imprimir el camino mas corto");
            return;
        }
      
		
        System.out.println("\nImpresion de camino mas corto con destino: 5");
       
        int destino;
        destino = 5;/////////////////////// cambiar esto para cambiar destino DIJKSTRA
        imprimir( destino );
        System.out.printf("\n");
    }
    
    //Impresion del camino mas corto desde el vertice inicial y final ingresados
    void imprimir( int destino ){
        if( previo[ destino ] != -1 )    //si aun poseo un vertice previo
            imprimir( previo[ destino ] );  //recursivamente sigo explorando
        System.out.printf("%d " , destino );        
    }

    public int getNumeroDeVertices() {
        return Vert;
    }

    public void setNumeroDeVertices(int numeroDeVertices) {
        Vert = numeroDeVertices;
    }
}
