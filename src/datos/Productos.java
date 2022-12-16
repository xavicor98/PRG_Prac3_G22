package datos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Productos {
	private String Id;
	private String Descripcion;
	private Data DataOferta;
	
	public Productos (String Id, String Des, Data DataOf) {
		this.Id = Id;
		Descripcion = Des;
		DataOferta = DataOf;
		
	}
	// Getters
	public String getId() {
		return Id;
	}
	
	public String getDes() {
		return Descripcion;
	}
	
	public Data getDataOf() {
		return DataOferta;
	}
	// Setters
	public void setId(String Id) {
		this.Id = Id;
	}
	
	public void setDes(String Des) {
		Descripcion = Des;
	}
	
	public void setDataOf(Data DataOf) {
		DataOferta = DataOf;
	
	}
	
	// To String
	public String toString() {
		return " [Id=" + Id + ", Descripcion=" + Descripcion + ", DataOferta=" + DataOferta ;
	}
	
	}



