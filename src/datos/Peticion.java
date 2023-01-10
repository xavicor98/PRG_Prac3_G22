package datos;

/**
 * The Class Peticion.
 */
/* Programador: Juan Ignasi Cid Guardia */
public class Peticion {
	
	/** El id. */
	private String id;
	
	/** El proveedor. */
	private String proveedor;
	
	/** El cliente. */
	private String cliente;
	
	/** El bien ofrecido. */
	//Discernir entre productos
	private String bienOfrecido;
	
	/** El bien pedido. */
	private String bienPedido;
	//Y servicios

	/** El estado de la peticion. */
	private int estadoPeticion = 0;
	
	/** La valoracion. */
	private int valoracion;
	


	/*
	 * Instancia una nueva peticion.
	 *
	 * @param id el id
	 * @param proveedor el proveedor
	 * @param cliente el cliente
	 * @param prodPedido el producto pedido
	 * @param prodOfrecido el producto ofrecido
	 */
	//Constructor en caso de pasarle un producto
	public Peticion(String id, String proveedor, String cliente, String prodPedido, String prodOfrecido) {
		this.id = id;
		this.proveedor = proveedor;
		this.cliente = cliente;
		this.bienPedido = prodPedido;
		this.bienOfrecido = prodOfrecido;
	}

	/**
	 * acepta la peticion.
	 */
	//Rechaza la peticion
	public void acepta() {
		estadoPeticion = 1;
	}
	
	/**
	 * rechaza la peticion.
	 */
	//Acepta la peticion
	public void rechaza() {
		estadoPeticion = -1;
	}
	
	/**
	 * Get id.
	 *
	 * @return el id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Get proveedor.
	 *
	 * @return el proveedor
	 */
	public String getProveedor() {
		return proveedor;
	}

	/**
	 * Get el cliente.
	 *
	 * @return el cliente
	 */
	public String getCliente() {
		return cliente;
	}

	/**
	 * Get producto ofrecido.
	 *
	 * @return el producto ofrecido
	 */
	public String getProdOfrecido() {
		return bienOfrecido;
	}
	
	/**
	 * Gets el producto pedido.
	 *
	 * @return el producto pedido
	 */
	public String getProdPedido() {
		return bienPedido;
	}
	
	/**
	 * Gets the estado peticion.
	 *
	 * @return the estado peticion
	 */
	public int getEstadoPeticion() {
		return estadoPeticion;
	}
	
	/**
	 * Get la valoracion.
	 *
	 * @return la valoracion
	 */
	public int getValoracion() {
		return valoracion;
	}
	
	/**
	 * Set el estado peticion.
	 *
	 * @param estadoPeticion
	 */
	public void setEstadoPeticion(int estadoPeticion) {
		this.estadoPeticion = estadoPeticion;
	}
	
	/**
	 * Set valoracion.
	 *
	 * @param valoracion 
	 */
	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}
	

	/**
	 * To string.
	 *
	 * @return la informacion completa de la instancia
	 */
	@Override
	public String toString() {
		String retorno = "";
		
		try {
			retorno = "Peticion:"
					+ "id=" + id 
					+ ", proveedor=" + proveedor
					+ ", cliente=" + cliente
					+ ", bienOfrecido="	+ bienOfrecido 
					+ ", bienPedido=" + bienPedido 
					+ ", estadoPeticion=" + estadoPeticion 
					+ ", valoracion="+ valoracion;
		} catch (Exception e) {
			System.out.println("En la peticion: "+id+" hace falta informacion");
		}
		
		return retorno;
	}


	/**
	 * Get el serializado.
	 *
	 * @return el serializado, este sirve para ayudar en caso de necesitar tener la informacion separada por ";"
	 */
	public String getSerializado() {
		String retorno ="";
		
		try {
			retorno = (
							id+";"
							+proveedor+";"
							+cliente+";"
							+bienOfrecido+";"
							+bienPedido+";"
							+estadoPeticion+";"
							+valoracion

					);
					
		} catch (Exception e) {
			System.out.println("En la peticion: "+id+" hace falta informacion");
		}
		
		return retorno;
	}


	/**
	 * Copia.
	 *
	 * @return una copia de la clase
	 */
	public Peticion copia() {
		Peticion retorno = new Peticion(id, proveedor, cliente, bienPedido, bienOfrecido);
		retorno.setEstadoPeticion(estadoPeticion);
		retorno.setValoracion(valoracion);
		return retorno;
	}


	/**
	 * Es este id.
	 *
	 * @param el id a comparar
	 * @return true, si es el id por parametro el mismo que el de la instancia
	 */
	public boolean esEsteId(String id2) {
		
		return this.id.equalsIgnoreCase(id2);
	}

	
}

