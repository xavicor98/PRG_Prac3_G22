package datos;

import java.util.Random;
/* Programador: Juan Ignasi Cid Guardia */
public class Peticion {
	
	private String id;
	private String proveedor;
	private String cliente;
	//Discernir entre productos
	private String bienOfrecido;
	private String bienPedido;
	//Y servicios

	private int estadoPeticion = 0;
	private int valoracion;
	

	
//Constructor en caso de pasarle un producto
	public Peticion(String id, String proveedor, String cliente, String prodPedido, String prodOfrecido) {
		this.id = id;
		this.proveedor = proveedor;
		this.cliente = cliente;
		this.bienPedido = prodPedido;
		this.bienOfrecido = prodOfrecido;
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
		return bienOfrecido;
	}
	
	public String getProdPedido() {
		return bienPedido;
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
					+ ", bienOfrecido="	+ bienOfrecido 
					+ ", bienPedido=" + bienPedido 
					+ ", estadoPeticion=" + estadoPeticion 
					+ ", valoracion="+ valoracion;
		} catch (Exception e) {
			System.out.println("En la peticion: "+id+" hace falta informacion");
		}
		
		return retorno;
	}

/**	No hace falta generar un id aleatorio porque el id lo pone el usuario.
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
**/
	
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


	public Peticion copia() {
		Peticion retorno = new Peticion(id, proveedor, cliente, bienPedido, bienOfrecido);
		retorno.setEstadoPeticion(estadoPeticion);
		retorno.setValoracion(valoracion);
		return retorno;
	}


	public boolean esEsteId(String id2) {
		
		return this.id.equalsIgnoreCase(id2);
	}

	
}

