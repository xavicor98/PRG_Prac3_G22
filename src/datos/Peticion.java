package datos;

import java.util.Random;
/* Programador: Juan Ignasi Cid Guardia */
public class Peticion {
	
	private String id;
	private String proveedor;
	private String cliente;
	//Discernir entre productos
	private String prodOfrecido;
	private String prodPedido;
	//Y servicios
	private String servicioOfrecido;
	private String servicioPedido;
	
	private int estadoPeticion = 0;
	private int valoracion;
	

	
//Constructor en caso de pasarle un producto
	public Peticion(String id, String proveedor, String cliente, String prodPedido, String prodOfrecido) {
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
	




	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	public String getProveedor() {
		return proveedor;
	}

	public String getCliente() {
		return cliente;
	}

	public String getProdOfrecido() {
		return prodOfrecido;
	}
	
	public String getProdPedido() {
		return prodPedido;
	}
	
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
	

	@Override
	public String toString() {
		String retorno = "";
		
		try {
			retorno = "Peticion:"
					+ "id=" + id 
					+ ", proveedor=" + proveedor
					+ ", cliente=" + cliente
					+ ", prodOfrecido="	+ prodOfrecido 
					+ ", prodPedido=" + prodPedido 
					+ ", servicioOfrecido=" + servicioOfrecido
					+ ", servicioPedido=" + servicioPedido 
					+ ", estadoPeticion=" + estadoPeticion 
					+ ", valoracion="+ valoracion;
		} catch (Exception e) {
			System.out.println("En la peticion: "+id+" hace falta informacion");
		}
		
		return retorno;
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

	
	public String getSerializado() {
		String retorno ="";
		
		try {
			retorno = (
							id+";"
							+proveedor+";"
							+cliente+";"
							+prodOfrecido+";"
							+prodPedido+";"
							+servicioOfrecido+";"
							+servicioPedido+";"
							+estadoPeticion+";"
							+valoracion

					);
					
		} catch (Exception e) {
			System.out.println("En la peticion: "+id+" hace falta informacion");
		}
		
		return retorno;
	}


	public Peticion copia() {
		Peticion retorno = new Peticion(id, proveedor, cliente, prodPedido, prodOfrecido);
		return retorno;
	}


	public boolean esEsteId(String id2) {
		
		return this.id.equalsIgnoreCase(id2);
	}

	
}

