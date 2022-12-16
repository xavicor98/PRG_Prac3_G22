package datos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/* Programador: Eloi Cuevas Marcos */
public class Servicios extends Productos {
	private Data FechaVigencia;
	private boolean IntercanvioPrevio;
	protected  String estado;
	public Servicios(String id,String de,Data d,Data FechaVi) {
		super(id, de,d );
		FechaVigencia = FechaVi;
		IntercanvioPrevio = false;
		estado="Activo";
	}

	public Data getFechaVigencia() {
		return FechaVigencia;
	}

	public void setFechaVigencia(Data fechaVigencia) {
		FechaVigencia = fechaVigencia;
	}

	public boolean getIntercanvioPrevio() {
		return IntercanvioPrevio;
	}

	public void setIntercanvioPrevio(boolean intercanvioPrevio) {
		IntercanvioPrevio = intercanvioPrevio;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String toString() {
		return "Servicio " + super.toString()+", FechaVigencia= "+ FechaVigencia + ", IntercanvioPrevio=" + IntercanvioPrevio+", estado="+estado+"]";
	}
}
