package datos;
/* Programador: Francisco Manuel Gonzalez Ortegon */
public class listaUsuario {
	private usuario[] listaUsuario;
	private int nElems;
	
	public listaUsuario (int n) {
		nElems = 0;
		listaUsuario = new usuario[n];
		
	}
	public void anadirUsuario (usuario user) {
		if (nElems<listaUsuario.length) {
			listaUsuario[nElems] = user;
			nElems ++;
		}
	}
	public void borrarUsuario(usuario user) {
		boolean encontrado = false;
		int i=0;
		while (!encontrado && i<nElems) {
			
			if (user.getAlias().equals(listaUsuario[i].getAlias())) {
				for (int j=i; i<nElems; j++)
				listaUsuario[j]=listaUsuario[j+1];
				encontrado = true;
				
			}
			i++;
		}
	}
	
	//TODO revisar el codigo que te he añadido revisatelo y pon tu nombre

		//Joan Cid
		
	public usuario obtenerUsuario(String alias) {
		usuario retorno = null;
		int i =0;
		while(retorno == null && !(i>nElems)) {
			if(listaUsuario[i].getAlias().equalsIgnoreCase(alias)) {
				retorno = listaUsuario[i].copia();
			}
			i++;
		}
		if(retorno ==null) {
			//Excepcion para decir que no hay este usuario en la lista u algo del estilo
		}
		return retorno;
	}

}
