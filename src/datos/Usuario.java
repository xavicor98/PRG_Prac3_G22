	package datos;

/* Programador: Francisco Manuel Gonzalez Ortegon */

public class Usuario {
	private String alias;
	private String correo;
	private int cp;
	
	private Productos[] productosOfrece;
	private int nProductos;
	
	private Peticion[] peticiones;
	private int nPeticiones;
	
	public Usuario(String alias, String correo, int cp) {
		this.alias = alias;
		this.correo = correo;
		this.cp = cp;
		peticiones = new Peticion[10];
		productosOfrece = new Productos[10];
	}
	
	public Usuario(String alias, String correo, int cp, Peticion[] peticiones, Productos[] productosOfrece) {
		this.alias = alias;
		this.correo = correo;
		this.cp = cp;
		this.peticiones = peticiones;//no le meto copia porque seria informacion redundante, la peticion ya se guarda en su lista correspondiente
		this.productosOfrece = productosOfrece;
		
	}
	

	public void anadirPeticion(Peticion peticion) {
		peticiones[nPeticiones] = peticion.copia();
		nPeticiones++;
		
		if(nPeticiones>peticiones.length) {
			ampliaPeticiones();
		}
	}
	
	//TODO completar clase 
	public void anadirProducto(Productos producto) {
		if(nProductos>productosOfrece.length) {
			Productos[] nuevaLista = new Productos[productosOfrece.length + 20];
			for (int i=0; i<productosOfrece.length;i++) {
				nuevaLista[i] = productosOfrece[i].copia();
			}
			productosOfrece = nuevaLista;
		}
		productosOfrece[nProductos] = producto.copia();
		nProductos++;
		
		
		
	}
	
	public boolean esEsteAlias(String alias) {
		return this.alias.equalsIgnoreCase(alias);
	}
	

	public Usuario copia() {
		return new Usuario(alias, correo, cp, peticiones, productosOfrece);
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
	
	/**
	 * @return el nProductos
	 */
	public int getnProductos() {
		return nProductos;
	}
	
	/**
	 * @return el nPeticiones
	 */
	public int getnPeticiones() {
		return nPeticiones;
	}
	
	/**
	 * @return el id de la peticion i
	 */
	public String getPeticionI(int i) {
		return peticiones[i].getId();
	}
	
	/**
	 * @return el id del prodcto i
	 */
	
	//TODO una vez tenga la clase productos hare
	public String getProductoI(int i) {
		
		return productosOfrece[i].getId();
		
	}
	
	//si no dejan genéricos ni java.array tengo que crear dos clases para cada tipo de lista
	
	private void ampliaPeticiones() {
		Peticion[] nuevaLista = new Peticion[peticiones.length + 20];
		
		for(int i=0; i<peticiones.length; i++) {
			nuevaLista[i] = peticiones[i].copia();
		}
		
		peticiones = nuevaLista;
	}

	public String getProductos() {
		String retorno ="";
		
		for(int i=0; i<nProductos; i++) {
			retorno += productosOfrece[i].getId()+";";
		}
		
		return retorno;
	}
}

