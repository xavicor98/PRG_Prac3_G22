package datos;
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
		if(nElementos >listaUsuarios.length) {
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
}
	
