package excepciones;
import datos.*;

public class ListaLlena extends Exception {
	public ListaLlena (Productos i) {
		
		super("No puedo añadir "+i.toString()+" porque la lista esta llena");
		
	
	}

}
