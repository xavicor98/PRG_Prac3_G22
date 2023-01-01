package datos;

import java.io.*;

/* Programador: Francisco Manuel Gonzalez Ortegon */
public class listaUsuario {
	private int nElementos;
	private Usuario[] listaUsuarios;
	
	public listaUsuario() {
		
		listaUsuarios = new Usuario [20];
	}
	
	
	public void anadirUsuario(Usuario usuario) {
		listaUsuarios[nElementos] = usuario.copia();
		nElementos++;
		
		if(nElementos == listaUsuarios.length) {
			ampliaLista();
		}
	}
	
	//TODO si hace fata otro constructor en caso de no tener una instancia de usuario ya se creara uno nuevo
	
	private void ampliaLista() {
		Usuario[] temp = new Usuario[listaUsuarios.length+20];
		
		for(int i = 0; i<listaUsuarios.length; i++) 
			temp[i] = listaUsuarios[i].copia();
		
		listaUsuarios = temp;
		
	}

	public int  buscaUsuario(String alias) {
		int i=0;
		boolean trobat = false;
		while(i<nElementos && trobat == false) {
			if(listaUsuarios[i].esEsteAlias(alias))
				trobat = true;
			else
				i++;
		}
		if(i==nElementos)
			i=-1;
		
		return i;
	}
	
	public void escribeFichero(String fichero) throws IOException {
		BufferedWriter w = new BufferedWriter(new FileWriter(fichero+".csv"));

		w.write(nElementos+";");
		w.newLine();
		
		for(int i=0; i<nElementos; i++) {
			w.write(listaUsuarios[i].getAlias()+";");
			w.write(listaUsuarios[i].getCorreo()+";");
			w.write(listaUsuarios[i].getCp()+";");
			
			w.write(listaUsuarios[i].getnProductos()+";");
			for(int j=0; j<listaUsuarios[i].getnProductos(); j++) 
				w.write(listaUsuarios[i].getProductoI(j)+";");
			
			w.write(listaUsuarios[i].getnPeticiones()+";");
			for(int j=0; j<listaUsuarios[i].getnPeticiones(); j++) 
				w.write(listaUsuarios[i].getPeticionI(j)+";");
		
			w.newLine();
		}
		
		w.close();
		
	}
	
}
	
