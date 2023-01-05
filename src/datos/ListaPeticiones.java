//TODO
package datos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
/* Programador: Juan Ignasi Cid Guardia */
public class ListaPeticiones {
	
	private Peticion[] lista;
	private int nElementos = 0;

	//Constructor de la lista de peticiones con 50 elementos por defecto
	public ListaPeticiones() {
		lista = new Peticion[50];
	}

	//TODO Hace falta controlar qeu ambos sean productos y no servicios
	public void crearPeticion(String id, String proveedor, String cliente, String prodPedido, String prodOfrecido) {
		
		lista[nElementos] = new Peticion(id, proveedor, cliente, prodPedido, prodOfrecido);
		
		nElementos++;
		if(nElementos >= lista.length)
			ampliarLista();
	}
	
	//devuelve falso si la peticion no ha sido visualizada
	public boolean aceptaPeticion(Peticion peticion) {
		
		if(peticion.getEstadoPeticion() == -2)
			return false;
		peticion.acepta();
		return true;
	}
	
	//devuelve falso si la peticion no ha sido visualizada
	public boolean rechazaPeticion(Peticion peticion) {
		if(peticion.getEstadoPeticion() == 1)
			return false;
		peticion.rechaza();
		return true;
	}
	
	public int buscaPeticion(String id) {
		int i=0;
		boolean trobat = false;
		while(i<nElementos && trobat == false) {
			if(lista[i].esEsteId(id))
				trobat = true;
			else
				i++;
		}
		if(i==nElementos)
			i=-1;
		
		return i;
	}
	
	private void ampliarLista() {
		Peticion[] temp = new Peticion[lista.length+50];
		
		for(int i = 0; i<lista.length; i++) 
			temp[i] = lista[i].copia();
		
		lista = temp;
	}
	
	
	public  void guardaFichero(String nFichero) throws IOException {
		BufferedWriter w = new BufferedWriter(new FileWriter(nFichero+".csv"));
		
		w.write(nElementos+";");
		w.newLine();
		
		for (int i=0; i<nElementos; i++) {
			w.write(lista[i].getSerializado());
			w.newLine();
		}
		
		w.close();
	}
	
	//Lee de un archivo y devuelve una lista de peticiones
	public void leerFichero(String nFichero) throws FileNotFoundException {
		int nLineas;
		String info ="";
		String[] infoSeparada;
		Scanner f = new Scanner(new File(nFichero));
		nLineas = Integer.parseInt(f.nextLine()); 
		
		for(int i=0; i<nLineas; i++) {
			info = f.nextLine();
			infoSeparada = info.split(";");
			crearPeticion(infoSeparada[0], infoSeparada[1], infoSeparada[2], infoSeparada[3], infoSeparada[4]);
		}
		
		
		
		
		f.close();
	}
	
	@Override
	public String toString() {
		String retorn = "";
		for(int i=0; i < nElementos; i++) {
			if(this.lista[i]!=null )
			retorn += (lista[i].toString()+"\n");
		}
		return retorn;
	}
	

	
}
	



