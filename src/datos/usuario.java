	package datos;
import java.util.Arrays;
/* Programador: Francisco Manuel Gonzalez Ortegon */
public class usuario {
	private String alias;
	private String mail;
	private String codigoPostal;
	private ListaProductos listaPo;
	private ListaProductos listaInt;
	private int nPo, nPi;
	
	
	
	public usuario (String nom, String correo, String cp, ListaProductos productosOfrece, ListaProductos intercambiados) {
		alias = nom;
		mail = correo;
		codigoPostal = cp;
		listaPo = productosOfrece;
		listaInt = intercambiados;
		nPi = 0;
		nPo = 0;
	}
	
	public String getAlias(){
		return alias;
	}
	public String getMail(){
		return mail;
	}
	public String getCodigoPostal(){
		return codigoPostal;
	}
	
	public void setAlias(String n) {
		alias = n;
	}
	public void setMail(String n) {
		mail=n;
	}
	public void setCodigoPostal(String n) {
		codigoPostal=n;
	}
	public void anadirProductoO (producto p) {
		if (nPo<listaPo.length) {
			listaPo[nPo]=p;
		}
	}
	public void anadirProductoI (producto p) {
		if (nPi<listaInt.length) {
			listaInt[nPi]=p;
		}
	}
	public String toString () {
		return("[alias = "+ alias +", correo = "+ mail +", codigo postal = "+ codigoPostal +", productos que ofrece = "+ Arrays.toString(listaP) 
		+", productos intercambiados = "+ Arrays.toString(listaInt) +"]");
	}

}
