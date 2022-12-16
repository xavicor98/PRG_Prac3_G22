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

	
	public void crearPeticion(String id, Usuario proveedor, Usuario cliente, Producto productoPedido, Producto productoOfrecido) {
		
		lista[nElementos] = new Peticion(id, proveedor, cliente, productoPedido, productoOfrecido);
		
		nElementos++;
		if(nElementos >= lista.length)
			ampliarLista();
	}
	
	
	public boolean aceptaPeticion(Peticion peticion) {
		
		if(peticion.getEstadoPeticion() == -2)
			return false;
		peticion.acepta();
		return true;
	}
	
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
		for(int i=0; i<nElementos; i++) {
			w.write(lista[i].getEstadoPeticion()+";");
			w.write(lista[i].getValoracion()+";");
			w.write(lista[i].getId()+";");
			w.write(lista[i].getProveedor().getnUsuario()+";");
			w.write(lista[i].getCliente().getnUsuario()+";");
			w.write(lista[i].getProdPedido().getnProducto()+";");
			w.write(lista[i].getProdOfrecido().getnProducto()+";");
			w.newLine();
		}
		
		w.close();
	}
	
	//Lee de un archivo y devuelve una lista de peticiones
	private ListaPeticiones llegirLiniesFitxer(String nFichero) throws FileNotFoundException {
		int nLineas;
		String info;
		ListaPeticiones result = new ListaPeticiones();

		// La primera linea nos indica el numero de peticione que hay en el fichero
		Scanner f = new Scanner(new File(nFichero));
		nLineas = Integer.parseInt(f.nextLine()); 
		
		System.out.println("El archivo tiene "+nLineas+" peticiones");
		
		for (int i = 0; i < nLineas; i++) {
			info = f.nextLine();
			String[] detalles = info.split(";");
			Usuario proveedor = new Usuario(Integer.parseInt(detalles[2]));
			Usuario cliente = new Usuario(Integer.parseInt(detalles[3]));

			//Usuario proveedor = new Usuario(Integer.parseInt(detalles[1]));;
			//Peticion peticion = new Peticion(nFichero, null, null, null, null)
		}
		f.close();
		return null;
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
	



