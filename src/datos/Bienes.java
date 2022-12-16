package datos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/* Programador: Eloi Cuevas Marcos */
public class Bienes extends Productos {
	private int[] dimension; 
	private int peso;
	private Data intercanvio; 
	public Bienes(String id,String de,Data d,int ampl,int alc,int fons,int p,Data inter) {
		super(id, de,d);
		dimension  = new int[3]; 
		dimension[0]=ampl;
		dimension[1]=alc;
		dimension [2]=fons;
		peso=p;
		intercanvio=inter;
 }
 
public int getDimension(int i) {
	return dimension[i];
}

public void setDimension(int[] dimension) {
	this.dimension = dimension;
}

public int getPeso() {
	return peso;
}

public void setPeso(int peso) {
	this.peso = peso;
}

public Data getIntercanvio() {
	return intercanvio;
}

public void setIntercanvio(Data intercanvio) {
	this.intercanvio = intercanvio;
}

public String toString() {
	return   "Bien "+super.toString()+", Amplitud=" + dimension[0]+", Altura="+dimension[1]+", Fondo="+dimension[2] + ", Peso="
			+ peso + ", Intercanvio=" + intercanvio + "]";
}



}
