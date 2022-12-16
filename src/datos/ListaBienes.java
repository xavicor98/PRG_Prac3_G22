package datos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;
/* Programador: Eloi Cuevas Marcos */
public class ListaBienes {
	private int numBienes;
	private Bienes[] lista;
	
	public ListaBienes(int n) {
		lista = new Bienes[n];
	}
	
	public int getNumBienes() {
		return numBienes;
	}
	
	public String toString() {
		String aux;
			aux= "ListaProductos numProductos=" + numBienes;
			for (int j = 0; j < numBienes; j++) {
				aux = aux + "\n\tProducto: " + (j + 1) + "\t " + lista[j];
			}
		    return	aux;
	}
	
	public void AnadirBienes(Bienes p ) {
		if (numBienes != lista.length) {
			lista[numBienes]=p;
			numBienes++;
		}
		else {
			System.out.println("La lista esta llena");
		
		}
		
	}

	public void BorrarBienes(String s) {
		int i = 0;
		while (i < numBienes) {
			if (lista[i].getId().equalsIgnoreCase(s)) {
				for (int j = i; j < numBienes - 1; j++) {
					lista[j] = lista[j + 1];
				}
				numBienes--;
			} else
				i++;
		}
	}
		
	public void EscribeBien () throws IOException{
		BufferedWriter g=new BufferedWriter(new FileWriter("Bienes.txt"));
		int i=0;
		while(i<numBienes) {
			String frase=lista[i].getId()+";"+lista[i].getDes()+";"+lista[i].getDataOf()+";"+lista[i].getDimension(0)+";"+lista[i].getDimension(1)+";"+lista[i].getDimension(2)+";"+lista[i].getPeso()+";"+lista[i].getIntercanvio();
			System.out.println("Se ha escrito la linea: "+ lista[i]);
		    g.write(frase);
		    g.newLine();
		    i++;
		}
		g.close();	
	}
	
	public void LeerBien () throws IOException{
		BufferedReader f=new BufferedReader(new FileReader("Bienes.txt"));
		String frase ;
		int i=0;
		frase=f.readLine();
		while (frase!=null) {
			System.out.println("Se ha leido la linea: "+ frase);
			StringTokenizer st = new StringTokenizer(frase,";");
			String id=st.nextToken();
			String des=st.nextToken();
			String[] S=st.nextToken().split("/");
			int d1=Integer.parseInt(st.nextToken());
			int d2=Integer.parseInt(st.nextToken());
			int d3=Integer.parseInt(st.nextToken());
			int p=Integer.parseInt(st.nextToken());
			String[] S2=st.nextToken().split("/");
			Data D1=new Data(Integer.parseInt(S[0]),Integer.parseInt(S[1]),Integer.parseInt(S[2]));
			Data D2=new Data(Integer.parseInt(S2[0]),Integer.parseInt(S2[1]),Integer.parseInt(S2[2]));
			Bienes B=new Bienes(id, des, D1, d1, d2, d3, p, D2);
		    AnadirBienes(B);
			
			frase=f.readLine();
		}
		f.close();
	}
}