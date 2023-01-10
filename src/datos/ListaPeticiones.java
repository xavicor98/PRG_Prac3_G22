package datos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ListaPeticiones {
	
	/** Lista de las peticiones. */
	private Peticion[] lista;
	
	/** Numero de elementos. */
	private int nElementos = 0;

	/**
	 * Cuando se crea una instancia se asignan 50 posiciones a la lista.
	 */
	//Constructor de la lista de peticiones con 50 elementos por defecto
	public ListaPeticiones() {
		lista = new Peticion[50];
	}

	/**
	 * Crear peticion.
	 *
	 * @param id el id
	 * @param proveedor el proveedor
	 * @param cliente el cliente
	 * @param prodPedido el producto pedido
	 * @param prodOfrecido el producto ofrecido
	 */
	//Especifico numero 2
	public void crearPeticion(String id, String proveedor, String cliente, String prodPedido, String prodOfrecido) {
		
		try {
			if(buscaPeticion(id)==-1) {
				lista[nElementos] = new Peticion(id, proveedor, cliente, prodPedido, prodOfrecido);
				
				nElementos++;
				if(nElementos >= lista.length)
					ampliarLista();
			}else {
				throw new Exception();
			}
		} catch (Exception e) {
			// Hace falta poner la propia excepcion
		}
	}
	
	/**
	 * Acepta peticion.
	 *
	 * @param peticion la peticion
	 * @return true, si ha sido visualizada y se ha aceptado
	 */
	//devuelve falso si la peticion no ha sido visualizada
	public boolean aceptaPeticion(Peticion peticion) {
		
		if(peticion.getEstadoPeticion() == -2)
			return false;
		peticion.acepta();
		return true;
	}
	
	/**
	 * Acepta rechaza.
	 *
	 * @param peticion el peticion para aceptar o rechazar
	 * @param aceptaRechaza 1 para aceptar otro valor para rechazar
	 */
	//Especifico numero 1
	public void aceptaRechaza(String peticion, int aceptaRechaza) {
		try {
			if(aceptaRechaza == 1) {
				if(aceptaPeticion(lista[buscaPeticion(peticion)]) == false) {
					throw new Exception();
				}
			}else {
				if(rechazaPeticion(lista[buscaPeticion(peticion)]) == false) {
					throw new Exception();
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	/**
	 * Rechaza peticion.
	 *
	 * @param peticion la peticion
	 * @return true, si ha sido visualizada y se ha podido rechazar
	 */
	//devuelve falso si la peticion no ha sido visualizada
	public boolean rechazaPeticion(Peticion peticion) {
		if(peticion.getEstadoPeticion() == 1)
			return false;
		peticion.rechaza();
		return true;
	}
	
	/**
	 * Busca peticion.
	 *
	 * @param id el id de la peticion a buscar
	 * @return la posicion de la lista en donde esta la peticion
	 */
	
	public int buscaPeticion(String id) {
		int i=0;
		boolean trobat = false;
		
		while(i<nElementos && trobat == false) {
			if(lista[i].esEsteId(id))
				trobat = true;
			else
				i++;
		}
		if(trobat == false)
			i=-1;
		
		return i;
	}
	
	/**
	 * Ampliar lista.
	 */
	private void ampliarLista() {
		Peticion[] temp = new Peticion[lista.length+50];
		
		for(int i = 0; i<lista.length; i++) 
			temp[i] = lista[i].copia();
		
		lista = temp;
	}
	
	/**
	 * Guarda fichero.
	 *
	 * @param nFichero el nombre del fichero
	 * @throws IOException en caso de haber algun problema con la escritura del archivo.
	 */
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
	
	/**
	 * Leer fichero.
	 *
	 * @param nFichero el nombre del fichero para leer
	 * @throws FileNotFoundException si no se ha encontrado el fichero
	 */
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
	
	/**
	 * Peticiones pendientes.
	 *
	 * @return string de peticiones no visualizadas
	 */
	//Especifico numero 3
	public String peticionesPendientes() {
		String retorn = "";
		for(int i=0; i < nElementos; i++) {
			if(this.lista[i].getEstadoPeticion()==0) {
				if(this.lista[i]!=null )
				retorn += (lista[i].toString()+"\n");
			}
		}
		return retorn;
	}
	
	/**
	 * Peticiones aceptadas.
	 *
	 * @return string de peticiones aceptadas
	 */
	//Especifico numero 4
	public String peticionesAceptadas() {
		String retorn = "";
		for(int i=0; i < nElementos; i++) {
			if(this.lista[i].getEstadoPeticion()==1) {
				if(this.lista[i]!=null )
				retorn += (lista[i].toString()+"\n");
			}
		}
		return retorn;
	}
	
	/**
	 * Peticiones rechazadas.
	 *
	 * @return string de peticiones rechazadas
	 */
	//Especifico numero 5
	public String peticionesRechazadas() {
		String retorn = "";
		for(int i=0; i < nElementos; i++) {
			if(this.lista[i].getEstadoPeticion()==-1) {
				if(this.lista[i]!=null )
				retorn += (lista[i].toString()+"\n");
			}
		}
		return retorn;
	}
	
	/**
	 * Gets the peticion.
	 *
	 * @param peticion peticion a buscar y devolver
	 * @return peticion que se pide, null en caso de no existir
	 */
	//Especifico 6
	public Peticion getPeticion(String peticion) {
		Peticion retorno = null;
		try {
			retorno = lista[buscaPeticion(peticion)].copia();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return retorno;
	}
	
	/**
	 * To string.
	 *
	 * @return string con la informacion de la clase
	 */
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