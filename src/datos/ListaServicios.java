package datos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;
/* Programador: Eloi Cuevas Marcos */
public class ListaServicios {
	private int numServicios;
	private Servicios[] lista;
	
	public ListaServicios(int n) {
		lista = new Servicios[n];
	}
	
	public int getNumServicios() {
		return numServicios;
	}
	
	public String toString() {
		String aux;
			aux= "ListaProductos numProductos=" + numServicios;
			for (int j = 0; j < numServicios; j++) {
				aux = aux + "\n\tProducto: " + (j + 1) + "\t " + lista[j];
			}
		    return	aux;
	}
	
	public void AnadirServicio(Servicios s1) {
		if (numServicios != lista.length) {
			lista[numServicios]=s1;
			numServicios++;
			
		}
		else {
			System.out.println("La lista esta llena");
		}
	}
	
	public void MostrarServicios() {
	int p=0;
	   while(p<numServicios) {
		   if(lista[p].getEstado().equalsIgnoreCase("Activo")) {			 
			   System.out.println(lista[p].toString());
		   }
		   p++;
	   }
	}
	
	public void DesactivarServicio(String s) {
		int p=0;
		   while(p<numServicios) {
			   if(lista[p].getId().equalsIgnoreCase(s)) {			 
				   lista[p].setEstado("Inactivo");
			   }
			   p++;
		   }
	}
	
	public void EscribeServicio () throws IOException{
		BufferedWriter g=new BufferedWriter(new FileWriter("Servicios.txt"));
		int i=0;
		while(i<numServicios) {
		String frase=lista[i].getId()+";"+lista[i].getDes()+";"+lista[i].getDataOf()+";"+lista[i].getFechaVigencia()+";"+lista [i].getIntercanvioPrevio()+";"+lista[i].getEstado();
		System.out.println("Se ha escrito la linea: "+ lista[i]);
	    g.write(frase);
	    g.newLine();
	    i++;
		}
		g.close();
		
	}
	
	public void LeerServicio () throws IOException{
		BufferedReader f=new BufferedReader(new FileReader("Servicios.txt"));
		String frase ;
		int i=0;
		frase=f.readLine();
		while (frase!=null) {
		System.out.println("Se ha leido la linea: "+ frase);
		StringTokenizer st = new StringTokenizer(frase,";");
		String id=st.nextToken();
		String des=st.nextToken();
		String[] S=st.nextToken().split("/");
		String[] S2=st.nextToken().split("/");
		boolean in=Boolean.parseBoolean(st.nextToken());
		String e=st.nextToken();
		Data d1=new Data(Integer.parseInt(S[0]),Integer.parseInt(S[1]),Integer.parseInt(S[2]));
		Data d2=new Data(Integer.parseInt(S2[0]),Integer.parseInt(S2[1]),Integer.parseInt(S2[2]));
		Servicios p=new Servicios(id, des, d1, d2);
	    AnadirServicio(p);
		p.setEstado(e);
		p.setIntercanvioPrevio(in);
		
		 frase=f.readLine();
		}
		f.close();
		}
}
