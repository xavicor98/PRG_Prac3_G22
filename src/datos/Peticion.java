package datos;

import java.util.Random;
/* Programador: Juan Ignasi Cid Guardia */
public class Peticion {
	
	private String id;
	private Usuario proveedor;
	private Usuario cliente;
	//Discernir entre productos
	private Productos prodOfrecido;
	private Productos prodPedido;
	//Y servicios
	private Servicios servicioOfrecido;
	private Servicios servicioPedido;
	
	private int estadoPeticion = 0;
	private int valoracion;
	

	
//Constructor en caso de pasarle un producto
	public Peticion(String id, Usuario proveedor, Usuario cliente, Productos prodPedido, Productos prodOfrecido) {
		this.id = randomCharArray(5);
		this.proveedor = proveedor;
		this.cliente = cliente;
		this.prodPedido = prodPedido;
		this.prodOfrecido = prodOfrecido;
	}

	//Constructor en caso de pasarle un servicio
		public Peticion(String id, Usuario proveedor, Usuario cliente, Servicios servicioPedido, Servicios servicioOfrecido) {
			this.id = randomCharArray(5);
			this.proveedor = proveedor;
			this.cliente = cliente;
			this.servicioPedido = servicioPedido;
			this.servicioOfrecido = servicioOfrecido;
		}
	//Rechaza la peticion
	public void acepta() {
		estadoPeticion = 1;
	}
	
	//Acepta la peticion
	public void rechaza() {
		estadoPeticion = -1;
	}
	
	//TODO revisar esto
	//devuelve una copia de la peticion dependiendo si contiene un servicio o un bien
	protected Peticion copia() {
		if(servicioPedido == null)
			return new Peticion(id, proveedor, cliente, prodPedido, prodOfrecido);
		else {
			return new Peticion(id, proveedor, cliente, servicioPedido, servicioOfrecido);
		}
	}

	@Override
	public String toString() {
		String infoEstado = "";
		String retorno = "";;
		switch (estadoPeticion) {
			case -1: {
				infoEstado = "no aceptada";
				break;
			}
			case -2:{
				infoEstado = "peticion publicada y no visualizada";
				break;
			}
			case 0: {
				infoEstado = "peticion visualizada";

				break;
			}
			case 1: {
				infoEstado = "aceptada";
				break;
			}
		}
		if(servicioPedido == null) {
			retorno= "Peticion con id= "+ id +" "+infoEstado +
					"\n\tcliente=" + cliente.getAlias() + 
					"\n\tservicioPedido=" + prodPedido.getId()+
					"\n\tproveedor=" + proveedor.getAlias() + 
					"\n\tservicioPedido=" + prodOfrecido.getId() +
					retorno;
		}else {
			retorno= "Peticion con id= "+ id +" "+infoEstado +
					"\n\tcliente=" + cliente.getAlias() + 
					"\n\tprodPedido=" + servicioPedido.getId()+
					"\n\tproveedor=" + proveedor.getAlias() + 
					"\n\tprodOfrecido=" + servicioPedido.getId() +
					retorno;
		}
		



		return retorno;
	}

	/**
	 * @return comparador de id del producto, devuelve true si es igual
	 */
	public boolean esEsteId(String id) {
		return id.equalsIgnoreCase(prodOfrecido.getId());
	}
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}


	public Usuario getProveedor() {
		return proveedor;
	}


	public Usuario getCliente() {
		return cliente;
	}

	/* TODO codigo pendiente de revision
	 * 
	 *
	public Producto getProdOfrecido() {
		return prodOfrecido;
	}
	

	public Producto getProdPedido() {
		return prodPedido;
	}
	*/

	public int getEstadoPeticion() {
		return estadoPeticion;
	}
	
	public int getValoracion() {
		return valoracion;
	}
	
	public void setEstadoPeticion(int estadoPeticion) {
		this.estadoPeticion = estadoPeticion;
	}
	
	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}
	
	//Codigo para generar id aleatorio
	public static String randomCharArray(int len) {
		String alphabet =
				"ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
				"abcdefghijklmnopqrstuvwxyz" +
				"0123456789";

		StringBuilder b = new StringBuilder();

		for (int i = 0; i < len; i++) {
			int randIdx = new Random().nextInt(alphabet.length());
			char randChar = alphabet.charAt(randIdx);
			b.append(randChar);
		}

		return b.toString();
	}



	
}

