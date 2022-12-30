	package datos;

/* Programador: Joan Ignasi Cid guardia */

public class Usuario {
	String alias;
	String correo;
	int cp;
	
	//Lista de productos
	int nProductos;
	
	Peticion[] peticiones;
	int nPeticiones;
	
	public Usuario(String alias, String correo, int cp) {
		this.alias = alias;
		this.correo = correo;
		this.cp = cp;
		peticiones = new Peticion[10];
		//para lista de productos lo mismo
	}
	
	public Usuario(String alias, String correo, int cp, Peticion[] peticiones/*, La clase del producto*/) {
		this.alias = alias;
		this.correo = correo;
		this.cp = cp;
		this.peticiones = peticiones;		//no le meto copia porque seria informacion redundante, la peticion ya se guarda en su lista correspondiente
		//para lista de productos lo mismo
	}
	

	public void anadirPeticion(Peticion peticion) {
		peticiones[nPeticiones] = peticion.copia();
		nPeticiones++;
		
		if(nPeticiones>peticiones.length) {
			ampliaPeticiones();
		}
	}
	
	//TODO completar clase 
	public void anadirProducto(/*clase productos*/) {
		//Lo mismo pero para los productos
	}
	
	public boolean esEsteAlias(String alias) {
		return this.alias.equalsIgnoreCase(alias);
	}
	

	public Usuario copia() {
		return new Usuario(alias, correo, cp, peticiones/*, La clase del producto*/);
	}
	
	/**
	 * @return el alias
	 */
	public String getAlias() {
		return alias;
	}

	/**
	 * @return el correo
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * @return el cp
	 */
	public int getCp() {
		return cp;
	}
	
	//si no dejan genéricos ni java.array tengo que crear dos clases para cada tipo de lista
	
	private void ampliaPeticiones() {
		Peticion[] nuevaLista = new Peticion[peticiones.length + 20];
		
		for(int i=0; i<peticiones.length; i++) {
			nuevaLista[i] = peticiones[i].copia();
		}
		
		peticiones = nuevaLista;
	}
	
	//lo mismo para la lista de productos
}
