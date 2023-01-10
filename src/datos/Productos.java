package datos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public abstract class Productos {
	private String id;
	private String descripcion;
	private Data dataOferta;
	
	public Productos (String id, String des, Data dataOf) {
		this.id = id;
		descripcion = des;
		dataOferta = dataOf;
	}
	// Getters
	public String getId() {
		return  id;
	}
	
	public String getDes() {
		return descripcion;
	}
	
	public Data getDataOf() {
		return dataOferta;
	}
	// Setters
	public void setId(String id) {
		this.id = id;
	}
	
	public void setDes(String des) {
		descripcion = des;
	}
	
	public void setDataOf(Data dataOf) {
		dataOferta = dataOf;
	}
	
	// To String
	public String toString() {
		return " [Id=" + id + ", Descripcion=" + descripcion + ", DataOferta=" + dataOferta ;
	}	
}