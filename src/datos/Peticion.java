package datos;

import java.util.Random;
/* Programador: Juan Ignasi Cid Guardia */
public class Peticion {
	
	private String id;
	private Usuario proveedor;
	private Usuario cliente;
	private Producto prodOfrecido;
	private Producto prodPedido;
	private int estadoPeticion = 0;
	private int valoracion;
	

	

	public Peticion(String id, Usuario proveedor, Usuario cliente, Producto prodPedido, Producto prodOfrecido) {
		this.id = randomCharArray(5);
		this.proveedor = proveedor;
		this.cliente = cliente;
		this.prodPedido = prodPedido;
		this.prodOfrecido = prodOfrecido;
	}

	
	//Rechaza la peticion
	public void acepta() {
		estadoPeticion = 1;
	}
	
	//Acepta la peticion
	public void rechaza() {
		estadoPeticion = -1;
	}
	
	
	//devuelve una copia de la peticion
	protected Peticion copia() {
		return new Peticion(id, proveedor, cliente, prodPedido, prodOfrecido);
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
		retorno= "Peticion con id= "+ id +" "+infoEstado +
				"\n\tcliente=" + cliente.getnUsuario() + 
				"\n\tprodPedido=" + prodPedido.getnProducto()+
				"\n\tproveedor=" + proveedor.getnUsuario() + 
				"\n\tprodOfrecido=" + prodOfrecido.getnProducto() +
				retorno;



		return retorno;
	}

	/**
	 * @return comparador de id del producto, devuelve true si es igual
	 */
	public boolean esEsteId(String id) {
		return id.equalsIgnoreCase(prodOfrecido.getnProducto());
	}
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the usuario
	 */
	public Usuario getProveedor() {
		return proveedor;
	}

	/**
	 * @return the proveedor
	 */
	public Usuario getCliente() {
		return cliente;
	}

	/**
	 * @return the prodOfrecido
	 */
	public Producto getProdOfrecido() {
		return prodOfrecido;
	}
	
	/**
	 * @return the prodPedido
	 */
	public Producto getProdPedido() {
		return prodPedido;
	}

	/**
	 * @return the estadoPeticion
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


	/**
	 * @param estadoPeticion the estadoPeticion to set
	 */

	
}

