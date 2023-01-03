package datos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/* Programador: Eloi Cuevas Marcos */
public class Servicios extends Productos {
	private Data fechaVigencia;
	private boolean intercanvioPrevio;
	protected  String estado;
	public Servicios(String id,String desc,Data d,Data fechaVi) {
		super(id, desc,d );
		fechaVigencia = fechaVi;
		intercanvioPrevio = false;
		estado="Activo";
	}

	public Data getFechaVigencia() {
		return fechaVigencia;
	}

	public void setFechaVigencia(Data fechaVigencia) {
		this.fechaVigencia = fechaVigencia;
	}

	public boolean getIntercanvioPrevio() {
		return intercanvioPrevio;
	}

	public void setIntercanvioPrevio(boolean intercanvioPrevio) {
		this.intercanvioPrevio = intercanvioPrevio;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Servicios copia() {
		Servicios nova=new Servicios(this.getId(), this.getDes(), this.getDataOf(), fechaVigencia);
		
		return(nova);
	}

	public String toString() {
		return "Servicio " + super.toString()+", FechaVigencia= "+ fechaVigencia + ", IntercanvioPrevio=" + intercanvioPrevio+", estado="+estado+"]";
	}
}
