package main;

import java.util.ArrayList;
import java.util.List;

public class NodoDFS {

	static class Nodo
	{
		int dato;
		boolean visitado;
		List<Nodo> vecinos;
 
		Nodo(int dato)
		{
			this.dato=dato;
			this.vecinos=new ArrayList<>();
 
		}
		public void agregarVecino(Nodo VecinoNodo)
		
		{
			this.vecinos.add(VecinoNodo);
		}
		public List<Nodo> getVecino() {
			return vecinos;
		}
		public void setVecino(List<Nodo> vecinos) {
			this.vecinos = vecinos;
		}
	}
	
}
