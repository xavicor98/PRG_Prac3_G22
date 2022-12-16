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
	

}
